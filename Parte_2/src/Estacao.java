public class Estacao extends Espaco{
    private boolean monitorExtra;
    private static double precoMonitor;

    public boolean isMonitorExtra() {
        return monitorExtra;
    }

    public double preco(Horario inicio, Horario fim) {
        return super.preco(inicio, fim) + precoMonitor;
    }

    public boolean possuiAdicional() {
        return this.monitorExtra;
    }
}
