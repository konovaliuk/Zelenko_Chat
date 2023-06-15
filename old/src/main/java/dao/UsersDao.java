package main.java.dao;

import main.java.models.Users;

public interface UsersDao {
    void CreateUser(Users user);

    void DeleteUser(long id);
     
    void BlockUser(long id);
    
    Users GetUserById(long id);

    Users GetUserByUsername(String username);

    void ChangeUsername(long id, String username);
}


