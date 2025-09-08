package ar.edu.utn.frc.backend.menu;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import ar.edu.utn.frc.backend.ApplicationContext;
import ar.edu.utn.frc.backend.Persona;

public class Actions {
    public Actions() {
    }

    public void listar(ApplicationContext ctx) {
        AtomicInteger contador = new AtomicInteger(0);
        ctx.get("personas", List.class).stream().limit(20).forEach(p -> {
            System.out.println(p);
            contador.incrementAndGet();
        });
        if (contador.get() > 20) {
            System.out.println("Se mostraron las primeras 20 personas de un total de " + contador.get() + ".");
        } else {
            System.out.println("Se mostraron " + contador.get() + " personas.");
        }

    }
    public void buscar(ApplicationContext ctx){
        System.out.print("Ingrese el apellido o nombre a buscar: ");
        String apellidoONombre = ctx.get("in", java.util.Scanner.class).next();
        AtomicInteger contador = new AtomicInteger(0);
        ctx.get("personas", List.class).stream()
            .filter(p -> ((Persona) p).getApellido().equalsIgnoreCase(apellidoONombre) || ((Persona) p).getNombre().equalsIgnoreCase(apellidoONombre))
            .forEach(p -> {
                contador.incrementAndGet();
                if (contador.get() < 20) {
                    System.out.println(p);
                }
                
                
            });
        if (contador.get() > 20) {
            System.out.println("Se mostraron las primeras 20 coincidencias.");
        }
        System.out.println("Se encontraron " + contador.get() + " resultados.");

    }
    public void topEdades(ApplicationContext ctx){
        System.out.print("Ingrese la cantidad de personas a mostrar: ");
        try{
            int n = ctx.get("in", java.util.Scanner.class).nextInt();
            ctx.get("personas", List.class).stream()
                .sorted((p1, p2) -> Integer.compare(((Persona)p2).getEdad(), ((Persona)p1).getEdad()))
                .limit(n)
                .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al leer la entrada: " + e.getMessage());
        }
    }
    public void conteoPorCiudad(ApplicationContext ctx){
        ctx.get("personas", List.class).stream()
            .map(p -> ((Persona)p).getCiudad())
            //HACEMOS EL DISTINCT PARA QUE NO REPITA CIUDADES
            .distinct()
            .sorted()
            .forEach(ciudad -> {
                long count = ctx.get("personas", List.class).stream()
                    .filter(p -> ((Persona)p).getCiudad().equalsIgnoreCase((String) ciudad))
                    .count();
                System.out.println(ciudad + ": " + count);
            });
    }
    public void estadisticasEdad(ApplicationContext ctx){
        IntSummaryStatistics stats = ctx.get("personas", List.class).stream()
                                        .mapToInt(p -> ((Persona)p).getEdad()) // convertir a IntStream
                                        .summaryStatistics();
        System.out.println("Estadísticas de edad:");
        System.out.print("Total de personas: " + stats.getCount());
        System.out.print(", Edad mínima: " + stats.getMin());
        System.out.print(", Edad máxima: " + stats.getMax());
        System.out.print(", Edad promedio: " + stats.getAverage() + "\n");
    }
    /*
      IntSummaryStatistics stats = numeros.stream()
                                            .mapToInt(Integer::intValue) // convertir a IntStream
                                            .summaryStatistics();
     */

}
