package models;

public class Groups {
    long groupId;
    String groupName;
    String typeOfGroup;

    public Groups(long groupId, String groupName, String typeOfGroup){
        this.groupId = groupId;
        this.groupName = groupName;
        this.typeOfGroup = typeOfGroup;
    }
    public Groups(){}

    public long GetGroupId(){return this.groupId;}
    public String GetGroupName() {return this.groupName;}

    public String GetTypeOfGroup() {return this.typeOfGroup;}

    public void SetGroupId(long groupId){this.groupId = groupId;}
    public void SetGroupName(String groupName){this.groupName = groupName;}
    public void SetTypeOfGroup(String typeOfGroup){this.typeOfGroup = typeOfGroup;}

    public void print(){
        System.out.println(GetGroupName() + "is a" + GetTypeOfGroup());
    }
}
