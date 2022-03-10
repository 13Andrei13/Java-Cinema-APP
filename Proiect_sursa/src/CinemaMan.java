import javax.print.Doc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CinemaMan {

    Connection connection;


    public CinemaMan(Connection connection) {
        this.connection = connection;
    }

    public void addCinema(String Locatie, String Adresa, String Telefon, String Oras, String Judet) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("INSERT INTO Cinema VALUES(?,?,?,?,?)");
        pstmt.setString(1, Locatie);
        pstmt.setString(2, Adresa);
        pstmt.setString(3, Telefon);
        pstmt.setString(4, Oras);
        pstmt.setString(5, Judet);
        int row = pstmt.executeUpdate();
    }

    public void deleteCinema(String Locatie, String Adresa, String Telefon, String Oras, String Judet) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("DELETE from Cinema where Locatie='" + Locatie + "'" + "AND Adresa='" + Adresa + "'" + "AND Telefon='" + Telefon + "'" + "AND Oras='" + Oras + "'" + "AND Judet='" + Judet + "'");

        int row = pstmt.executeUpdate();

    }

    public List<Cinema> showAll() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from Cinema");
        ResultSet rs = pstmt.executeQuery();
        List<Cinema> cinemaList = new ArrayList<>();
        while (rs.next()) {
            String Locatie1 = rs.getString(2);
            String Adresa1 = rs.getString(3);
            String Telefon1 = rs.getString(4);
            String Oras1 = rs.getString(5);
            String Judet1 = rs.getString(6);


            Cinema cinema = new Cinema(Locatie1, Adresa1, Telefon1, Oras1, Judet1);
            cinemaList.add(cinema);
        }


        rs.close();
        pstmt.close();

        return cinemaList;

    }

    public Map<String, String> incasariCinema() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("SELECT C.Locatie, SUM(Bf.PretBilet) FROM Cinema C JOIN [Bilet Film] Bf ON C.CinemaID = Bf.CinemaID" +
                        " GROUP BY C.Locatie " +
                        "ORDER BY SUM(Bf.PretBilet) desc");
        ResultSet rs = pstmt.executeQuery();
        Map<String, String> salaBi = new HashMap<>();
        while (rs.next()) {
            String sala = rs.getString(1);
            String nrBi = rs.getString(2);
            salaBi.put(sala, nrBi);
        }
        rs.close();
        pstmt.close();
        return salaBi;
    }

    public Map<String, String> cliCinema() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select C.Nume,  SUM(Bt.PretBilet) " +
                        " FROM Client C JOIN [Bilet Film] Bt " +
                        " ON C.ClientID = Bt.ClientID " +
                        " GROUP BY C.Nume " +
                        " ORDER BY SUM(Bt.PretBilet) asc ");
        ResultSet rs = pstmt.executeQuery();
        Map<String, String> salaBi = new HashMap<>();
        while (rs.next()) {
            String sala = rs.getString(1);
            String nrBi = rs.getString(2);
            salaBi.put(sala, nrBi);
        }
        rs.close();
        pstmt.close();
        return salaBi;
    }

    public List<String> fibyCin(String Locatie) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select DenumireFilm " +
                        " FROM Film " +
                        " Where FilmeID not in (Select FilmID " +
                        " FROM Film F JOIN FilmCategorie FC " +
                        " ON F.FilmeID = FC.FilmID " +
                        " JOIN CategorieFilm CF " +
                        " ON FC.CategorieID = CF.CategorieID " +
                        " Where CF.GenulFilm = ?)");
        pstmt.setString(1, Locatie);


        ResultSet rs = pstmt.executeQuery();
        List<String> salaBi = new ArrayList<>();

        while (rs.next()) {
            String sala = rs.getString(1);

            salaBi.add(sala);

        }
        rs.close();
        pstmt.close();
        return salaBi;
    }

    public List<String> clibyCin(String Locatie) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select C.Nume, C.Prenume " +
                        " FROM Client C JOIN [Bilet film] Bf " +
                        " ON C.ClientID = Bf.ClientID " +
                        " WHERE Bf.BiletFilmID in (Select BiletFilmID " +
                        " FROM [Bilet film] Bf JOIN Cinema C " +
                        " ON Bf.CinemaID = C.CinemaID " +
                        " Where C.Locatie = ?) ");
        pstmt.setString(1, Locatie);


        ResultSet rs = pstmt.executeQuery();
        List<String> salaBi = new ArrayList<>();

        while (rs.next()) {
            String sala1 = rs.getString(1);
            String sala2 = rs.getString(2);
            String sala = sala1 + " " + sala2;

            salaBi.add(sala);

        }
        rs.close();
        pstmt.close();
        return salaBi;
    }

}
