/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.jetty;

import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.operations.CardentialOperations;
import com.rsk.mehar.persistance.util.HibernateUtil;
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

public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        LOGGER.info("in doGet");
        // super.doGet(req, resp);
        // resp.sendRedirect("./index.html");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LOGGER.info("in doPost ");
        StringBuffer sb = new StringBuffer();

        try
        {
            BufferedReader reader = request.getReader();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line);
            }
        } catch (Exception e) { e.printStackTrace(); }
        LOGGER.info("in doPost "+sb.toString());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = (JSONObject)JSONValue.parse(sb.toString());
        String userName = (String)jsonObject.get("userName");
        String password = (String)jsonObject.get("password");
        CardentialOperations operations = new CardentialOperations(HibernateUtil.getSessionFactory());
        try {
            boolean result = operations.isValidCardentials(userName, password);
            if(result)
                out.write("Successful Login");
            else
                out.write("Invalid cardentials");
        } catch (InvalidUserException e) {
            out.write("User Does not Exist");
        } catch (InvalidCardentialException e) {
            out.write("Password Does not Match");
        }
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
