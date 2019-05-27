/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestTest;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Laptop_Thomas
 */
public class VideoRestTest {
    
    String baseUrl = "http://localhost:8080/YouTube/api/video/";

   /* @Test
    public void getVideoTest() {
        Assert.assertEquals(200, this.getVideo("1").getStatus());
    }
*/
    private Response getVideo(String id) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        WebTarget target = client.target(baseUrl + "video?id=" + id);
        Invocation.Builder builder = target.request();
        return builder.get();
    }
    
}
