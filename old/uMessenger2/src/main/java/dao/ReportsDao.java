package dao;


import models.Messages;
import models.Reports;

import java.sql.SQLException;

public interface ReportsDao {

    void ReportMessage(long messageId, String reason) throws SQLException;

    void ReportMessage(Messages message, String reason) throws SQLException;
    Reports GetReportById(long reportId) throws SQLException;

    void SetAsChecked(long reportId) throws SQLException;

    void BanUser(long reportId) throws SQLException;

    void UnBanUser(long reportId) throws SQLException;

}
