/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rsk.mehar.persistance.exception.DuplicateUserException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.pojo.User;

/**
 * User Operations
 * 
 * @author ravinder
 *
 */
public class UserOperations
{
    private static Logger logger = Logger.getLogger(UserOperations.class);
    private SessionFactory sessionFactory;
    
    public UserOperations(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    public void storeUser(User user) throws DuplicateUserException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            if (!checkIfUserExist(session, user.getEmail()))
            {
                session.save(user);
                session.getTransaction().commit();
            }
            else
            {
                throw new DuplicateUserException("user already Exist emailId: " + user.getEmail());
            }
        }
        finally
        {
            session.close();
        }
    }
    
    public User getUser(String emailId) throws InvalidUserException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            
            Query q = session.createQuery("from User where email = :emailId");
            q.setParameter("emailId", emailId);
            @SuppressWarnings("unchecked")
            List<User> list = q.list();
            
            if (logger.isInfoEnabled())
                logger.info("Fetch user successfully: size = " + list.size());
            
            if (list.size() > 0)
            {
                return list.get(0);
            }
            else
            {
                throw new InvalidUserException("user doesnt Exist emailId: " + emailId);
            }
            
        }
        finally
        {
            session.close();
        }
    }
    
    public void deleteUser(String emailId) throws InvalidUserException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete User where email = :emailId");
        query.setParameter("emailId", emailId);
        try
        {
            int result = query.executeUpdate();
            
            if (result > 0)
            {
                if (logger.isInfoEnabled())
                    logger.info("User successfully removed : " + emailId);
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
    
    public boolean isUserExist(String emailId)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete User where email = :emailId");
        query.setParameter("emailId", emailId);
        try
        {
            return checkIfUserExist(session, emailId);
        }
        finally
        {
            session.getTransaction().commit();
            session.close();
        }
    }
    
    public boolean isValidCardentials(String emailId, String password)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select count(*) from User where email = :emailId AND password = :password");
        query.setParameter("emailId", emailId);
        query.setParameter("password", password);
        try
        {
            Long uniqueResult = (Long) query.uniqueResult();
            if (uniqueResult == null || uniqueResult == 0)
                return false;
        }
        finally
        {
            session.getTransaction().commit();
            session.close();
        }
        return true;
    }
    
    private boolean checkIfUserExist(Session session, String emailId)
    {
        Query q = session.createQuery("select count(*) from User where email = :emailId");
        q.setParameter("emailId", emailId);
        Long uniqueResult = (Long) q.uniqueResult();
        if (uniqueResult == null || uniqueResult == 0)
            return false;
        return true;
    }
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
