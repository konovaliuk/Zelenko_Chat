package dao;

import models.Messages;

import java.sql.SQLException;

public interface MessagesDao {
    void SendMessage(Messages message) throws SQLException;

    void SendMessage(long senderId, long groupId, String messageTxt) throws SQLException;

    Messages[] GetMessagesByGroupId(long groupId) throws SQLException;

    void DeleteMessage(long messageId) throws SQLException;

    void SetMessageAsRead(long messageId) throws SQLException;
}
