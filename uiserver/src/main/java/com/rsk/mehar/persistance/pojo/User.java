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
    private String firstName;
    private String lastName;
    
    private Date dob;
    private Date doj;
    
    public User()
    {
        // TODO Auto-generated constructor stub
    }
    
    public User(String email, String firstName, String lastName, Date dob, Date doj)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.doj = doj;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public Date getDob()
    {
        return dob;
    }
    
    public void setDob(Date dob)
    {
        this.dob = dob;
    }
    
    public Date getDoj()
    {
        return doj;
    }
    
    public void setDoj(Date doj)
    {
        this.doj = doj;
    }
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
