package DaoFactory;

import dao.impl.*;

public class DaoFactory {
    GroupsDaoImpl GroupsDao = new GroupsDaoImpl();
    UsersDaoImpl UsersDao = new UsersDaoImpl();
    UsersGroupsDaoImpl UsersGroupsDao = new UsersGroupsDaoImpl();
    MessagesDaoImpl MessagesDao = new MessagesDaoImpl();
    ReportsDaoImpl ReportsDao = new ReportsDaoImpl();


    public UsersDaoImpl getUsersDao() {
        return UsersDao;
    }

    public UsersGroupsDaoImpl getUsersGroupsDao() {
        return UsersGroupsDao;
    }

    public GroupsDaoImpl GroupsDao() {
        return GroupsDao;
    }

    public MessagesDaoImpl MessagesDao() {
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
