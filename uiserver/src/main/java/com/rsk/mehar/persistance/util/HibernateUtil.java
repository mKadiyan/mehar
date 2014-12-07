package com.rsk.mehar.persistance.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
    private static SessionFactory sessionFactory;
    static
    {
        try
        {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).configure()
                .build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
        }
        catch (Throwable ex)
        {
            System.out.println(ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
    
    public static void shutdown()
    {
        getSessionFactory().close();
    }
}