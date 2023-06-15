package models;

public class UsersGroups {
    long id;
    long userId;
    long groupId;

    public UsersGroups(long userId, long groupId){
        this.userId = userId;
        this.groupId = groupId;
    }

    public UsersGroups(){}

    public long getGroupId() {
        return groupId;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
