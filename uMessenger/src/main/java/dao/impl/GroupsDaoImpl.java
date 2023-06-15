package dao.impl;

import ConnectionPool.ConnectionPool;
import dao.GroupsDao;
import models.Groups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupsDaoImpl implements GroupsDao{

    @Override
    public void CreateGroup(Groups group, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO Groups(GroupName, TypeOfGroup) " +
                        "VALUES (?, ?)");
        preparedStatement.setString(1, group.GetGroupName());
        preparedStatement.setString(2, group.GetTypeOfGroup());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void DeleteGroup(long id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM Groups WHERE GroupId = (?);");
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void ChangeGroupName(long id, String groupName, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE Groups SET GroupName = (?) WHERE GroupId = (?)");
        preparedStatement.setString(1, groupName);
        preparedStatement.setLong(2, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public Groups GetGroupByGroupId(long id, Connection connection) throws SQLException, ClassNotFoundException {


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
        return null;
    }
}
