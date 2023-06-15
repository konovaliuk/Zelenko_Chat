package Controllers;

import ConnectionPool.ConnectionPool;
import DaoFactory.DaoFactory;
import dao.impl.UsersGroupsDaoImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    public static void LogIn(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
        response.sendRedirect("/uMessenger/login.jsp");

        DaoFactory factory = new DaoFactory();
        UsersGroupsDaoImpl UsersGroupsDao = factory.UsersGroupsDao();


        Users[] users = UsersGroupsDao.GetUsersByGroupId(2);

        for (int i = 0; i < users.length; i++){
            System.out.println(users[i].GetUsername());
        }

        ConnectionPool.closeAllConnections();



    }
}
