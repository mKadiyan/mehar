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
    private boolean enabled = true;
    private boolean admin = false;
    
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
    
    public boolean isEnabled()
    {
        return enabled;
    }
    
    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }
    
    public boolean isAdmin()
    {
        return admin;
    }
    
    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (admin ? 1231 : 1237);
        result = prime * result + ((dob == null) ? 0 : dob.hashCode());
        result = prime * result + ((doj == null) ? 0 : doj.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (admin != other.admin)
            return false;
        if (dob == null)
        {
            if (other.dob != null)
                return false;
        }
        else if (!dob.equals(other.dob))
            return false;
        if (doj == null)
        {
            if (other.doj != null)
                return false;
        }
        else if (!doj.equals(other.doj))
            return false;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (enabled != other.enabled)
            return false;
        if (firstName == null)
        {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }
    
    @Override
    public String toString()
    {
        return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", doj=" + doj
            + ", enabled=" + enabled + ", admin=" + admin + "]";
    }
    
}

/*
 * Copyright (c) Mehar 2014 ALL RIGHTS RESERVED
 */
