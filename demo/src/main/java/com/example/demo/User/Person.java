package com.example.demo.User;

public abstract class Person {
    protected String name;
    protected String password;
    protected String mobile;
    protected String email;
    protected boolean loggedIn;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public boolean getLoggedIn() {
        return loggedIn;
    }

    abstract boolean logIn(String userName,String password);
    abstract String signUp(String userName, String password, String mobileNumber, String email );
}

