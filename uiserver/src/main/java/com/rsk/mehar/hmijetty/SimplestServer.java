package com.rsk.mehar.hmijetty;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;

public class SimplestServer
{
    private static final Logger LOGGER = Logger.getLogger(SimplestServer.class);
    
    static
    {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
    }
    
    public static void main(String[] args) throws Exception
    {
        SimplestServer simplestServer = new SimplestServer();
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