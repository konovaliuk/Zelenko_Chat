package dao.impl;

import ConnectionPool.ConnectionPool;
import dao.GroupsDao;
import db.DatabaseConnection;
import models.Groups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsDaoImpl implements GroupsDao{
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
    public void CreateGroup(Groups group) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO Groups(GroupName, TypeOfGroup) " +
                        "VALUES (?, ?)");
        preparedStatement.setString(1, group.GetGroupName());
        preparedStatement.setString(2, group.GetTypeOfGroup());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);
    }

    @Override
    public void DeleteGroup(long id) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM Groups WHERE GroupId = (?);");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);
    }

    @Override
    public void ChangeGroupName(long id, String groupName) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE Groups SET GroupName = (?) WHERE GroupId = (?)");
        preparedStatement.setString(1, groupName);
        preparedStatement.setLong(2, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        ConnectionPool.releaseConnection(connection);
    }

    @Override
    public Groups GetGroupByGroupId(long id) throws SQLException {
        final Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Groups Where GroupId = (?)");
        preparedStatement.setLong(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()){
            Groups tmp_group = new Groups();
            tmp_group.SetGroupId(rs.getLong("GroupId"));
            tmp_group.SetGroupName(rs.getString("GroupName"));
            tmp_group.SetTypeOfGroup(rs.getString("TypeOfGroup"));

            preparedStatement.close();
            rs.close();
            ConnectionPool.releaseConnection(connection);
            return tmp_group;
        }

        preparedStatement.close();
        rs.close();
        ConnectionPool.releaseConnection(connection);
        return null;
    }
}
