package dao.impl;

import dao.UsersGroupsDao;
import db.DatabaseConnection;
import models.*;

import ConnectionPool.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersGroupsDaoImpl implements UsersGroupsDao {
/*
    private static final Connection connection;

    static {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/
    @Override
    public void CreateUsersGroups(long userId, long groupId) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO `Users-Groups`(UserId, GroupId) " +
                            "VALUES (?, ?)");
        preparedStatement.setLong(1, userId);
        preparedStatement.setLong(2, groupId);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);

    }

    @Override
    public void DeleteUsersGroups(long id) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM `Users-Groups` WHERE Id = (?);");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);
    }

    @Override
    public UsersGroups GetUsersGroups(long userId, long groupId) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM `Users-Groups` Where UserId = (?) AND GroupId = (?)");
        preparedStatement.setLong(1, userId);
        preparedStatement.setLong(2, groupId);
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()){
            UsersGroups tmp_users_groups = new UsersGroups();
            tmp_users_groups.setId(rs.getLong("Id"));
            tmp_users_groups.setUserId(rs.getLong("UserId"));
            tmp_users_groups.setGroupId(rs.getInt("GroupId"));

            rs.close();
            preparedStatement.close();
            ConnectionPool.releaseConnection(connection);

            return tmp_users_groups;
        }

        rs.close();
        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);

        return null;
    }

    @Override
    public Groups[] GetGroupsByUserId(long userId) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM `Users-Groups` Where UserId = (?)");
        preparedStatement.setLong(1, userId);
        ResultSet rs = preparedStatement.executeQuery();

        PreparedStatement ps = connection.prepareStatement(
                "SELECT COUNT(*) AS NumberOfGroups FROM `Users-Groups` WHERE UserId = (?)");
        ps.setLong(1, userId);
        ResultSet nm = ps.executeQuery();    //Get number of rows in the variable
        nm.next();

        if(nm.getInt("NumberOfGroups") > 0) {        //If there is some groups return them,otherwise null
            Groups[] tmp_groups = new Groups[nm.getInt("NumberOfGroups")];
            for(int i = 0; i < tmp_groups.length; i++) tmp_groups[i] = new Groups();    //Initializing array

            GroupsDaoImpl GroupsDao = new GroupsDaoImpl();
            for (int i = 0; rs.next(); i++) {
                tmp_groups[i] = GroupsDao.GetGroupByGroupId(rs.getLong("GroupId"));
            }
            rs.close();
            ps.close();
            preparedStatement.close();
            ConnectionPool.releaseConnection(connection);

            return tmp_groups;
        }
        rs.close();
        nm.close();
        ps.close();
        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);
        return null;
    }

    @Override
    public Users[] GetUsersByGroupId(long groupId) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM `Users-Groups` Where GroupId = (?)");
        preparedStatement.setLong(1, groupId);
        ResultSet rs = preparedStatement.executeQuery();

        PreparedStatement ps = connection.prepareStatement(
                "SELECT COUNT(*) AS NumberOfUsers FROM `Users-Groups` WHERE GroupId = (?)");
        ps.setLong(1, groupId);
        ResultSet nm = ps.executeQuery();    //Get number of rows in the variable
        nm.next();

        if(nm.getInt("NumberOfUsers") > 0) {        //If there is some users return them,otherwise null
            Users[] tmp_users = new Users[nm.getInt("NumberOfUsers")];
            for(int i = 0; i < tmp_users.length; i++) tmp_users[i] = new Users();    //Initializing array

            UsersDaoImpl UsersDao = new UsersDaoImpl();
            for (int i = 0; rs.next(); i++) {


                tmp_users[i] = UsersDao.GetUserById(rs.getLong("UserId"));

            }

            rs.close();
            nm.close();
            ps.close();
            preparedStatement.close();
            ConnectionPool.releaseConnection(connection);
            return tmp_users;
        }

        rs.close();
        nm.close();
        ps.close();
        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);
        return null;
    }
}
