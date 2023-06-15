package DaoFactory;

import dao.impl.*;

public class DaoFactory {
    static GroupsDaoImpl GroupsDao = new GroupsDaoImpl();
    static UsersDaoImpl UsersDao = new UsersDaoImpl();
    static UsersGroupsDaoImpl UsersGroupsDao = new UsersGroupsDaoImpl();
    static MessagesDaoImpl MessagesDao = new MessagesDaoImpl();
    static ReportsDaoImpl ReportsDao = new ReportsDaoImpl();



    public GroupsDaoImpl GroupsDao() {
        return GroupsDao;
    }

    public static MessagesDaoImpl MessagesDao() {
        return MessagesDao;
    }

    public ReportsDaoImpl ReportsDao() {
        return ReportsDao;
    }

    public UsersDaoImpl UsersDao() {
        return UsersDao;
    }

    public UsersGroupsDaoImpl UsersGroupsDao() {
        return UsersGroupsDao;
    }
}
