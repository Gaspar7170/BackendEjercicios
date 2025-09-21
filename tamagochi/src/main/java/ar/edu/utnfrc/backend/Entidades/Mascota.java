package ar.edu.utnfrc.backend.Entidades;

public class Mascota {
    private String nombre;
    private int energia;
    private int humor;
    private boolean estado = false;
    private boolean durmiendo = false;
    private int contadorIngesta = 0;
    private int contadorActividad = 0;


    public Mascota(String nombre, int energia, int humor ) {
        this.nombre = nombre;
        this.energia = 50; // Valor inicial de energía
        this.humor = 3; // Valor inicial de humor
    }

    public boolean comer(){
        if(estado || durmiendo){return false;}
        System.out.println("Comiendo...");
        contadorActividad = 0;
        contadorIngesta += 1;
        
        if (contadorIngesta >= 3){
            if (contadorIngesta == 5){
                estado = true;
                energia = 0;
                humor = 0;
                System.out.println(nombre + " ha muerto por comer demasiado.");
            }
            humor -= 1;
            if (comprobacionHumor()){return true;}
        }

        if (energia < 100){
            energia += (int) energia*0.1;
            if (energia > 100){
                energia = 100;
            }
        }

        humor += 1;
        
        if(humor > 5){
            humor = 5;
        }
        return true;
    }
    public boolean beber(){
        if(estado || durmiendo){return false;}
        contadorIngesta += 1;
        
        if (contadorIngesta >= 3){
            if (contadorIngesta == 5){
                estado = true;
                energia = 0;
                humor = 0;
                System.out.println(nombre + " ha muerto por comer demasiado.");
            }
            humor -= 1;
            if(comprobacionHumor()){return true;}
        }

        System.out.println("Bebiendo...");
        
        contadorActividad = 0;
        if (energia < 100){
            energia += (int) energia*0.05;
            if (energia > 100){
                energia = 100;
            }
        }

        humor += 1;
        if(humor > 5){
            humor = 5;
        }
        return true;
    }
    public boolean correr(){
        if(estado || durmiendo){return false;}
        contadorActividad += 1;
        
        if (contadorActividad()){return true;}

        System.out.println("Corriendo...");
       
        contadorIngesta = 0;
        energia -=(int) energia*0.35;
        humor -= 2;
        
        if (comprobacionEnergia()){return true;}

        if (comprobacionHumor()){return true;}

        return true;
    }

    

    public boolean saltar(){
        if(estado || durmiendo){return false;}
         contadorActividad += 1;
        
        if (contadorActividad()){return true;}

        System.out.println("Saltando...");
        
        contadorIngesta = 0;
        energia -= (int) energia*0.15;
        humor -= 2;
        if (comprobacionEnergia()){return true;}

        if (comprobacionHumor()){return true;}

        return true;
    }

    public boolean dormir(){
        if(estado || durmiendo){return false;}
        durmiendo = true;
        System.out.println("Durmiendo...");
        contadorActividad = 0;
        contadorIngesta = 0;
        energia += 25;
        humor += 2;
        return true;
    }

    public boolean despertar(){
        if(estado){return false;}
        System.out.println("Despertando...");
        durmiendo = false;
        contadorActividad = 0;
        contadorIngesta = 0;
        humor -= 1;
        return true;
    }
    
    public boolean comprobacionHumor(){
        if(humor <= 0){
            humor = 0;
            durmiendo = true;
            System.out.println(nombre + " se fue a dormir porque se enojo.");
            return true;
        }
        return false;
    }

    public boolean comprobacionEnergia(){
        if(energia <= 0){
            energia = 0;
            estado = true;
            System.out.println(nombre + " ha muerto por falta de energía.");
            return true;
        }
        return false;
    }

    public boolean contadorActividad(){
        if (contadorActividad >= 3){
            durmiendo = true;
            System.out.println(nombre + " se enojo y se fue a dormir.");
            return true;
        }
        return false;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public int getHumor() {
        return humor;
    }
    public void setHumor(int humor) {
        this.humor = humor;
    }
    public String estadoHumor(){
        return switch (humor) {
            case 1 -> "Muy enojado";
            case 2 -> "Enojado";
            case 3 -> "Neutral";
            case 4 -> "Contento";
            case 5 -> "Muy contento";
            default -> "Desconocido";
        };
    }

    //To String
    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", humor=" + estadoHumor() +
                ", energia='" + energia + '\'' +
                ", estado=" + (estado ? "Muerto" : "Vivo") +
                ", durmiendo=" + (durmiendo ? "Sí" : "No") +
                '}';
    }

}
