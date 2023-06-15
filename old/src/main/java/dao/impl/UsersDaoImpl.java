package main.java.dao.impl;

import main.java.dao.UsersDao;
import DatabaseConnection;


public class UsersDaoImpl implements UsersDao{
    private static final Connection connection = DatabaseConnection.getConnection();


   
    @Override
    public void CreateUser(Users user) {
        try {
            assert connection != null;
            //private static final Connection connection = ConnectionPool.GetConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO users(id, role, usersname, phoneNum, password, enabled) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setObject(1, user.GetId());
            preparedStatement.setString(2, user.GetRole());
            preparedStatement.setString(3, user.GetUsername());
            preparedStatement.setBigDecimal(4, user.GetPhoneNum());
            preparedStatement.setString(5, user.GetPassword());
            preparedStatement.setObject(6, 1);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // @Override
    // void DeleteUser(long id){
    //     try {
    //         assert connection != null;
    //         //private static final Connection connection = ConnectionPool.GetConnection();
    //         PreparedStatement preparedStatement = connection
    //                 .prepareStatement("INSERT INTO users(id, role, usersname, phoneNum, password, enabled) " +
    //                         "VALUES (?, ?, ?, ?, ?, ?)");
    //         preparedStatement.setObject(1, user.GetId());
    //         preparedStatement.setString(2, user.GetRole());
    //         preparedStatement.setString(3, user.GetUsername());
    //         preparedStatement.setBigDecimal(4, user.GetPhoneNum());
    //         preparedStatement.setString(5, user.GetPassword());
    //         preparedStatement.setObject(6, 1);

    //         preparedStatement.executeUpdate();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }






}