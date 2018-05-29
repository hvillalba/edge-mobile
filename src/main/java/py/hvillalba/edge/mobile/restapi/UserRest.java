/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.edge.mobile.restapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import py.hvillalba.edge.mobile.dto.Response;
import py.hvillalba.edge.mobile.model.User;
import py.hvillalba.edge.mobile.restapi.services.RestAdapter;
import py.hvillalba.edge.mobile.restapi.services.UserService;
import retrofit2.Call;

/**
 *
 * @author hectorvillalba
 */

@Singleton
@Path("user")
@Api( value = "/user" )
public class UserRest {
    
//    @PersistenceContext(name = "ticektPU")
//    private EntityManager em;
    private Logger logger = Logger.getLogger("UserRest");
    List<User> lista = new ArrayList<>();
    private UserService userService;
    
    
    @GET
    @Path("lista-user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
        @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Error inesperado"),
        @ApiResponse(code = 401, message = "Error generico"),
        @ApiResponse(code = 500, message = "Something wrong in Server")})
    public Response<List<User>> getUser(){
        Response<List<User>> response = new Response<>();
        try {
                userService = RestAdapter.getClient().create(UserService.class);
                Call<List<User>> call = userService.getUser();
                lista = call.execute().body();
            
            response.setCodigo(200);
            response.setData(lista);
            response.setMensaje("Proceso satisfactorio");
            return response;
        } catch (Exception e) {
            logger.warning("Error: " + e.getMessage());
            response.setCodigo(400);
            response.setData(null);
            response.setMensaje("Proceso satisfactorio");
            return response;
        }
    }
}
