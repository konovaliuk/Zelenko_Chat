package dao;

import models.Groups;
import models.Users;
import models.UsersGroups;

import java.sql.Connection;
import java.sql.SQLException;

public interface UsersGroupsDao {
    void CreateUsersGroups(long userId, long groupId, Connection connection) throws SQLException;

    void DeleteUsersGroups(long id, Connection connection) throws SQLException;

    UsersGroups GetUsersGroups(long userId, long groupId, Connection connection) throws SQLException;

    Groups[] GetGroupsByUserId(long userId, Connection connection) throws SQLException, ClassNotFoundException;

    Users[] GetUsersByGroupId(long groupId, Connection connection) throws SQLException;
}
