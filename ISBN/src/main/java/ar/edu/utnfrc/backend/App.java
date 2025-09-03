package ar.edu.utnfrc.backend;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        punto2();
    }

    public static void punto2() {
        //(x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de cédula (10 dígitos): ");
        String cedula = scanner.nextLine();
        cedula = cedula.replace("-", "");
        if (cedula.length() != 10) {
            scanner.close();
            return;
        }
        int suma = 0;
        for (int i = 0; i < 10; i++) {
            int num = Character.getNumericValue(cedula.charAt(i));
            suma += num * (10 - i);
        }
        if (suma % 11 == 0) {
            System.out.println("Cédula válida");
        } else {
            System.out.println("Cédula inválida");
        }
        scanner.close();
    }
}
