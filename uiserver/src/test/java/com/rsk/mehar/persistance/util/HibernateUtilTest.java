/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.util;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * HibernateUtil test cases
 * 
 * @author ravinder
 *
 */
public class HibernateUtilTest
{
    
    @Before
    public void setup()
    {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.DEBUG);
    }
    
    @Test
    public void getSessionFactory_sessionFactoryExist()
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        assertNotNull(sessionFactory);
    }
    
    @After
    public void tearDown() throws Exception
    {
        HibernateUtil.shutdown();
    }
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
