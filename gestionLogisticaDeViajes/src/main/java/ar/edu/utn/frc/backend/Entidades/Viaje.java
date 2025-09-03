package ar.edu.utn.frc.backend.Entidades;

public class Viaje {
    String codigo;
    int nroReserva;
    double precio;
    int tipo;
    Cliente cliente;
   
    
    public Viaje(String codigo, int nroReserva, double precio, int tipo, Cliente cliente) {
        this.codigo = codigo;
        this.nroReserva = nroReserva;
        this.precio = precio;
        this.tipo = tipo;
        this.cliente = cliente;
    }
    
    public Viaje() {
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getNroReserva() {
        return nroReserva;
    }
    public void setNroReserva(int nroReserva) {
        this.nroReserva = nroReserva;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return "Viaje: " +
                "   codigo='" + codigo + '\n' +
                "   nroReserva=" + nroReserva + '\n' +
                "   precio=" + precio + '\n' +
                "   tipo=" + tipo + '\n' +
                '}';
    }

   

   
}
