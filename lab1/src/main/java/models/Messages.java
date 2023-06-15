package models;

import java.sql.Time;

public class Messages {
    long messageId;
    long senderId;
    long groupId;
    String messageTxt;
    String dateTime;
    String status = "Sent";


    public Messages(
            long messageId,
            long senderId,
            long groupId,
            String messageTxt,
            String status)
    {
        this.messageId = messageId;
        this.senderId = senderId;
        this.groupId = groupId;
        this.messageTxt = messageTxt;

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime = sdf.format(dt);
        this.dateTime = currentTime;

        this.status = status;
    }

    public Messages(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime = sdf.format(dt);
        this.dateTime = currentTime;
    }


//                GETTERS
    public long getMessageId() {
        return messageId;
    }
    public long getGroupId() {
        return groupId;
    }

    public long getSenderId() {
        return senderId;
    }

    public String getMessageTxt() {
        return messageTxt;
    }

    public String getStatus() {
        return status;
    }

    public String getDateTime() {
        return dateTime;
    }


    //                  SETTERS


    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setMessageTxt(String messageTxt) {
        this.messageTxt = messageTxt;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void print(){
        System.out.println(getSenderId()+": "+getMessageTxt()+"\t"+getDateTime());
    }
}
