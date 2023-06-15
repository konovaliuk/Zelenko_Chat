package DaoFactory;

import dao.impl.*;

public class DaoFactory {
    static GroupsDaoImpl GroupsDao = new GroupsDaoImpl();
    static UsersDaoImpl UsersDao = new UsersDaoImpl();
    static UsersGroupsDaoImpl UsersGroupsDao = new UsersGroupsDaoImpl();
    static MessagesDaoImpl MessagesDao = new MessagesDaoImpl();
    static ReportsDaoImpl ReportsDao = new ReportsDaoImpl();



    public static GroupsDaoImpl GroupsDao() {
        return GroupsDao;
    }

    public static MessagesDaoImpl MessagesDao() {
        return MessagesDao;
    }

    public static ReportsDaoImpl ReportsDao() {
        return ReportsDao;
    }

    public static UsersDaoImpl UsersDao() {
        return UsersDao;
    }

    public static UsersGroupsDaoImpl UsersGroupsDao() {
        return UsersGroupsDao;
    }
}
