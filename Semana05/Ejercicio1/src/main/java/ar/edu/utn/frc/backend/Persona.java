package ar.edu.utn.frc.backend;

public class Persona implements Comparable<Persona> {
    int documento;
    String nombre;
    String apellido;
    int edad;
    String ciudad;

    public Persona(int documento, String nombre, String apellido, int edad, String ciudad) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
    }
    public Persona() {
    }


    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Persona [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
                + ", ciudad=" + ciudad + "]";
    }

    @Override
    public int compareTo(Persona o) {
        return Integer.compare(this.edad, o.edad);
    }
    

}
