/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.operations;

import org.apache.log4j.LogSF;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rsk.mehar.persistance.exception.DuplicateUserException;
import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.pojo.Cardential;

public class CardentialOperations
{
    private static Logger logger = Logger.getLogger(CardentialOperations.class);
    private SessionFactory sessionFactory;
    
    public CardentialOperations(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    public void storeCardentials(String emailId, String password) throws DuplicateUserException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            if (!checkIfUserExist(session, emailId))
            {
                Cardential cardential = new Cardential(emailId, password, null, null);
                session.save(cardential);
                session.getTransaction().commit();
            }
            else
            {
                throw new DuplicateUserException("user already Exist emailId: " + emailId);
            }
        }
        finally
        {
            session.close();
        }
    }
    
    public boolean isUserExist(String emailId)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            return checkIfUserExist(session, emailId);
        }
        finally
        {
            session.close();
        }
        
    }
    
    private boolean checkIfUserExist(Session session, String emailId)
    {
        Query q = session.createQuery("select count(*) from Cardential where email = :emailId");
        q.setParameter("emailId", emailId);
        Long uniqueResult = (Long) q.uniqueResult();
        if (uniqueResult == null || uniqueResult == 0)
            return false;
        return true;
    }
    
    public boolean isValidCardentials(String emailId, String password) throws InvalidUserException, InvalidCardentialException
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            if (!checkIfUserExist(session, emailId))
                throw new InvalidUserException("User doesnt Exist : " + emailId);
            
            return checkCardential(session, emailId, password);
        }
        finally
        {
            session.close();
        }
    }
    
    private boolean checkCardential(Session session, String emailId, String password)
    {
        Query q = session.createQuery("select count(*) from Cardential where email = :emailId AND password = :password");
        q.setParameter("emailId", emailId);
        q.setParameter("password", password);
        Long uniqueResult = (Long) q.uniqueResult();
        if (uniqueResult != null && uniqueResult > 0l)
            return true;
        return false;
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
                if (logger.isInfoEnabled())
                    logger.info("Cardential successfully removed : " + emailId);
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
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try
        {
            if (checkCardential(session, emailId, oldPassword))
            {
                String hql = "update Cardential set password = :newPassword where email = :email";
                Query query = session.createQuery(hql);
                query.setParameter("newPassword", newPassword);
                query.setParameter("email", emailId);
                int rowCount = query.executeUpdate();
                if (logger.isInfoEnabled())
                {
                    LogSF.info(logger, "changePassword for :{} , Rows affected: {}", emailId, rowCount);
                }
            }
            
        }
        finally
        {
            session.getTransaction().commit();
            session.close();
        }
    }
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */

