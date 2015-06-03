package com.rsk.mehar.persistance.operations;

import com.rsk.mehar.persistance.exception.InvalidCardentialException;
import com.rsk.mehar.persistance.exception.InvalidUserException;
import com.rsk.mehar.persistance.pojo.User;
import com.rsk.mehar.persistance.util.HibernateUtil;
import org.apache.log4j.LogSF;
import org.apache.log4j.Logger;

/**
 * Created by ravinder on 04-06-2015.
 */
public class AllOperation {

    UserOperations userOperations ;
    private static Logger logger = Logger.getLogger(UserOperations.class);
    public AllOperation()
    {
        userOperations = new UserOperations(HibernateUtil.getSessionFactory());
    }

    public boolean isUserExist(String emailId)
    {
        return userOperations.isUserExist(emailId);
    }

    public boolean isValidCardentials(String emailId, String password)
    {
        return userOperations.isValidCardentials(emailId,password);
    }

    public User getUser(String emailId)
    {
        User user=null;
        try
        {
           return  userOperations.getUser(emailId);
        }
        catch (InvalidUserException e) {
            LogSF.warn(logger,"User with emailId : {} does not exist ",emailId);
        }
        return user;
    }
}
