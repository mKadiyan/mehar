/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MyServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = Logger.getLogger(MyServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        LOGGER.info("in doGet");
        // super.doGet(req, resp);
        // resp.sendRedirect("./index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        LOGGER.info("in doPost");
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException
    {
        super.init();
    }
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
