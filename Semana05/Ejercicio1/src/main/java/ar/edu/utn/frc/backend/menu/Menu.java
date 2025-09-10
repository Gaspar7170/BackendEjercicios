package ar.edu.utn.frc.backend.menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ar.edu.utn.frc.backend.ApplicationContext;

/*
Rol: mostrar opciones, leer entrada, resolver la acción y ejecutarla.
Requisitos:
    Mostrar todas las opciones ordenadas por code. (SORT)
    Aceptar 0 para salir. (WHILE != 0)
    Validar entradas no numéricas sin romper el programa. (TRY CATCH)
    Buscar la opción por code y, si no existe, informar "Opción inválida". (DENTRO DEL WHILE)
Criterio de aceptación: debe permitir inyectar una lista de MenuOption en el constructor. (YA CONTEMPLADO EN EL CONSTRUCTOR)
 */


public class Menu implements FuncAction {
    private String nombre;
    private List<MenuOption> opciones;

    public Menu(String nombre, List<MenuOption> opciones) {
        this.nombre = nombre;
        this.opciones = opciones;
    }

    private void validaciones(){
        if (opciones == null || opciones.isEmpty()) {
            System.out.println("El menú no tiene opciones disponibles.");
            return;
        }
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("El menú no tiene un nombre válido.");
        }
    }

    @Override
    public void run(ApplicationContext ctx) {
        //Validaciones
        validaciones();
        // Ordenar las opciones por código
        //IMPORTANTE DE USAR COLLECTORS con "S" y no Collector sin "S"
        opciones = opciones.stream().sorted().collect(Collectors.toList());
        // Mostrar el menú y manejar la selección del usuario
        System.out.println("=== " + nombre + " ===");
        Scanner sc = new Scanner(System.in);
        ctx.put("in", sc);
        int opcion = -1;
        while(opcion != 0){
            for (MenuOption option : opciones) {
            //MOSTRAMOS LAS OPCIONES DISPONIBLES DEL MENU
            System.out.println(option.code + ". " + option.label);
            }
            try {
                System.out.println("Seleccione una opción (0 para salir): ");
                opcion = sc.nextInt();
                if(1 <= opcion && opcion <= opciones.size()){
                    //BUSCAMOS LA OPCION SELECCIONADA
                    for (MenuOption option : opciones) {
                        if(option.code == opcion){
                            option.action.run(ctx);
                        }
                    }
                } else if (opcion != 0) {
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entre las opciones.");
                sc.next(); // Limpiar el buffer
            }
        }

    }
}
