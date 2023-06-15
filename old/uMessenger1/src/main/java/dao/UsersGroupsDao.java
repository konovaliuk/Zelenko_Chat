package dao;

import models.Groups;
import models.Users;
import models.UsersGroups;

import java.sql.SQLException;

public interface UsersGroupsDao {
    void CreateUsersGroups(long userId, long groupId) throws SQLException;

    void DeleteUsersGroups(long id) throws SQLException;

    UsersGroups GetUsersGroups(long userId, long groupId) throws SQLException;

    Groups[] GetGroupsByUserId(long userId) throws SQLException;

    Users[] GetUsersByGroupId(long groupId) throws SQLException;
}
