/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.security.Key;
import java.util.HashSet;
import java.util.Set;
import javax.faces.context.FacesContext;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import jwt.SimpleKeyGenerator;
import jwt.UserType;

/**
 *
 * @author Koen
 */
@Provider
@JWTTokenNeeded({UserType.USER, UserType.ADMIN})
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {

    @Inject
    private SimpleKeyGenerator keyGenerator;

    @Context
    ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Check if the HTTP Authorization header is present and formatted correctly.
        //if not there get the value from the facescontext and if then it is still emtpy throw exception
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            FacesContext fc = FacesContext.getCurrentInstance();
            authorizationHeader = (String) fc.getExternalContext().getSessionMap().get("jwt");
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                throw new NotAuthorizedException("Authorization header must be provided!");
            }

        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {
            // Retrieve the roles from the JWTTokenNeeded annotation.
            Class<?> resourceClass = resourceInfo.getResourceClass();
            JWTTokenNeeded jwtClassAnnotation = resourceClass.getAnnotation(JWTTokenNeeded.class);

            Method resourceMethod = resourceInfo.getResourceMethod();
            JWTTokenNeeded jwtMethodAnnotation = resourceMethod.getAnnotation(JWTTokenNeeded.class);

            Set<String> requiredRoles = new HashSet<>();

            // Add required roles from class annotation.
            if (jwtClassAnnotation != null) {
                String[] roles = jwtClassAnnotation.value();
                for (String role : roles) {
                    if (!requiredRoles.contains(role)) {
                        requiredRoles.add(role);
                    }
                }
            }

            // Add required roles from method annotation.
            if (jwtMethodAnnotation != null) {
                String[] roles = jwtMethodAnnotation.value();
                for (String role : roles) {
                    if (!requiredRoles.contains(role)) {
                        requiredRoles.add(role);
                    }
                }
            }

            // Validate the token
            Key key = keyGenerator.generateKey();

            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

            String tokenRoles = claims.get("groups", String.class);

            if (tokenRoles == null || tokenRoles.isEmpty()) {
                throw new NotAuthorizedException("Missing roles in token!");
            }

            String[] splittedTokenRoles = tokenRoles.split(";");
            for (String requiredRole : requiredRoles) {
                Boolean hasRole = false;

                for (String tokenRole : splittedTokenRoles) {
                    String trimmedTokenRole = tokenRole.trim();

                    if (trimmedTokenRole.equals(requiredRole)) {
                        hasRole = true;
                    }
                }

                if (!hasRole) {
                    throw new NotAuthorizedException("Not allowed, missing role!");
                }
            }

        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException ex) {
            System.out.println("Invalid token: " + token + ". Error: " + ex.getMessage());
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
