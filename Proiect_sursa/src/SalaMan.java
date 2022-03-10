import javax.print.Doc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalaMan {

    Connection connection;

    public SalaMan(Connection connection) {
        this.connection = connection;
    }

    public void addSala(int Randuri, int Locuri, String TipSala) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("INSERT INTO Sala VALUES(?,?,?)");
        pstmt.setInt(1, Randuri);
        pstmt.setInt(2, Locuri);
        pstmt.setString(3, TipSala);
        int row = pstmt.executeUpdate();
    }

    public void deleteSala(int Randuri, int Locuri, String TipSala) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("DELETE from Sala where Randuri=" + Randuri + " AND Locuri =" + Locuri + " AND TipSala='" + TipSala + "'");

        int row = pstmt.executeUpdate();

    }

    public List<Sala> findSalaByTipSala(String TipSala) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from Sala WHERE TipSala = ?");
        pstmt.setString(1, TipSala);
        ResultSet rs = pstmt.executeQuery();
        List<Sala> salaList = new ArrayList<>();
        while (rs.next()) {
            int Randuri1 = Integer.parseInt(rs.getString(2));
            int Locuri1 = Integer.parseInt(rs.getString(3));
            String TipSala1 = rs.getString(4);
            Sala sala = new Sala(Randuri1, Locuri1, TipSala1);
            salaList.add(sala);
        }


        rs.close();
        pstmt.close();

        return salaList;

    }

    public List<Sala> showAll() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from Sala");
        ResultSet rs = pstmt.executeQuery();
        List<Sala> salaList = new ArrayList<>();
        while (rs.next()) {
            int Randuri1 = Integer.parseInt(rs.getString(2));
            int Locuri1 = Integer.parseInt(rs.getString(3));
            String TipSala1 = rs.getString(4);
            Sala sala = new Sala(Randuri1, Locuri1, TipSala1);
            salaList.add(sala);
        }


        rs.close();
        pstmt.close();

        return salaList;

    }

    public Map<String, String> salaBilete() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select S.TipSala, COUNT(BiletFIlmID) FROM [Bilet film] Bt JOIN [Orar cinematograf] Oc ON " +
                        "Bt.OrarCinematografID = Oc.OrarCinematografID JOIN Sala S ON Oc.SalaID = S.SalaID GROUP BY" +
                        " S.TipSala ORDER BY COUNT(BiletFilmID) asc");
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

    public Map<String, String> detNume(String Nume, String Prenume) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select C.Locatie, F.DenumireFilm " +
                        " FROM [Bilet film] Bf JOIN Cinema C " +
                        " ON Bf.CinemaID = C.CinemaID " +
                        " JOIN Film F " +
                        " ON Bf.FilmID = F.FilmeID " +
                        " where Bf.ClientID = (Select ClientID  " +
                        " FROM Client " +
                        " Where Nume = ? and Prenume = ?  ) ");
        pstmt.setString(1, Nume);
        pstmt.setString(2, Prenume);


        ResultSet rs = pstmt.executeQuery();
        Map<String, String> salaBi = new HashMap<>();
        int count = 0;
        while (rs.next()) {
            String sala = rs.getString(1);
            String nrBi = rs.getString(2);
            sala = sala + count;
            count++;
            salaBi.put(sala, nrBi);
        }
        rs.close();
        pstmt.close();
        return salaBi;
    }

    public List<String> getCi() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select Nume,Prenume " +
                        "FROM Client");


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
