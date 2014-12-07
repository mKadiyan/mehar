/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rsk.mehar.persistance.exception.DuplicateUserException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.util.HibernateUtil;

public class CardentialOperationsTest
{
    private CardentialOperations cardentialOperations;
    private List<String> tempUsers = new ArrayList<String>();
    
    @Before
    public void setUp() throws Exception
    {
        cardentialOperations = new CardentialOperations(HibernateUtil.getSessionFactory());
    }
    
    @Test
    public void storeCardential_cardentialShouldGetStored() throws DuplicateUserException, InvalidUserException
    {
        String emailId = "test@gmail.com";
        cardentialOperations.storeCardentials(emailId, "password");
        tempUsers.add(emailId);
        assertTrue(cardentialOperations.isUserExist("test@gmail.com"));
    }
    
    @After
    public void tearDown() throws Exception
    {
        for (String emailId : tempUsers)
        {
            cardentialOperations.deleteCardentials(emailId);
        }
        HibernateUtil.shutdown();
    }
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
