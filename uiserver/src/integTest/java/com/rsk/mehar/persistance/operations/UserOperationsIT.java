/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rsk.mehar.persistance.exception.DuplicateUserException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.pojo.User;
import com.rsk.mehar.persistance.util.HibernateUtil;

public class UserOperationsIT extends TestBase
{
    private UserOperations userOperations;
    
    @Before
    public void setup()
    {
        userOperations = new UserOperations(HibernateUtil.getSessionFactory());
    }
    
    @Test
    public void storeAUser_userGetStored() throws InvalidUserException, DuplicateUserException
    {
        User user = new User(emailId, "Mehar", "Singh", Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
        userOperations.storeUser(user);
        tempUsers.add(emailId);
        User user2 = userOperations.getUser(emailId);
        assertThat(user2.getEmail(), is(user.getEmail()));
        
    }
    
    @Test(expected = DuplicateUserException.class)
    public void storeAUserTwice_shouldGetDuplicateUserException() throws DuplicateUserException
    {
        User user = new User(emailId, "Mehar", "Singh", Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
        userOperations.storeUser(user);
        tempUsers.add(emailId);
        userOperations.storeUser(user);
        
    }
    
    @After
    public void tearDown() throws Exception
    {
        for (String emailId : tempUsers)
        {
            userOperations.deleteUser(emailId);
        }
    }
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
