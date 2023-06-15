package dao;
import models.Groups;

import java.sql.Connection;
import java.sql.SQLException;

public interface GroupsDao {
    void CreateGroup(Groups group, Connection connection) throws SQLException;

    void DeleteGroup(long id, Connection connection) throws SQLException;

    void ChangeGroupName(long id, String groupName, Connection connection) throws SQLException;

    Groups GetGroupByGroupId(long id, Connection connection) throws SQLException, ClassNotFoundException;

}
