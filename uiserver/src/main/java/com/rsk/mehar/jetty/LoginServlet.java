/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.jetty;

import com.rsk.mehar.helper.LoginHandler;
import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.operations.CardentialOperations;
import com.rsk.mehar.persistance.util.HibernateUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
    }
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("in doGet");
        // super.doGet(req, resp);
        // resp.sendRedirect("./index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    public void init() throws ServletException {
        super.init();
    }
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
