package resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class JongkoResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return "Hello, world! from Pisjongkopet";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String request) {
        try {
            Gson gson = new Gson();
            LoginData data = gson.fromJson(request, LoginData.class);
            JsonObject response = new JsonObject();
            response.addProperty("status", "SUCCESS");
            response.addProperty("message", data.getEmail() + " logged in.");
            return Response.ok(response.toString()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}

class LoginData {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}