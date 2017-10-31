// Login & Signup Services

import org.apache.commons.cli.*;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            Options options = new Options();
            options.addOption("PORT", true, "Specify Used Port");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            int port = Integer.valueOf(cmd.getOptionValue("PORT"));

            URI baseUri = UriBuilder.fromUri("http://localhost/").port(port).build();
            JettyHttpContainerFactory.createServer(baseUri, new ResourceConfig(Config.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

