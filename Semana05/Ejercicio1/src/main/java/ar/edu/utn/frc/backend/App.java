package ar.edu.utn.frc.backend;

import java.util.List;

import ar.edu.utn.frc.backend.menu.Menu;
import ar.edu.utn.frc.backend.menu.MenuOption;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var opciones = List.of(
            new MenuOption(1, "Hola mundo", () -> System.out.println("¡Hola!")),
            new MenuOption(2, "Mostrar hora", () -> System.out.println(java.time.LocalTime.now()))
        );
        new Menu("Menú Funcional - Etapa 1", opciones).run();   
    }
}
