import bobo.BoboService;
import bobo.BoboServiceImpl;
import bobo.BoboServiceMock;
import bobo.RequestDoctor;
import com.google.gson.Gson;
import jongko.JongkoService;
import jongko.JongkoServiceMock;
import jongko.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Config {
    private final BoboService boboServiceMock = new BoboServiceMock();
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
            Gson gson = new Gson();
            User user = gson.fromJson(request, User.class);
            return Response
                    .ok(jongkoService.login(user).build())
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
            Gson gson = new Gson();
            User user = gson.fromJson(request, User.class);
            return Response
                    .ok(jongkoService.signup(user).build())
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
            Gson gson = new Gson();
            User user = gson.fromJson(request, User.class);
            return Response
                    .ok(jongkoService.get(user).build())
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    // bobo routing
    @Path("request")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response request(String data) {
        try{
            Gson gson = new Gson();
            RequestDoctor requestDoctor = gson.fromJson(data, RequestDoctor.class);
            requestDoctor.setStatus(0);

            return Response
                    .ok(boboServiceMock.request(requestDoctor).build())
                    .build();
        } catch (Exception e){
            return Response.serverError().build();
        }
    }
}