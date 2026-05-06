public class Horario {
    private int hora, minuto;

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public String toString() {
        return this.getHora() + ":" + this.getMinuto();
    }

    public int compara(Horario h2) {
        if (h2.getHora() == this.getHora()) {
            return Integer.compare(this.getMinuto(), h2.getMinuto());
        }
        if (this.getHora() > h2.getHora()) return 1;
        return -1;
}

    public int calcTempo(Horario h2) {
        if (this.getHora() == h2.getHora()) {
            return 1;
        }
        if (h2.getMinuto() != 0) {
            return h2.getHora() - this.getHora() + 1;
        }
        return h2.getHora() - this.getHora();
    }
}
