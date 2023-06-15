package dao;

import models.Messages;

import java.sql.Connection;
import java.sql.SQLException;

public interface MessagesDao {
    void SendMessage(Messages message, Connection connection) throws SQLException;

    void SendMessage(long senderId, long groupId, String messageTxt, Connection connection) throws SQLException;

    Messages[] GetMessagesByGroupId(long groupId, Connection connection) throws SQLException;

    void DeleteMessage(long messageId, Connection connection) throws SQLException;

    void SetMessageAsRead(long messageId, Connection connection) throws SQLException;
}
