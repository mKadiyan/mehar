package com.rsk.mehar.hmijetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogSF;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloHandler extends AbstractHandler
{
    static int index = 0;
    private static final Logger LOGGER = Logger.getLogger(HelloHandler.class);
    
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        System.err.println("index is : " + index++);
        if (LOGGER.isInfoEnabled())
        {
            LogSF.info(LOGGER, "Request came :target = {} , baseRequest={} ,request={}", target, baseRequest, request);
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello RSK</h1>");
    }
}