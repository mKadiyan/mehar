package com.rsk.mehar.jetty;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;

public class SimpleServer
{
    private static final Logger LOGGER = Logger.getLogger(SimpleServer.class);
    
    public static void main(String[] args) throws Exception
    {
        SimpleServer simplestServer = new SimpleServer();
        simplestServer.startServer();
    }
    
    public void startServer() throws Exception
    {
        if (LOGGER.isInfoEnabled())
            LOGGER.info("Starting server");
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        if (LOGGER.isInfoEnabled())
            LOGGER.info("Handler added ");
        server.start();
        if (LOGGER.isInfoEnabled())
            LOGGER.info("Server started");
        server.join();
        
    }
}