/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rsk.mehar.persistance.exception.DuplicateUserException;
import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.pojo.Cardential;

public class CardentialOperations
{
    private SessionFactory sessionFactory;
    
    public CardentialOperations(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    public void storeCardentials(String emailId, String password) throws DuplicateUserException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Object obj = session.load(Cardential.class, emailId);
        try
        {
            if (obj == null)
            {
                Cardential cardential = new Cardential(emailId, password, Calendar.getInstance().getTime(), null, null);
                session.save(cardential);
            }
            else
            {
                throw new DuplicateUserException("user already Exist emailId: " + emailId);
            }
        }
        finally
        {
            session.getTransaction().commit();
            session.close();
        }
    }
    
    public boolean isUserExist(String emailId)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Object obj = session.load(Cardential.class, emailId);
        try
        {
            if (obj != null)
                return true;
        }
        finally
        {
            session.close();
        }
        return false;
        
    }
    
    public void checkCardentials(String emailId, String password) throws InvalidUserException, InvalidCardentialException
    {
        
    }
    
    public void deleteCardentials(String emailId) throws InvalidUserException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete Cardential where email = :emailId");
        query.setParameter("emailId", emailId);
        try
        {
            int result = query.executeUpdate();
            
            if (result > 0)
            {
                System.out.println("Expensive products was removed");
            }
            else
                throw new InvalidUserException("user doesnt exist : " + emailId);
        }
        finally
        {
            session.getTransaction().commit();
            session.close();
        }
    }
    
    public void changePassword(String emailId, String oldPassword, String newPassword) throws InvalidUserException,
        InvalidCardentialException
    {
        
    }
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
