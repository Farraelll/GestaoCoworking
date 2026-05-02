public class Data {
    private int dia, mes, ano;

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public boolean equals(Data d2) {
        return getDia() == d2.getDia() && getMes() == d2.getMes() && getAno() == d2.getAno();
    }
}