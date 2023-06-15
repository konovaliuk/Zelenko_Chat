package dao;
import models.Groups;

import java.sql.SQLException;

public interface GroupsDao {
    void CreateGroup(Groups group) throws SQLException;

    void DeleteGroup(long id) throws SQLException;

    void ChangeGroupName(long id, String groupName) throws SQLException;

    Groups GetGroupByGroupId(long id) throws SQLException;

}
