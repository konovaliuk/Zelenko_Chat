package MyAppInitializer;
public class MyAppInitializer {
    public static void initialize() {
        // Perform any additional initialization tasks
            try {
                //Class.forName("org.mariadb.jdbc.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver    //com.mysql.cj.jdbc.Driver
            } catch (ClassNotFoundException e) {
                // Handle the exception appropriately
            }
        }
}