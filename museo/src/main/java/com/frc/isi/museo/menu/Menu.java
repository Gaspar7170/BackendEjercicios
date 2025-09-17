package com.frc.isi.museo.menu;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import lombok.Setter;

public class Menu {
    @Setter
    public String titulo;
    public List<ItemMenu> opciones = new java.util.ArrayList<>();

    private int safeInt(Scanner in) {
        while (!in.hasNextInt()) {
            in.next();
            System.out.print("> Opción: ");
        }
        int n = in.nextInt();
        in.nextLine();
        return n;
    }

    public void addOpcion(ItemMenu opcion) {
        this.opciones.add(opcion);
    }

    public void ejecutar(ApplicationContext contexto) {
        var lector = new Scanner(System.in);
        contexto.setOrThrow("lector", lector);
        try {

            while (true) {
                System.out.println(titulo);
                System.out.println("======================================");
                this.opciones.forEach(o -> System.err.printf("%2d) --- %s%n", o.indice(), o.mensaje()));
                System.out.println("0 - Salir");
                int opcion = safeInt(lector);

                if (opcion == 0)
                    break;

                this.opciones.stream()
                        .filter(o -> o.indice() == opcion)
                        .findFirst()
                        .ifPresentOrElse(
                                o -> o.accion().invocar(contexto),
                                () -> System.out.println("Opcion invalida...."));

            }

        } catch (IllegalArgumentException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        } finally {
            lector.close();
        }

        System.out.println("Apliacion terminada.....");

    }
}
