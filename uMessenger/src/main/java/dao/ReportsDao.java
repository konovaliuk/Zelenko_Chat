package dao;


import models.Messages;
import models.Reports;

import java.sql.Connection;
import java.sql.SQLException;

public interface ReportsDao {

    void ReportMessage(long messageId, String reason, Connection connection) throws SQLException;

    void ReportMessage(Messages message, String reason, Connection connection) throws SQLException;
    Reports GetReportById(long reportId, Connection connection) throws SQLException;

    void SetAsChecked(long reportId, Connection connection) throws SQLException;

    void BanUser(long reportId, Connection connection) throws SQLException;

    void UnBanUser(long reportId, Connection connection) throws SQLException;

}
