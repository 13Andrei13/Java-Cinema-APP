import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class main {
    static public void main(String[] args) throws SQLException {
        String url = "jdbc:sqlserver://DESKTOP-1Q5348J\\SQLEXPRESS;databaseName=CinemaCityBuric";
        String username = "SA";
        String password = "Andrei0728095979@";
        Singleton databaseConnection = Singleton.getInstance(url, username, password);

        CreatieInterface creatieInterface = new CreatieInterface(databaseConnection.getCon());
        creatieInterface.start();
        creatieInterface.getFrame().setVisible(true);


        SalaMan doc = new SalaMan(databaseConnection.getCon());
        List<String> da = doc.getCi();

        for (String s : da) {
            System.out.println(s);
        }

//        for (Map.Entry<String, String> entry : da.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        int ok = doc.updateFilm("Spidermanu","165","RO", Date.valueOf("2000-10-10"),"Bun Film");
//               int ok =  doc.updateCategorie("Comedie","Actiune");
//        System.out.println(ok);
        // doc.showAll();
//                boolean b;
//                UsersMan doc = new UsersMan(databaseConnection.getCon());
//                doc.addCredentials("admin","admin");
//                b  = doc.checkCredentials("Admin","Admin");
//                System.out.println(b);
//
        //      doc.showAll();
        //
        //        UserManager userManager = new UserManager(databaseConnection.getCon());

        // databaseConnection.close();
    }
}