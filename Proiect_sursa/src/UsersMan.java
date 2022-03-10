import javax.print.Doc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersMan {
    Connection connection;

    public UsersMan(Connection connection) {
        this.connection = connection;
    }

    public void addCredentials(String Username, String Password) throws SQLException{
        PreparedStatement pstmt = connection.prepareStatement
                ("INSERT INTO Users VALUES(?,?)");
        pstmt.setString(1, Username);
        pstmt.setString(2, Password);

        int row = pstmt.executeUpdate();


    }

    public boolean checkCredentials(String username, String password) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from Users WHERE username=? AND password=?");
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            System.out.println("User si parola corecte");
            return true;
        }
        rs.close();
        pstmt.close();

        System.out.println("Credentiale incorecte");
        return false;
    }
}
