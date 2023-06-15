package dao.impl;

import ConnectionPool.ConnectionPool;
import dao.UsersDao;
import java.sql.*;
import models.Users;
public class UsersDaoImpl implements UsersDao{

    @Override
    public void CreateUser(Users user, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO users(Role, Username, PhoneNum, Password, Enabled) " +
                        "VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, user.GetRole());
        preparedStatement.setString(2, user.GetUsername());
        preparedStatement.setString(3, user.GetPhoneNum());
        preparedStatement.setString(4, user.GetPassword());
        preparedStatement.setInt(5, 1);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void DeleteUser (long id, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM users WHERE UserId = (?);");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void Promote(long id, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE users SET Role = 'Admin' WHERE UserId = (?)");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void Demote(long id, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE users SET Role = 'User' WHERE UserId = (?)");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void BanUser(long id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE users SET Enabled = 0 WHERE UserId = (?)");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void UnBanUser(long id, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE users SET Enabled = 1 WHERE UserId = (?)");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public Users GetUserById  (long id, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Users Where UserId = (?)");
        preparedStatement.setLong(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        Users tmp_user = new Users();
        if (rs.next()) {
            tmp_user.SetUserId(rs.getInt("UserId"));
            tmp_user.SetUsername(rs.getString("Username"));
            tmp_user.SetRole(rs.getString("Role"));
            tmp_user.SetPhoneNum(rs.getString("PhoneNum"));
            tmp_user.SetPassword(rs.getString("Password"));
            tmp_user.SetEnabled(rs.getInt("Enabled"));

            preparedStatement.close();
            rs.close();
            ConnectionPool.releaseConnection(connection);
            return tmp_user;
        }

        preparedStatement.close();
        rs.close();
        return null;
    }

    @Override
    public Users GetUserByUsername(String username, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Users Where UserName = (?)");
        preparedStatement.setString(1, username);

        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()){
            Users tmp_user = new Users();
            tmp_user.SetUserId(rs.getInt("UserId"));
            tmp_user.SetUsername(rs.getString("Username"));
            tmp_user.SetRole(rs.getString("Role"));
            tmp_user.SetPhoneNum(rs.getString("PhoneNum"));
            tmp_user.SetPassword(rs.getString("Password"));
            tmp_user.SetEnabled(rs.getInt("Enabled"));

            preparedStatement.close();
            rs.close();
            return tmp_user;
        }

        preparedStatement.close();
        rs.close();
        return null;
    }

    @Override
    public void ChangeUsername(long id, String username, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE users SET Username = (?) WHERE UserId = (?)");
        preparedStatement.setString(1, username);
        preparedStatement.setLong(2, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void ChangePhoneNumber(long id, String phone_num, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE users SET PhoneNum = (?) WHERE UserId = (?)");
        preparedStatement.setString(1, phone_num);
        preparedStatement.setLong(2, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    };
}