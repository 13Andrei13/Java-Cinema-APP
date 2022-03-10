public class Sala {


    public Sala(int randuri, int locuri, String tipSala) {
        Randuri = randuri;
        Locuri = locuri;
        TipSala = tipSala;
    }

    public int getRanduri() {
        return Randuri;
    }

    public void setRanduri(int randuri) {
        Randuri = randuri;
    }

    public int getLocuri() {
        return Locuri;
    }

    public void setLocuri(int locuri) {
        Locuri = locuri;
    }

    public String getTipSala() {
        return TipSala;
    }

    public void setTipSala(String tipSala) {
        TipSala = tipSala;
    }

    int Randuri;
    int Locuri;
    String TipSala;
}
