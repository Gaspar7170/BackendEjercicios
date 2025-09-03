package ar.edu.utn.frc.backend.Entidades;

public class Terrestre extends Viaje {
    int provinciasVisitadas;
    int cantidadPasajeros;
    public Terrestre(String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int provinciasVisitadas,
            int cantidadPasajeros) {
        super(codigo, nroReserva, precio, tipo, cliente);
        this.provinciasVisitadas = provinciasVisitadas;
        this.cantidadPasajeros = cantidadPasajeros;
    }
    public Terrestre(int provinciasVisitadas, int cantidadPasajeros) {
        this.provinciasVisitadas = provinciasVisitadas;
        this.cantidadPasajeros = cantidadPasajeros;
    }
    

    public Terrestre(String codigo, int nroReserva, double precio, int tipo, Cliente cliente) {
        super(codigo, nroReserva, precio, tipo, cliente);
    }

    public Terrestre() {
    }

    public int getProvinciasVisitadas() {
        return provinciasVisitadas;
    }

    public void setProvinciasVisitadas(int provinciasVisitadas) {
        this.provinciasVisitadas = provinciasVisitadas;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
    @Override
    public String toString() {
        return "Terrestre\n" + //
                "   provinciasVisitadas=" + provinciasVisitadas + "\n" +
                "   cantidadPasajeros=" + cantidadPasajeros + "\n" +
                "" + super.toString();
    }


}
