import java.sql.*;

public class Singleton {
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;

    String url;
    Connection con;

    // private constructor restricted to this class itself
    private Singleton(String url, String user, String password) throws SQLException {
        this.url = url;
        con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to the database");
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }

    // static method to create instance of Singleton class
    public static Singleton getInstance(String url, String user, String password) throws SQLException {
        if (single_instance == null)
            single_instance = new Singleton(url, user, password);
        return single_instance;
    }

    public void close() throws SQLException {
        if (con != null) con.close();
    }

    public Connection getCon() {
        return con;
    }
}