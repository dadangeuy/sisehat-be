// Login & Signup Services

package jongko;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.net.URISyntaxException;

public class Service {
    public static void main(String[] args) throws Exception {
        try {
            JettyHttpContainerFactory.createServer(new URI("http://localhost:2000"), new ResourceConfig(Config.class));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MongoClient mongo = new MongoClient();
        MongoDatabase db = mongo.getDatabase("sisehat");
        //DBCollection collection = db.getCollection("user");

        String email = "hallofrieda@gmail.com";
        String password = "asdfcd";

    }
}

