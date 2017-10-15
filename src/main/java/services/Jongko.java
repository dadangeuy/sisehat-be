// Login & Signup Services

package services;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import resources.JongkoResource;

import java.net.URI;
import java.net.URISyntaxException;

public class Jongko {
    public static void main(String[] args) throws Exception {
        try {
            JettyHttpContainerFactory.createServer(new URI("http://localhost:2000"), new ResourceConfig(JongkoResource.class));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

