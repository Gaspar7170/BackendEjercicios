package ar.edu.utn.frc.backend;

import java.util.ArrayList;
import java.util.List;

public class DataSeeder {
    

    private DataSeeder() {
    }
    public static List<Persona> generar(int cantidadPersonas){
        List<Persona> personas = new ArrayList<>();
        List<String> ciudades = List.of("Buenos Aires", "Cordoba", "La Plata", "Rosario", "Mendoza");
        List<String> nombres = List.of("Juan", "Mariana", "Jose", "Ana", "Luis");
        List<String> apellidos = List.of("Perez", "Gomez", "Lopez", "Martinez", "Fernandez");
        //Edad limitada entre 18-65
        int edad;
        for(int i=1; i<=cantidadPersonas; i++){
            edad = 18 + (i % 48);
            personas.add(new Persona(30000000 + i, nombres.get((i-1) % nombres.size()), apellidos.get((i-1) % apellidos.size()), edad, ciudades.get((i-1) % ciudades.size())));
        }
        return personas;
    }
    
}
