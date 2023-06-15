package main.java.models;

//import main.java.types.Role;

public class Users{

    long userId;

    String role;    // User or Admin

    String username;

    long phoneNum;

    String pwd;     //Password

    public Users(
        long userId,
        String role,
        String username,
        long phoneNum,
        String pwd
    ){
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.phoneNum = phoneNum;
        this.pwd = pwd;
    }

    long GetUserId(){
        return this.userId;
    }
    String GetUsername(){
        return username;
    }
    String GetRole(){
        return role;
    }
    long GetPhoneNum(){
        return phoneNum;
    }
    String GetPassword(){
        return pwd;
    }

}