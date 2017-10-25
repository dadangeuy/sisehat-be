package jongko;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import common.MongoAccessor;
import common.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Config {
    private final MongoDatabase db;
    private final MongoCollection userCollection;
    private final MongoAccessor loginAccessor;

    public Config() {
        db = new MongoClient("localhost", 27017).getDatabase("sisehat-jongko");
        userCollection = db.getCollection("user");
        loginAccessor = new MongoAccessor(userCollection);
    }

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
            loginAccessor.insert(data);

            JsonObject response = new JsonObject();
            response.addProperty("status", "SUCCESS");
            response.addProperty("message", data.getEmail() + " logged in.");
            return Response.ok(response.toString()).build();
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
            Gson gson = new Gson();
            User data = gson.fromJson(request, User.class);
            JsonObject response = new JsonObject();
            response.addProperty("status", "SUCCESS");
            response.addProperty("message", data.getEmail() + " logged in.");
            return Response.ok(response.toString()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}