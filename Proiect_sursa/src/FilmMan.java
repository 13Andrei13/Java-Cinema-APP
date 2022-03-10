import javax.print.Doc;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class FilmMan {

    Connection connection;

    public FilmMan(Connection connection) {
        this.connection = connection;
    }

    public void addFilm(String DenumireFilm, String DurataFilm, String LimbaDifuzare, Date DataAparitie, String Descriere) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("INSERT INTO Film VALUES(?,?,?,?,?)");
        pstmt.setString(1, DenumireFilm);
        pstmt.setString(2, DurataFilm);
        pstmt.setString(3, LimbaDifuzare);
        pstmt.setDate(4, DataAparitie);
        pstmt.setString(5, Descriere);
        int row = pstmt.executeUpdate();
    }

    public void deleteFilm(String DenumireFilm, String DurataFilm, String LimbaDifuzare, Date DataAparitie, String Descriere) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("DELETE from Film where DenumireFilm='" + DenumireFilm + "'" + "AND DurataFilm='" + DurataFilm + "'" + "AND LimbaDifuzare='" + LimbaDifuzare + "'" + "AND DataAparitie='" + DataAparitie + "'" + "AND Descriere='" + Descriere + "'");

        int row = pstmt.executeUpdate();

    }

    public int updateFilm(String nume, String DurataFilm, String LimbaDifuzare, Date DataAparitie, String Descriere) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from Film");
        ResultSet rs = pstmt.executeQuery();
        int ok = 0;
        while (rs.next()) {
            String Locatie1 = rs.getString(2);
            if (Objects.equals(Locatie1, nume)) {
                ok = 1;
            }


        }
        if (ok == 1) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Film " +
                    "SET DurataFilm = ? " + " , " + " LimbaDifuzare = ? " + " , " + " DataAparitie = ? " + " , " + " Descriere = ? " +
                    "WHERE DenumireFilm = ?");


            preparedStatement.setString(1, DurataFilm);
            preparedStatement.setString(2, LimbaDifuzare);
            preparedStatement.setDate(3, DataAparitie);
            preparedStatement.setString(4, Descriere);
            preparedStatement.setString(5, nume);

            int row = preparedStatement.executeUpdate();
        }
        return ok;
    }


    public List<Film> showAll() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from Film");
        ResultSet rs = pstmt.executeQuery();
        List<Film> filmList = new ArrayList<>();
        while (rs.next()) {
            String Locatie1 = rs.getString(2);
            String Adresa1 = rs.getString(3);
            String Telefon1 = rs.getString(4);
            Date Oras1 = Date.valueOf(rs.getString(5));
            String Judet1 = rs.getString(6);


            Film film = new Film(Locatie1, Adresa1, Telefon1, Oras1, Judet1);
            filmList.add(film);
        }


        rs.close();
        pstmt.close();

        return filmList;

    }

    public Map<String, String> filmBi() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select F.DenumireFilm, COUNT(Bf.BiletFilmID) " +
                        " FROM Film F JOIN [Bilet film] Bf " +
                        " ON F.FilmeID = Bf.FilmID " +
                        " GROUP BY F.DenumireFilm " +
                        " ORDER BY COUNT(Bf.BiletFilmID) desc");
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

    public Map<String, String> choFi(String DenumireFilm, String Locatie) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select S.TipSala,Oc.Ora " +
                        " FROM Film F JOIN [Orar cinematograf] Oc " +
                        " ON F.FilmeID = Oc.FilmID " +
                        " JOIN Cinema C " +
                        " On C.CinemaID = Oc.CinemaID " +
                        " JOIN Sala S " +
                        " ON S.SalaID = Oc.SalaID " +
                        " Where (F.DenumireFilm = ? and C.Locatie = ?)");
        pstmt.setString(1, DenumireFilm);
        pstmt.setString(2, Locatie);

        ResultSet rs = pstmt.executeQuery();
        Map<String, String> salaBi = new HashMap<>();
        int count = 0;
        while (rs.next()) {
            String sala = rs.getString(1);
            String nrBi = rs.getString(2);

            if (salaBi.containsKey(sala)) {
                sala = sala + count;
                count++;

                salaBi.put(sala, nrBi);
            } else {
                salaBi.put(sala, nrBi);
            }


        }
        rs.close();
        pstmt.close();
        return salaBi;
    }

    public String numbLimb() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select top 1 F.DenumireFilm " +
                        " FROM Film F JOIN [Bilet film] Bf " +
                        " ON F.FilmeID = Bf.FilmID  " +
                        " Where Bf.CinemaID = ( " +
                        " Select Bf.CinemaID " +
                        " FROM [Bilet film] Bf " +
                        " GROUP BY CinemaID " +
                        " Having COUNT(CinemaID) = (Select top 1 COUNT(Bf.BiletFilmID)  " +
                        " FROM Cinema C JOIN [Bilet film] Bf " +
                        " ON C.CinemaID = Bf.CinemaID " +
                        " GROUP BY C.CinemaID " +
                        " ORDER BY COUNT(Bf.BiletFilmID) desc) " +
                        " )" +
                        " GROUP BY F.DenumireFilm  " +
                        " Order BY COUNT(Bf.BiletFilmID) desc");


        ResultSet rs = pstmt.executeQuery();


        String sala = null;
        while (rs.next()) {
            sala = rs.getString(1);


        }
        rs.close();
        pstmt.close();
        return sala;
    }


}
