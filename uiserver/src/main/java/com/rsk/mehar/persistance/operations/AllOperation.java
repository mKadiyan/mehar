package com.rsk.mehar.persistance.operations;

import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.pojo.User;
import com.rsk.mehar.persistance.util.HibernateUtil;

/**
 * Created by ravinder on 04-06-2015.
 */
public class AllOperation {

    UserOperations userOperations ;
    CardentialOperations cardentialOperations;

    public AllOperation()
    {
        userOperations = new UserOperations(HibernateUtil.getSessionFactory());
        cardentialOperations = new CardentialOperations(HibernateUtil.getSessionFactory());
    }

    public boolean isUserExist(String emailId)
    {
        return cardentialOperations.isUserExist(emailId);
    }

    public boolean isValidCardentials(String emailId, String password)
    {
        try {
            return cardentialOperations.isValidCardentials(emailId,password);
        } catch (InvalidUserException e) {
            return false;

        } catch (InvalidCardentialException e) {
            return false;
        }
    }

    public User getUser(String emailId)
    {
        User user=null;
        try
        {
           return  userOperations.getUser(emailId);
        }
        catch (InvalidUserException e) {

        }
        return user;
    }
}
