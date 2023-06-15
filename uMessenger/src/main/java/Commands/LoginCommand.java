package Commands;

import ConnectionPool.ConnectionPool;
import DaoFactory.DaoFactory;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dao.impl.UsersDaoImpl;
import models.Users;
import security.PasswordHash;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

public class LoginCommand {

    public static void GETRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String key = "UserId";
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 1) {
            /*Optional<String> cookie = Arrays.stream(request.getCookies())
                    .filter(c -> key.equals(c.getName()))
                    .map(Cookie::getValue)
                    .findAny();

             */
            long userId = Long.parseLong(cookies[1].getValue());
            Connection connection = null;
            try {
                connection = ConnectionPool.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            UsersDaoImpl UsersDao = DaoFactory.UsersDao();
            Users user = null;
            try {
                user = UsersDao.GetUserById(userId, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String userRole = user.GetRole();
            if(userRole.equals("User")){
                response.sendRedirect("/uMessenger/chats");
            }
            else{
                response.sendRedirect("/uMessenger/reports");
            }
        //}
        //if(!cookie.isEmpty()){
            /*
            Algorithm algorithm = Algorithm.HMAC256("uMessenger");

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("uMessenger")
                    .build();
            String jwtToken = cookie.get();




            DecodedJWT decodedJWT = verifier.verify(jwtToken);

            if(decodedJWT.getClaim("userId").isNull()) {
                Cookie cookie_tmp = new Cookie("JWT", "0");
                cookie_tmp.setMaxAge(0);
                response.addCookie(cookie_tmp);
                request.setAttribute("user_error_message", "&#32;");
                request.setAttribute("pass_error_message", "&#32;");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else {
                long userId = decodedJWT.getClaim("userId").asLong();


            }
                */



        }else{
            request.setAttribute("user_error_message", "&#32;");
            request.setAttribute("pass_error_message", "&#32;");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    public static void POSTRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        String password = request.getParameter("Password");


        if(user!=null){
            String user_password = user.GetPassword();
            Boolean PassAreEqual = PasswordHash.Hash(password).equals(user_password);
                    if(PassAreEqual){
                        long userID = user.GetUserId();
                        Cookie cookie = new Cookie("UserId", Long.toString(userID));
                        cookie.setPath("/");
                        cookie.setMaxAge(60*60*60);
                        response.addCookie(cookie);

                        response.sendRedirect("/uMessenger/chats");
                    }else{
                        request.setAttribute("pass_error_message", "Password is incorrect");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
        }else {
            request.setAttribute("user_error_message", "Username \"" + username + "\" does not exist");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


}
