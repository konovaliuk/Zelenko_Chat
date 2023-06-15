package models;

public class Reports {

   long reportId;
   long messageId;
   int banned;
   int checked;
   String reason;

    public Reports(){}
    public Reports(long messageId, int checked, String reason){
        this.messageId = messageId;
        this.checked = checked;
        this.reason = reason;
    }

    //          GETTERS         //
    public int getBanned() {
        return banned;
    }

    public int getChecked() {
        return checked;
    }

    public long getMessageId() {
        return messageId;
    }

    public long getReportId() {
        return reportId;
    }

    public String getReason() {
        return reason;
    }

    //        SETTERS         //


    public void setBanned(int banned) {
        this.banned = banned;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
