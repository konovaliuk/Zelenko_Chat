import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.java.db.DatabaseConnection;
import main.java.models.Users;
import main.java.dao.UsersDao;
import main.java.dao.impl.UsersDaoImpl;

public class Main {
    public static void main(String[] args) {
      MyAppInitializer.initialize();

      
      UsersDaoImpl UsersDao = new UsersDaoImpl();


      Users p = new Users("login_" + (int)(Math.random()*1_000_000), "lets_imagine_that_its_a_password_hash");
      UsersDao.CreateUser(p);

      UsersDao.promote(p.getId(), ProfileRole.SuperAdmin);

      Profile p2 = UsersDao.getById(p.getId());

      p2.print();











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