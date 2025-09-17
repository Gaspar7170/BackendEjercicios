package com.frc.isi.museo.app;

import java.net.URL;

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

        URL folderPath = App.class.getResource("/files");
        ctx.set("path", folderPath);

        // Las otras acciones van aqui
        menu.addOpcion(new ItemMenu(0, "Salir", p -> System.exit(1)));

    }
}
