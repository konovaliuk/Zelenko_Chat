import java.sql.SQLException;

import ConnectionPool.ConnectionPool;
import DaoFactory.DaoFactory;
import dao.UsersGroupsDao;
import dao.impl.MessagesDaoImpl;
import dao.impl.UsersDaoImpl;
import dao.impl.UsersGroupsDaoImpl;
import models.Messages;
import models.Groups;
import models.Users;

public class Main {
    public static void main(String[] args) throws SQLException {
      //MyAppInitializer.initialize();

      
      //UsersDaoImpl UsersDao = new UsersDaoImpl();

       // MessagesDaoImpl MessagesDao = new MessagesDaoImpl();

      //Users p = new Users(80, "User", "Standard",  "993299929", "SOME ULTRA SECRET PASSWORD" );
      //UsersDao.CreateUser(p);
      //UsersDao.Demote(p.GetUserId());

      //Users p2 = UsersDao.GetUserByUsername("Standard");
      //if (p2 != null)
      //  UsersDao.ChangePhoneNumber(80, "77384534");
      //p2.print();
      //  UsersDao.Demote(80);

        //java.util.Date dt = new java.util.Date();

       // java.text.SimpleDateFormat sdf =
        //        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        //String currentTime = sdf.format(dt);

       // Messages mes = new Messages(1, 1, 1, "Test Message", "Sent");

        //MessagesDao.SetMessageAsRead(1);


        DaoFactory factory = new DaoFactory();
        UsersGroupsDaoImpl UsersGroupsDao = factory.UsersGroupsDao();

        Users[] users = UsersGroupsDao.GetUsersByGroupId(2);

        for (int i = 0; i < users.length; i++){
            System.out.println(users[i].GetUsername());
        }

        ConnectionPool.closeAllConnections();


    //System.out.println(currentTime);

/*
        Messages[] messages = MessagesDao.GetMessagesByGroupId(1);

        for (int i = 0; i < messages.length; i++){
            System.out.println(messages[i].getMessageId());
        }
*/







        // String url = "jdbc:mysql://localhost:3306/coursework";
        // String user = "root";
        // String pwd = "root";

        // try (Connection conn = DriverManager.getConnection(url, user, pwd);
        //         Statement stmt = conn.createStatement()) {

        //   try {
        //     ResultSet rs = stmt.executeQuery("select * from users;");
        //     while (rs.next()) {
        //       String name = rs.getString("username");
        //       String password = rs.getString("password");
        //       System.out.print(name);
        //       System.out.print("\t\t\t");
        //       System.out.println(password);

        //     }
        //   } catch (SQLException e ) {
        //         throw new Error("Problem", e);
        //   } 
        //   stmt.close();
        //   conn.close();  

        // } catch (SQLException e) {
        //   throw new Error("Problem", e);
        // } 
        //String sql = "SELECT id, username FROM users WHERE id = ?";
        // Rest of your code
         
    }
}
/*
public class WhatIsJdbc{
   // Class.forName("org.mariadb.jdbc.Driver");
  public static void main(String[] args) {
    
  }
}
*/