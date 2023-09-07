package miniSas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Bibliotheque";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection connect;

    public static Connection connecter(){

        if(connect == null)
            connect = DbConnection.dbConnect();
        return connect;
    }


    public static Connection dbConnect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Error Message = " + e.getMessage());
        }
        return con;
    }
}
