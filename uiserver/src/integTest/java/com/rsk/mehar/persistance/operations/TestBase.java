/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.rsk.mehar.persistance.util.HibernateUtil;

/**
 * Integration Test base class
 * 
 * @author ravinder
 *
 */
public class TestBase
{
    protected final String emailId = "_test@gmail.com";
    protected List<String> tempUsers = new ArrayList<String>();
    
    @BeforeClass
    public static void init()
    {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
    }
    
    @AfterClass
    public static void shutdown()
    {
        HibernateUtil.shutdown();
    }
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
