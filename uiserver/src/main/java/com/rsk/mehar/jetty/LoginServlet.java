/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.jetty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.rsk.mehar.helper.LoginHandler;

public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        LOGGER.info("in doGet");
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LOGGER.info("in doPost ");
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        JSONObject jsonResult = new LoginHandler().doLogin(request);
        out.write(jsonResult.toJSONString());
        out.flush();
        out.close();
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
