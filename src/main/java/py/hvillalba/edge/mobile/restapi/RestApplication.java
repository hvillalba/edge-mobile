/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.edge.mobile.restapi;

import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author hectorvillalba
 */

@ApplicationPath("api")
public class RestApplication extends Application {
    
    public RestApplication(){
          BeanConfig beanConfig = new BeanConfig();
          beanConfig.setVersion("1.0.0");
          beanConfig.setSchemes(new String[]{"http"});
          beanConfig.setHost("192.81.130.21:8080");
          beanConfig.setBasePath("/edge-mobile/api");
          beanConfig.setResourcePackage(UserRest.class.getPackage().getName());
          beanConfig.setTitle("RESTEasy, Swagger and Swagger UI Example");
          beanConfig.setDescription("Sample RESTful API built using RESTEasy, Swagger and Swagger UI");
          beanConfig.setScan(true);
    }
     
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(py.hvillalba.edge.mobile.restapi.UserRest.class);
    }
     
}
