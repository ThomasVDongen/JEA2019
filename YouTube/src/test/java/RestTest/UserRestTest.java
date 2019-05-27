/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestTest;

import DTO.RegisterDTO;
import DTO.UserDTO;
import java.sql.Date;
import java.time.LocalDate;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Laptop_Thomas
 */
public class UserRestTest {

    String baseUrl = "http://localhost:8080/YouTube/api/user/";

   /*@Test
    public void getUserTest() {
        Assert.assertEquals(200, this.getUser("1").getStatus());
    }
*/
    private Response getUser(String id) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        WebTarget target = client.target(baseUrl + "?id=" + id);
        Invocation.Builder builder = target.request();
        return builder.get();
    }

}
