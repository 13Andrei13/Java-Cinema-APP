public class Cinema {
    public Cinema(String locatie, String adresa, String telefon, String oras, String judet) {
        Locatie = locatie;
        Adresa = adresa;
        Telefon = telefon;
        Oras = oras;
        Judet = judet;
    }

    public String getLocatie() {
        return Locatie;
    }

    public void setLocatie(String locatie) {
        Locatie = locatie;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getOras() {
        return Oras;
    }

    public void setOras(String oras) {
        Oras = oras;
    }

    public String getJudet() {
        return Judet;
    }

    public void setJudet(String judet) {
        Judet = judet;
    }

    String Locatie;
    String Adresa;
    String Telefon;
    String Oras;
    String Judet;
}
