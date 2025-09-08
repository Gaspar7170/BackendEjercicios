package ar.edu.utn.frc.backend;

import java.util.List;

import ar.edu.utn.frc.backend.menu.Menu;
import ar.edu.utn.frc.backend.menu.MenuOption;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var ctx = ApplicationContext.getInstance();
        ctx.put("instrucciones", "Demo etapa 2");

        var opciones = List.of(
            new MenuOption(1, "Hola mundo", c -> System.out.println("¡Hola, mundo!")),
            new MenuOption(2, "Mostrar hora", c -> System.out.println("Hora actual: " + java.time.LocalTime.now()))
            //SI SE QUIERE PROBAR LA FUNCIONALIDAD DE GUARDAR Y MOSTRAR MENSAJE, DESCOMENTAR ESTO Y CAMBIAR EN LA LINEA 17 EL SYSTEM.OUT POR ctx.put("mensaje", "Tu mensaje aquí");
            /*,
            new MenuOption(3, "Mostrar mensaje guardado", c -> {
                var mensaje = ctx.get("mensaje", String.class);
                if (mensaje != null) {
                    System.out.println("Mensaje: " + mensaje);
                } else {
                    System.out.println("No hay mensaje guardado.");
                }
            }
            )
            */
        );
        new Menu("Menú Funcional — Etapa 2", opciones).run(ctx);
    }
}
