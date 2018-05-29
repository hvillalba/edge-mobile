/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.edge.mobile.restapi.services;


import java.util.List;
import py.hvillalba.edge.mobile.dto.Request;
import py.hvillalba.edge.mobile.dto.Response;
import py.hvillalba.edge.mobile.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
/**
 *
 * @author hectorvillalba
 */
public interface UserService {
    
   
    @GET("users")
    public Call<List<User>> getUser();

}