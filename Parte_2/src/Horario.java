public class Horario {
    private int hora;
    private int minuto;

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int compara(Horario h2) {
        if (h2.getHora() == this.hora) {
            if (this.minuto > h2.getMinuto()) return 1;
            if (this.minuto < h2.getMinuto()) return -1;
            else return 0;
        }
        if (this.hora > h2.getHora()) return 1;
        return -1;

    }

    public String toString() {
        return "Horario{" +
                "hora=" + hora +
                ", minuto=" + minuto +
                '}';
    }
}
