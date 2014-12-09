/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rsk.mehar.persistance.exception.DuplicateUserException;
import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.util.HibernateUtil;

public class CardentialOperationsIT extends TestBase
{
    private CardentialOperations cardentialOperations;
    private final String password = "password";
    
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
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */

