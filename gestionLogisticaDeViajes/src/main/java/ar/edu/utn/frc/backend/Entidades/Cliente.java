package ar.edu.utn.frc.backend.Entidades;

public class Cliente {
    String nombreEmpresa;
    String cuit;

    
    public Cliente(String nombreEmpresa, String cuit) {
        this.nombreEmpresa = nombreEmpresa;
        this.cuit = cuit;
    }
    
    public Cliente() {
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getCuit() {
        return cuit;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    @Override
    public String toString() {
        return "Cliente" +
                "nombreEmpresa='" + nombreEmpresa + '\n' +
                "cuit='" + cuit + '\n' +
                ' ';
    }

}
