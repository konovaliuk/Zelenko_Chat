public class MyAppInitializer {
    static {
        try {
            //Class.forName("org.mariadb.jdbc.Driver");
             Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Handle the exception appropriately
        }
    }

    public static void initialize() {
        // Perform any additional initialization tasks
    }
}