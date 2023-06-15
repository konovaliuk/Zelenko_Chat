package main.java.ConnectionPool;

import main.java.db.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class ConnClass{
    Connection connection;
    boolean isAvailiable;
}

public class ConnectionPool {
    List <ConnClass> connections_list = new ArrayList<ConnClass>();
    Connection CreateConnection() throws SQLException{
        ConnClass cc;
        
        cc.isAvailiable = true;
        cc.connection = DatabaseConnection.getConnection();

        connections_list.add(cc);
        return cc.connection;
    }

    Connection GetConnection() throws SQLException{
        for (ConnClass cc : connections_list){       ///////////?????????????????
            if(cc.isAvailiable){
                cc.isAvailiable = false;
                return cc.connection;
            }
        }
        return CreateConnection();
    }
    void initialize() throws SQLException{
        for (ConnClass cc : connections_list){
            cc.connection = DatabaseConnection.getConnection();
        }
    }
}
