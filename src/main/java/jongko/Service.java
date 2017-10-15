// Login & Signup Services

package jongko;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.net.URISyntaxException;

public class Service {
    public static void main(String[] args) throws Exception {
        try {
            JettyHttpContainerFactory.createServer(new URI("http://localhost:2000"), new ResourceConfig(Resource.class));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

