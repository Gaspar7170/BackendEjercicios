package ar.edu.utn.frc.backend;

import java.util.List;

import ar.edu.utn.frc.backend.menu.Actions;
import ar.edu.utn.frc.backend.menu.Menu;
import ar.edu.utn.frc.backend.menu.MenuOption;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var ctx = ApplicationContext.getInstance();
        ctx.put("personas", DataSeeder.generar(400));

        var actions = new Actions();
        var opciones = List.of(
            new MenuOption(1, "Listar (20 primeras)", actions::listar),
            new MenuOption(2, "Buscar por texto",    actions::buscar),
            new MenuOption(3, "Top N por edad",      actions::topEdades),
            new MenuOption(4, "Conteo por ciudad",   actions::conteoPorCiudad),
            new MenuOption(5, "Estadísticas de edad",actions::estadisticasEdad)
        );
        new Menu("Menú Funcional — Etapa 3", opciones).run(ctx);
    }
}
