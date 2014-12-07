/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rsk.mehar.persistance.exception.DuplicateUserException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.util.HibernateUtil;

public class CardentialOperationsTest
{
    private CardentialOperations cardentialOperations;
    private List<String> tempUsers = new ArrayList<String>();
    
    @BeforeClass
    public static void init()
    {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
    }
    
    @Before
    public void setUp() throws Exception
    {
        cardentialOperations = new CardentialOperations(HibernateUtil.getSessionFactory());
    }
    
    @Test
    public void storeCardential_cardentialShouldGetStored() throws DuplicateUserException, InvalidUserException
    {
        String emailId = "test@gmail.com";
        tempUsers.add(emailId);
        cardentialOperations.storeCardentials(emailId, "password");
        assertTrue(cardentialOperations.isUserExist("test@gmail.com"));
    }
    
    @Test(expected = DuplicateUserException.class)
    public void storeCardentialTwice_secondAdditionShouldThrowDuplicateUserException() throws DuplicateUserException, InvalidUserException
    {
        String emailId = "test@gmail.com";
        cardentialOperations.storeCardentials(emailId, "password");
        assertTrue(cardentialOperations.isUserExist("test@gmail.com"));
        tempUsers.add(emailId);
        cardentialOperations.storeCardentials(emailId, "password");
    }
    
    @Test
    public void checkOfInvalidUser_userShouldNotExist()
    {
        assertFalse(cardentialOperations.isUserExist("idontexist@gmail.com"));
    }
    
    @Test
    public void deleteCardential_cardentialShouldGetDeleted() throws DuplicateUserException, InvalidUserException
    {
        String emailId = "delete@gmail.com";
        cardentialOperations.storeCardentials(emailId, "password");
        assertTrue(cardentialOperations.isUserExist(emailId));
        
        cardentialOperations.deleteCardentials(emailId);
        assertFalse(cardentialOperations.isUserExist(emailId));
        
    }
    
    @After
    public void tearDown() throws Exception
    {
        for (String emailId : tempUsers)
        {
            cardentialOperations.deleteCardentials(emailId);
        }
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
