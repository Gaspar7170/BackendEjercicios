package ar.edu.utn.frc.backend.Entidades;

public class Maritimo extends Viaje{
    int cantidadContenedores;
    double costoPorKilo;
    double pesoTransportado;
    
    public Maritimo(String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int cantidadContenedores,
            double costoPorKilo, double pesoTransportado) {
        super(codigo, nroReserva, precio, tipo, cliente);
        this.cantidadContenedores = cantidadContenedores;
        this.costoPorKilo = costoPorKilo;
        this.pesoTransportado = pesoTransportado;
    }

    public Maritimo() {
    }

    public double costoTotalPorViaje(){
        return costoPorKilo * pesoTransportado;
    }

    public int getCantidadContenedores() {
        return cantidadContenedores;
    }
    public void setCantidadContenedores(int cantidadContenedores) {
        this.cantidadContenedores = cantidadContenedores;
    }
    public double getCostoPorKilo() {
        return costoPorKilo;
    }
    public void setCostoPorKilo(double costoPorKilo) {
        this.costoPorKilo = costoPorKilo;
    }
    public double getPesoTransportado() {
        return pesoTransportado;
    }
    public void setPesoTransportado(double pesoTransportado) {
        this.pesoTransportado = pesoTransportado;
    }

    @Override
    public String toString() {
        return "Maritimo\n" + //
                "   cantidadContenedores=" + cantidadContenedores + "\n" +
                "   costoPorKilo=" + costoPorKilo + "\n" +
                "" + super.toString();
    }

}
