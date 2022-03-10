import java.sql.Date;

public class Film {



    public String getDenumireFilm() {
        return DenumireFilm;
    }

    public void setDenumireFilm(String denumireFilm) {
        DenumireFilm = denumireFilm;
    }

    public String getDurataFilm() {
        return DurataFilm;
    }

    public void setDurataFilm(String durataFilm) {
        DurataFilm = durataFilm;
    }

    public String getLimbaDifuzare() {
        return LimbaDifuzare;
    }

    public void setLimbaDifuzare(String limbaDifuzare) {
        LimbaDifuzare = limbaDifuzare;
    }

    public Film(String denumireFilm, String durataFilm, String limbaDifuzare, Date dataAparitie, String descriere) {
        DenumireFilm = denumireFilm;
        DurataFilm = durataFilm;
        LimbaDifuzare = limbaDifuzare;
        DataAparitie = dataAparitie;
        Descriere = descriere;
    }

    public Date getDataAparitie() {
        return DataAparitie;
    }

    public void setDataAparitie(Date dataAparitie) {
        DataAparitie = dataAparitie;
    }

    public String getDescriere() {
        return Descriere;
    }

    public void setDescriere(String descriere) {
        Descriere = descriere;
    }

    String DenumireFilm;
    String DurataFilm;
    String LimbaDifuzare;
    Date DataAparitie;
    String Descriere;
}
