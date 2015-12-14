package com.leticiasanchez.otterlibrarysystem;

/**
 * Created by leticiasanchez on 12/10/15.
 */
public class Account {

    private int id;
    private String username;
    private String password;

    public Account(){
        this.password = password;
        this.username = username;
    }
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String toString(){
        return "Accounts [username=" + username + ", password=" + password + "]";
    }
}
