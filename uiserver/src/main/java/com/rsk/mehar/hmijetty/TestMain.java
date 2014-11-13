/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.hmijetty;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TestMain
{
    private static final Logger LOGGER = Logger.getLogger(TestMain.class);
    
    static
    {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.DEBUG);
    }
    
    public static void main(String[] args)
    {
        if (LOGGER.isInfoEnabled())
            LOGGER.info("Testting");
    }
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
