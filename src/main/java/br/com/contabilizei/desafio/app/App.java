package br.com.contabilizei.desafio.app;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by contabilizei on 20/01/2017.
 */
public class App {
    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "br.com.contabilizei.desafio.jersey");
        jerseyServlet.setInitOrder(0);

        // Filter for CORS (Cross-Origin Resource Sharing)
        FilterHolder cors = context.addFilter(CrossOriginFilter.class,"/*", EnumSet.of(DispatcherType.REQUEST));
        cors.setInitParameter("Access-Control-Allow-Origin", "*");
        cors.setInitParameter("Access-Control-Allow-Methods", "GET,POST,HEAD,OPTIONS,PUT,DELETE");
        cors.setInitParameter("Access-Control-Allow-Headers", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("Access-Control-Allow-Credentials", "true");

        Server jettyServer = new Server(8080);
        // Create the server level handler list.
        HandlerList handlers = new HandlerList();
        // Make sure DefaultHandler is last (for error handling reasons)
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });

        jettyServer.setHandler(handlers);

        // ---------------------------
        // Start Server
        // ---------------------------
        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }

    }
}
