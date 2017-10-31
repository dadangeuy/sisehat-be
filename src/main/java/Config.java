import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jongko.JongkoService;
import jongko.JongkoServiceImpl;
import jongko.JongkoServiceMock;
import jongko.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Config {
    private final JongkoService jongkoService = new JongkoServiceMock();

    // for testing
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() {
        return "Hello, world! from Pisjongkopet";
    }

    // jongko routing
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

            return Response
                    .ok(jongkoService.login(data).build())
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
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
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(request).getAsJsonObject();

            User data = new User();
            data.setEmail(object.get("email").getAsString());
            data.setPassword(object.get("password").getAsString());
            data.setName(object.get("name").getAsString());
            data.setPhone(object.get("phone").getAsString());
            data.setGender(object.get("gender").getAsString());
            data.setBirthdate(object.get("birthdate").getAsLong());

            return Response
                    .ok(jongkoService.signup(data).build())
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
    @Path("profile")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response profile(String request) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(request).getAsJsonObject();

            User data = new User();
            data.setEmail(object.get("email").getAsString());

            return Response
                    .ok(jongkoService.get(data).build())
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}