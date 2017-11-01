import bobosama.BoboService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jongko.JongkoService;
import jongko.JongkoServiceImpl;
import jongko.JongkoServiceMock;
import bobosama.Request;
import jongko.JongkoServiceImpl;
import jongko.JongkoServiceMock;
import jongko.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Config {
    private final BoboService boboService = new BoboService();
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
    @Path("request")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response request(String data) {
        try{
            Gson gson = new Gson();
            Request request = gson.fromJson(data, Request.class);

            request.setEmail(request.getEmail());
            request.setPenyakit(request.getPenyakit());
            request.setKeluhan(request.getKeluhan());
            request.setKeterangan(request.getKeterangan());
            request.setLongitude(request.getLongitude());
            request.setLatitude(request.getLatitude());
            request.setTimestamp(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
            request.setStatus(0);

            return Response
                    .ok(boboService.request(request))
                    .build();
        } catch (Exception e){
            return Response.serverError().build();
        }
    }
    @Path("viewreq")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewReq(){
        try{
            return Response
                    .ok(boboService.view())
                    .build();
        } catch (Exception e){
            return Response.serverError().build();
        }
    }
}