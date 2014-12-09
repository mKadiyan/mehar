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
import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.util.HibernateUtil;

public class CardentialOperationsTest
{
    private CardentialOperations cardentialOperations;
    private List<String> tempUsers = new ArrayList<String>();
    private final String emailId = "_test@gmail.com";
    private final String password = "password";
    
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
        tempUsers.add(emailId);
        cardentialOperations.storeCardentials(emailId, password);
        assertTrue(cardentialOperations.isUserExist(emailId));
    }
    
    @Test
    public void checkValidCardential_cardentialShouldExist() throws DuplicateUserException, InvalidUserException,
        InvalidCardentialException
    {
        tempUsers.add(emailId);
        cardentialOperations.storeCardentials(emailId, password);
        assertTrue(cardentialOperations.isValidCardentials(emailId, password));
    }
    
    @Test
    public void changePassword_passwordShouldGetChanged() throws DuplicateUserException, InvalidUserException,
        InvalidCardentialException
    {
        String newPassword = "_newpassword";
        tempUsers.add(emailId);
        cardentialOperations.storeCardentials(emailId, password);
        cardentialOperations.changePassword(emailId, password, newPassword);
        assertTrue(cardentialOperations.isValidCardentials(emailId, newPassword));
        assertFalse(cardentialOperations.isValidCardentials(emailId, password));
    }
    
    @Test
    public void checkInValidPassword_shouldReturnFalse() throws DuplicateUserException, InvalidUserException,
        InvalidCardentialException
    {
        String wrongPassword = "1234567";
        tempUsers.add(emailId);
        cardentialOperations.storeCardentials(emailId, password);
        assertTrue(cardentialOperations.isValidCardentials(emailId, password));
        assertFalse(cardentialOperations.isValidCardentials(emailId, wrongPassword));
    }
    
    @Test(expected = DuplicateUserException.class)
    public void storeCardentialTwice_secondAdditionShouldThrowDuplicateUserException() throws DuplicateUserException, InvalidUserException
    {
        cardentialOperations.storeCardentials(emailId, password);
        assertTrue(cardentialOperations.isUserExist(emailId));
        tempUsers.add(emailId);
        cardentialOperations.storeCardentials(emailId, password);
    }
    
    @Test
    public void checkOfInvalidUser_userShouldNotExist()
    {
        assertFalse(cardentialOperations.isUserExist("_idontexist@gmail.com"));
    }
    
    @Test
    public void deleteCardential_cardentialShouldGetDeleted() throws DuplicateUserException, InvalidUserException
    {
        String emailId = "_delete@gmail.com";
        cardentialOperations.storeCardentials(emailId, password);
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

