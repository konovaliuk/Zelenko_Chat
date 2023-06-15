package Commands;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.UUID;

import ConnectionPool.ConnectionPool;
import DaoFactory.DaoFactory;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import dao.UsersDao;
import dao.impl.UsersDaoImpl;
import models.Users;
import security.PasswordHash;

public class RegisterCommand {

    public static void GETRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user_error_message", "&#32;");
        request.setAttribute("phone_error_message", "&#32;");
        request.setAttribute("pass_error_message", "&#32;");
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    public static void POSTRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = ConnectionPool.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String username = request.getParameter("Username");

        UsersDaoImpl UsersDao = DaoFactory.UsersDao();

        Users user = null;
        try {
            user = UsersDao.GetUserByUsername(username, connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String phoneNum = request.getParameter("PhoneNumber");
        String password = request.getParameter("Password");
        String passwordConfirm = request.getParameter("PasswordConfirm");

        Boolean passAreEqual = password.equals(passwordConfirm);
        if(user == null && passAreEqual) {
            Users user_tmp = new Users();
            user_tmp.SetRole("User");
            user_tmp.SetUsername(username);
            user_tmp.SetPassword(PasswordHash.Hash(password));
            user_tmp.SetPhoneNum(phoneNum);

            try {
                UsersDao.CreateUser(user_tmp, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                user_tmp = UsersDao.GetUserByUsername(username, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            long userID = user_tmp.GetUserId();

            /*
            Algorithm algorithm = Algorithm.HMAC256("uMessenger");




            String jwtToken = JWT.create()
                    .withIssuer("uMessenger")
                    .withSubject("User Details")
                    .withClaim("userId", Long.toString(userID) )
                    .withIssuedAt(new Date(System.currentTimeMillis()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + 5000000L))
                    .withJWTId(UUID.randomUUID()
                            .toString())
                    .withNotBefore(new Date(System.currentTimeMillis() + 1000L))
                    .sign(algorithm);

             */
            Cookie cookie = new Cookie("UserId", Long.toString(userID));
            cookie.setPath("/");
            cookie.setMaxAge(60*60*60);
            response.addCookie(cookie);

            response.sendRedirect("/uMessenger/chats");



        } else if (user != null) {
            request.setAttribute("user_error_message", "Username \"" + username + "\" is already taken");
        }

        if( !passAreEqual ){
            request.setAttribute("pass_error_message", "Passwords are not matching");
        }

        if(user != null || !passAreEqual){
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

        try {
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
