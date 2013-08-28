package zoid.demo.jetty;

import java.net.SocketException;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class Start {

    /**
     * @param args
     * @throws SocketException
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        try {
            Connector connector = new SocketConnector();
            connector.setPort(8088);
            server.setConnectors(new Connector[]{connector});

            ContextHandlerCollection handlerCollection = new ContextHandlerCollection();

            WebAppContext webapp = new WebAppContext();
            webapp.setContextPath("/");
            webapp.setResourceBase("./jsp");
            webapp.setDefaultsDescriptor("web.xml");
            handlerCollection.addHandler(webapp);

            server.setHandler(handlerCollection);

            server.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


