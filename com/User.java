package com;



public class User 
{
    private String name;
    private String password;

    public User() {
    }

    public User(String name,String password)
    {
        this.name = name;
        this.password = password;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setPWD(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
}