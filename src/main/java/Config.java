package common;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jongko.JongkoService;
import jongko.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Config {
    private final JongkoService jongkoService = new JongkoService();

    @Path("test")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return "Hello, world! from Pisjongkopet";
    }

    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String request) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(request).getAsJsonObject();

            User data = new User();
            data.setEmail(object.get("email").getAsString());
            data.setPassword(object.get("password").getAsString());

            return Response.ok(jongkoService.login(data)).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @Path("signup")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signup(String request) {
        try {
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}