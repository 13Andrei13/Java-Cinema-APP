
import javax.print.Doc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CategorieFilmMan {

    Connection connection;

    public CategorieFilmMan(Connection connection) {
        this.connection = connection;
    }

    public void addCategorieFilm(String GenulFilm) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("INSERT INTO CategorieFilm VALUES(?)");
        pstmt.setString(1, GenulFilm);
        int row = pstmt.executeUpdate();
    }

    public void deleteCategorieFilm(String GenulFilm) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("DELETE from CategorieFilm where GenulFilm='" + GenulFilm + "'");
        int row = pstmt.executeUpdate();
    }

    public int updateCategorie(String GenulFilm, String GenulFilmNew) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from CategorieFilm");
        ResultSet rs = pstmt.executeQuery();

        int ok = 0;

        while (rs.next()) {
            String GenulFilmBD = rs.getString(2);
            if (Objects.equals(GenulFilmBD, GenulFilm)) {
                ok = 1;
            }
        }
        if (ok == 1) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CategorieFilm " +
                    "SET GenulFilm = ? " +
                    "WHERE GenulFilm = ? ");

            preparedStatement.setString(1, GenulFilmNew);
            preparedStatement.setString(2, GenulFilm);


        }
        return ok;
    }


    public List<CategorieFilm> showAll() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select * from CategorieFilm");
        ResultSet rs = pstmt.executeQuery();
        List<CategorieFilm> categorieFilmList = new ArrayList<>();

        while (rs.next()) {
            String GenulFilm = rs.getString(2);
            CategorieFilm categorieFilm = new CategorieFilm(GenulFilm);
            categorieFilmList.add(categorieFilm);
        }
        rs.close();
        pstmt.close();

        return categorieFilmList;
    }

    public Map<String, String> catwFi(String DenumireFilm) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement
                ("Select F.DenumireFilm, CF.GenulFilm " +
                        " FROM Film F JOIN FilmCategorie FC " +
                        " ON F.FilmeID = FC.FilmID " +
                        " JOIN CategorieFilm CF " +
                        " ON CF.CategorieID = FC.CategorieID " +
                        " Where F.DenumireFilm = ?");
        pstmt.setString(1, DenumireFilm);


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


    //
//    public List<Doctor> findDoctorBySpecializare(String special) throws SQLException {
//        PreparedStatement pstmt = connection.prepareStatement
//                ("Select * from Doctor WHERE Specializare=?");
//        pstmt.setString(1,special);
//        ResultSet rs = pstmt.executeQuery();
//        List<Doctor> doctorList = new ArrayList<>();
//        while(rs.next()){
//            String nume1 = rs.getString(2);
//            String prenume1 = rs.getString(3);
//            String specializare1 = rs.getString(4);
//            int aniExp1 = Integer.parseInt(rs.getString(5));
//            Doctor doctor = new Doctor(nume1, prenume1, specializare1, aniExp1);
//            doctorList.add(doctor);
//        }
//        rs.close();
//        pstmt.close();
//
//        //Afisare consola
//        /*
//        System.out.println("Nume          Prenume          Specializare          AniExperienta");
//        System.out.println("------------------------------------------------------------------");
//        for(int index=0; index<doctorName.size(); index++){
//            System.out.println(doctorName.get(index)+"         "+prenume.get(index)+"              "+specializare.get(index)+"                  "+aniExp.get(index));
//        }
//        */
//
//        return doctorList;
//    }
//

}

