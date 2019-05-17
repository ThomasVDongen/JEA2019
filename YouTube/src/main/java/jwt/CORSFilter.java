
package Filter;


import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter
        implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("access-control-expose-headers", ",Authorization" + ",Content-Length");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        headers.add("Access-Control-Allow-Headers",
                    "Origin"
                    + ",X-Requested-With"
                    + ",x-access-token"
                    + ",Content-Type"
                    + ",Authorization"
                    + ",Accept");
    }
}

