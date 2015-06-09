/*
 * Copyright (c) Mehar  2014 ALL RIGHTS RESERVED.
 *
 * 
 */

package com.rsk.mehar.persistance.pojo;

import java.util.Date;

public class User
{
    private String email;
    private String name;
    private String password;
    private String country;
    private boolean admin;
    private Date doj;
    private Date lastChange;
    
    public User()
    {
        
    }
    
    public User(String email, String name, String password, String country, boolean admin, Date doj, Date lastChange)
    {
        this.email = email;
        this.name = name;
        this.password = password;
        this.country = country;
        this.admin = admin;
        this.doj = doj;
        this.lastChange = lastChange;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public void setCountry(String country)
    {
        this.country = country;
    }
    
    public boolean isAdmin()
    {
        return admin;
    }
    
    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }
    
    public Date getDoj()
    {
        return doj;
    }
    
    public void setDoj(Date doj)
    {
        this.doj = doj;
    }
    
    public Date getLastChange()
    {
        return lastChange;
    }
    
    public void setLastChange(Date lastChange)
    {
        this.lastChange = lastChange;
    }
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
