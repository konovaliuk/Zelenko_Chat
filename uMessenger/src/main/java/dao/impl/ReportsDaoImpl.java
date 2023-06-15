package dao.impl;

import dao.ReportsDao;
import models.Messages;
import models.Reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportsDaoImpl implements ReportsDao {

    @Override
    public void ReportMessage(long messageId, String reason, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO Reports(MessageId, Banned, Checked, Reason) " +
                        "VALUES (?, ?, ?, ?)");
        preparedStatement.setLong(1, messageId);
        preparedStatement.setInt(2, 0);
        preparedStatement.setInt(3, 0);
        preparedStatement.setString(4, reason);

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }


    @Override
    public void ReportMessage(Messages message, String reason, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO Reports(MessageId, Banned, Checked, Reason) " +
                        "VALUES (?, ?, ?, ?)");
        preparedStatement.setLong(1, message.getMessageId());
        preparedStatement.setInt(2, 0);
        preparedStatement.setInt(3, 0);
        preparedStatement.setString(4, reason);

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }

    @Override
    public Reports GetReportById(long reportId, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Reports Where ReportId = (?)");
        preparedStatement.setLong(1, reportId);

        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()){
            Reports tmp_report = new Reports();
            tmp_report.setReportId(rs.getLong("ReportId"));
            tmp_report.setMessageId(rs.getLong("messageId"));
            tmp_report.setBanned(rs.getInt("Banned"));
            tmp_report.setChecked(rs.getInt("Checked"));
            tmp_report.setReason(rs.getString("Reason"));

            preparedStatement.close();
            return tmp_report;
        }

        preparedStatement.close();
        return null;
    }

    @Override
    public void SetAsChecked(long reportId, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE Reports SET Checked = 1 WHERE ReportId = (?)");
        preparedStatement.setLong(1, reportId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void BanUser(long reportId, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE Reports SET Banned = 1 WHERE ReportId = (?)");
        preparedStatement.setLong(1, reportId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    @Override
    public void UnBanUser(long reportId, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE Reports SET Banned = 0 WHERE ReportId = (?)");
        preparedStatement.setLong(1, reportId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}
