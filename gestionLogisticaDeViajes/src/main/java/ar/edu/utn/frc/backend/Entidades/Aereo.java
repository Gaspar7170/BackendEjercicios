package ar.edu.utn.frc.backend.Entidades;

public class Aereo extends Viaje {
    int millasAcumuladas;
    String codAeroLinea;

    public Aereo(String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int millasAcumuladas, String codAeroLinea) {
        super(codigo, nroReserva, precio, tipo, cliente);
        this.millasAcumuladas = millasAcumuladas;
        this.codAeroLinea = codAeroLinea;
    }
    
    

    public Aereo(String codigo, int nroReserva, double precio, int tipo, Cliente cliente) {
        super(codigo, nroReserva, precio, tipo, cliente);
    }


    public Aereo() {
    }


    public int getMillasAcumuladas() {
        return millasAcumuladas;
    }

    public void setMillasAcumuladas(int millasAcumuladas) {
        this.millasAcumuladas = millasAcumuladas;
    }

    public String getCodAeroLinea() {
        return codAeroLinea;
    }

    public void setCodAeroLinea(String codAeroLinea) {
        this.codAeroLinea = codAeroLinea;
    }
    @Override
    public String toString() {
        return "Aereo\n" + //
                "   millasAcumuladas=" + millasAcumuladas + "\n" +
                "   codAeroLinea='" + codAeroLinea + '\n' +
                ""+ super.toString();
    }

}
