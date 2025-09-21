package com.frc.isi.museo.app;

import java.io.File;

import com.frc.isi.museo.menu.ApplicationContext;
import com.frc.isi.museo.menu.ItemMenu;
import com.frc.isi.museo.menu.Menu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        var ctx = ApplicationContext.getInstance();
        Menu menu = new Menu();
        menu.setTitulo("Menu de Opciones para Museo");

        Acciones acciones = new Acciones();

        File archivo = new File("src/main/resources/files/obras.csv");
        ctx.put("path", archivo);
        

        // Las otras acciones van aqui
        menu.addOpcion(new ItemMenu(0, "Salir", p -> System.exit(1)));
        menu.addOpcion(new ItemMenu(1, "Listar Obras", acciones::listarObras));

        menu.ejecutar(ctx);

    }
}
