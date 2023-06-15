package Controllers;

import Commands.ChatsCommand;
import Commands.LoginCommand;
import Commands.RegisterCommand;
import ConnectionPool.ConnectionPool;
import DaoFactory.DaoFactory;
import dao.impl.UsersGroupsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
public class Controller {

    public void GETRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getServletPath());
        String servletPath = request.getServletPath();
        if(servletPath.equals("/login"))
            LoginCommand.GETRequest(request, response);
        else if(servletPath.equals("/register")){
            RegisterCommand.GETRequest(request, response);
        } else if (servletPath.equals("/chats")) {
            ChatsCommand.GETRequest(request, response);
        }else if (servletPath.equals("/logout")) {
            response.sendRedirect("/uMessenger/");
        }
    }

    public void POSTRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if(servletPath.equals("/login"))
            LoginCommand.POSTRequest(request, response);
        else if(servletPath.equals("/register")){
            RegisterCommand.POSTRequest(request, response);
        }
    }
    /*
    public void LogIn(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.sendRedirect("/uMessenger/login.jsp");

        Connection connection = ConnectionPool.getConnection();
        DaoFactory factory = new DaoFactory();
        UsersGroupsDaoImpl UsersGroupsDao = factory.UsersGroupsDao();

        Users[] users = UsersGroupsDao.GetUsersByGroupId(2, connection);

        for (int i = 0; i < users.length; i++){
            System.out.println(users[i].GetUsername());
        }

        ConnectionPool.closeAllConnections();
    }
     */
}
