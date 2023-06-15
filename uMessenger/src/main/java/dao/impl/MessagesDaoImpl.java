package dao.impl;

import dao.MessagesDao;
import models.Messages;

import java.sql.*;

public class MessagesDaoImpl implements MessagesDao {

    @Override
    public void SendMessage(Messages message, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO Messages(SenderId, GroupId, MessageTXT, Datetime, status) " +
                                "VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setLong(1, message.getSenderId());
        preparedStatement.setLong(2, message.getGroupId());
        preparedStatement.setString(3, message.getMessageTxt());
        preparedStatement.setString(4, message.getDateTime());
        preparedStatement.setString(5, message.getStatus());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void SendMessage(long senderId, long groupId, String messageTxt, Connection connection) throws SQLException {

        Messages message = new Messages();
        message.setSenderId(senderId);
        message.setGroupId(groupId);
        message.setMessageTxt(messageTxt);

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO Messages(SenderId, GroupId, MessageTXT, Datetime, status) " +
                            "VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setLong(1, message.getSenderId());
        preparedStatement.setLong(2, message.getGroupId());
        preparedStatement.setString(3, message.getMessageTxt());
        preparedStatement.setString(4, message.getDateTime());
        preparedStatement.setString(5, message.getStatus());

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }

    @Override
    public Messages[] GetMessagesByGroupId(long groupId, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Messages Where GroupId = (?)");
        preparedStatement.setLong(1, groupId);
        ResultSet rs = preparedStatement.executeQuery();

        PreparedStatement ps = connection.prepareStatement(
                "SELECT COUNT(*) AS NumberOfMessages FROM `messages` WHERE GroupID = (?)");
        ps.setLong(1, groupId);
        ResultSet nm = ps.executeQuery();    //Get number of rows in the variable
        nm.next();

        if(nm.getInt("NumberOfMessages") > 0) {        //If there is some messages return them,otherwise null
            Messages[] tmp_message = new Messages[nm.getInt("NumberOfMessages")];
            for(int i = 0; i < tmp_message.length; i++) tmp_message[i] = new Messages();    //Initializing array

            for (int i = 0; rs.next(); i++) {

                tmp_message[i].setMessageId(rs.getLong("MessageId"));
                tmp_message[i].setSenderId(rs.getLong("SenderId"));
                tmp_message[i].setGroupId(rs.getLong("GroupId"));
                tmp_message[i].setMessageTxt(rs.getString("MessageTXT"));
                tmp_message[i].setStatus(rs.getString("Status"));


            }

            preparedStatement.close();
            rs.close();
            ps.close();
            nm.close();
            return tmp_message;
        }

        preparedStatement.close();
        rs.close();
        ps.close();
        nm.close();
        return null;
    }

    @Override
    public void DeleteMessage(long messageId, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM Groups WHERE MessageId = (?);");
        preparedStatement.setLong(1, messageId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void SetMessageAsRead(long messageId, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE Messages SET Status = 'Read' WHERE MessageId = (?)");
        preparedStatement.setLong(1, messageId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}
