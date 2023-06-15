package models;


public class Users{

    long userId;

    String role;    // User or Admin

    String username;

    String phoneNum;

    String pwd;     //Password

    int enabled = 1;


    public Users(
        long userId,
        String role,
        String username,
        String phoneNum,
        String pwd
    ){
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.phoneNum = phoneNum;
        this.pwd = pwd;
    }
    public Users(){};

    //                    GETTERS
    public long GetUserId(){ return this.userId; }

    public String GetUsername(){
        return username;
    }

    public String GetRole(){
        return role;
    }

    public String GetPhoneNum(){
        return phoneNum;
    }

    public String GetPassword(){
        return pwd;
    }

    public int GetEnabled() { return enabled; }



    //                    SETTERS

    public void SetUserId(long id ){ this.userId = id; }
    public void SetUsername(String username){
        this.username = username;
    }

    public void SetRole(String role){ this.role = role; }

    public void SetPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    public void SetPassword(String pwd){
        this.pwd = pwd;
    }

    public void SetEnabled(int enabled) { this.enabled = enabled;}

    public void print(){
        System.out.print(GetUsername() + " is " + GetRole() +". You can call this user by: 0"+ GetPhoneNum());
    }
}