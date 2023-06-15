package dao;

import models.Users;

import java.sql.Connection;
import java.sql.SQLException;

public interface UsersDao {
    void CreateUser(Users user, Connection connection) throws SQLException;



    void DeleteUser(long id, Connection connection) throws SQLException;

    void Promote(long id, Connection connection) throws SQLException;

    void Demote(long id, Connection connection) throws SQLException;

    void BanUser(long id, Connection connection) throws SQLException;

    void UnBanUser(long id, Connection connection) throws SQLException;

    Users GetUserById(long id, Connection connection) throws SQLException;

    Users GetUserByUsername(String username, Connection connection) throws SQLException;

    void ChangeUsername(long id, String username, Connection connection) throws SQLException;

    //void ChangePassword(long id, String pwd);

    void ChangePhoneNumber(long id, String phone_num, Connection connection) throws SQLException;
}


