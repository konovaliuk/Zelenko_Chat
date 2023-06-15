package dao;

import models.Users;

import java.sql.SQLException;

public interface UsersDao {
    void CreateUser(Users user) throws SQLException;



    void DeleteUser(long id) throws SQLException;

    void Promote(long id) throws SQLException;

    void Demote(long id) throws SQLException;

    void BanUser(long id) throws SQLException;

    void UnBanUser(long id) throws SQLException;

    Users GetUserById(long id) throws SQLException;

    Users GetUserByUsername(String username) throws SQLException;

    void ChangeUsername(long id, String username) throws SQLException;

    //void ChangePassword(long id, String pwd);

    void ChangePhoneNumber(long id, String phone_num) throws SQLException;
}


