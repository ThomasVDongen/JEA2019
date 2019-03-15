/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import io.swagger.jaxrs.config.BeanConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Laptop_Thomas
 */
@ApplicationPath("/api")
public class Rest extends Application {
    
    public Rest(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("2.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/YouTube/api");
        beanConfig.setResourcePackage("rest");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan();
    }
}
