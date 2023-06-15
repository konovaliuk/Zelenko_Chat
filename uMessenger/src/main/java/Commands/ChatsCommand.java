package Commands;

import ConnectionPool.ConnectionPool;
import DaoFactory.DaoFactory;
import dao.impl.GroupsDaoImpl;
import dao.impl.UsersGroupsDaoImpl;
import models.Groups;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ChatsCommand {
    public static void GETRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key = "UserId";
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 1) {
            long userId = Long.parseLong(cookies[1].getValue());
            Connection connection = null;
            try {
                connection = ConnectionPool.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            UsersGroupsDaoImpl UsersGroupsDao = DaoFactory.UsersGroupsDao();
            Groups[] groups = null;
            try {
                groups = UsersGroupsDao.GetGroupsByUserId(userId, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("chats", groups);



        }
        else{
            response.sendRedirect("/uMessenger/");
        }
        response.sendRedirect("/uMessenger/chats.jsp");
    }
    public static void POSTRequest(HttpServletRequest request, HttpServletResponse response){

    }
}
