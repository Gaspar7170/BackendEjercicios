package ar.edu.utn.frc.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import ar.edu.utn.frc.backend.Entidades.Aereo;
import ar.edu.utn.frc.backend.Entidades.Cliente;
import ar.edu.utn.frc.backend.Entidades.Maritimo;
import ar.edu.utn.frc.backend.Entidades.Terrestre;
import ar.edu.utn.frc.backend.Entidades.Viaje;
//Ya que las clases se encuentran en otra carpeta dentro del package es necesario importarlas de lo contrario no reconoce las clases.
//Autor: Arrigo Gaspar.

public class App {
    public static void main(String[] args) {
        //codigo;nroReserva;precio;tipoViaje;
        //AEREO millasAcumuladas;codAerolinea;
        //TERRESTRE provinciasVisitadas;cantidadPasajeros;
        //MARITIMO cantidadContenedores;costoPorKilo;pesoTransportado;
        //CLIENTE nombreEmpresa;cuit

        //Variables
        ArrayList<Viaje> viajes = new ArrayList<>();
        HashMap<String, Cliente> clientesHashMap = new HashMap<>();
        //int limit = 0;

        //Asignamos la ruta del archivo que vamos a leer
        File archivo = new File("viajes.csv");
        //Se intenta leer dicho archivo, en caso de que no exista entonces el try agarra la 
        //excepcion y tira error
        try (Scanner sc = new Scanner(archivo)){
            sc.nextLine();
            while (sc.hasNextLine()){
                //limit++;
                //Asignamos los datos de la linea en la variable datos
                String[] datos = sc.nextLine().split(";");
                //Ahora sabemos que los primeros 4 datos son de la clase Viaje
                String codigo = datos[0];
                int nroReserva = Integer.parseInt(datos[1]);
                double precio = Double.parseDouble(datos[2]);
                String tipoViaje = datos[3];
                //Sabemos que los siguientes 2 datos son de la Clase AEREO
                int millasAcumuladas = Integer.parseInt(datos[4]);
                String codAerolinea = datos[5];
                //Sabemos que los siguientes datos son de la clase TERRESTRE
                String[] provinciasVisitadas = datos[6].split(";");
                int cantidadPasajeros = Integer.parseInt(datos[7]);
                //Sabemos que los siguientes 3 datos son de la clase MARITIMO
                int cantidadContenedores = Integer.parseInt(datos[8]);
                double costoPorKilo = Double.parseDouble(datos[9]);
                double pesoTransportado = Double.parseDouble(datos[10]);
                //Y por ultimo sabemos que los ultimos dos datos son de la clase CLIENTE
                String nombreEmpresa = datos[11];
                String cuit = datos[12];
                //Luego de asignar los datos a cada variable procedemos a verificar que tipo de viaje es
                //e INSTANCIARLO!!
                Cliente cliente = new Cliente(nombreEmpresa, cuit);
                switch (tipoViaje){
                    case "1":
                    //AEREO String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int millasAcumuladas, String codAeroLinea
                    //Instanciamos el objeto Aereo con los datos de su super clase (VIAJE) y la de ella misma.
                    Aereo viajeAereo = new Aereo(codigo, nroReserva, precio, 1, cliente, millasAcumuladas,codAerolinea);
                    //Preguntamos si el HashMap del cliente contiene el cuit del cliente, es decir el identificador, si no lo contiene entonces agregamos el cliente
                    //Si lo contiene no agregamos nada ya que este HashMap no es un contador si no solamente para saber si el cliente ya fue registrado.
                    if(!clientesHashMap.containsKey(cliente.getCuit())){
                        clientesHashMap.put(cliente.getCuit(), cliente);
                    }
                    //Agregamos el viaje a una colleccion tipo ArrayList de tipo <Viaje> el viaje. Especial atencion a que no falla por que AEREO hereda de Super.
                    //Asi como no falla cuando ponemos ArrayList<Object> y le añadimos cualquier clase. En este caso es igual.
                    viajes.add(viajeAereo);
                    break;
                    case "2":
                    //TERRESTRE String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int provinciasVisitadas,
                    //Instanciamos el objeto Terrestre con los datos de su super clase (VIAJE) y la de ella misma.
                    Terrestre viajeTerrestre = new Terrestre(codigo, nroReserva, precio, 2, cliente, provinciasVisitadas.length,cantidadPasajeros);
                    //Preguntamos si el HashMap del cliente contiene el cuit del cliente, es decir el identificador, si no lo contiene entonces agregamos el cliente
                    //Si lo contiene no agregamos nada ya que este HashMap no es un contador si no solamente para saber si el cliente ya fue registrado.
                    if(!clientesHashMap.containsKey(cliente.getCuit())){
                        clientesHashMap.put(cliente.getCuit(), cliente);
                    }
                    //Agregamos el viaje a una colleccion tipo ArrayList de tipo <Viaje> el viaje. Especial atencion a que no falla por que TERRESTRE hereda de Super.
                    //Asi como no falla cuando ponemos ArrayList<Object> y le añadimos cualquier clase. En este caso es igual.
                    viajes.add(viajeTerrestre);
                    break;
                    case "3":
                    //MARITIMO String codigo, int nroReserva, double precio, int tipo, Cliente cliente, int cantidadContenedores, double costoPorKilo, double pesoTransportado
                    //Instanciamos el objeto Maritimo con los datos de su super clase (VIAJE) y la de ella misma.
                    Maritimo viajeMaritimo = new Maritimo(codigo, nroReserva, precio, 3, cliente, cantidadContenedores, costoPorKilo, pesoTransportado);
                    //Preguntamos si el HashMap del cliente contiene el cuit del cliente, es decir el identificador, si no lo contiene entonces agregamos el cliente
                    //Si lo contiene no agregamos nada ya que este HashMap no es un contador si no solamente para saber si el cliente ya fue registrado.
                    if(!clientesHashMap.containsKey(cliente.getCuit())){
                        clientesHashMap.put(cliente.getCuit(), cliente);
                    }
                    //Agregamos el viaje a una colleccion tipo ArrayList de tipo <Viaje> el viaje. Especial atencion a que no falla por que MARITIMO hereda de Super.
                    //Asi como no falla cuando ponemos ArrayList<Object> y le añadimos cualquier clase. En este caso es igual.
                    viajes.add(viajeMaritimo);
                    break;
                    
                }

            }
        //Aca es donde agarramos la excepcion de si no encuentra el archivo e imprimimos un mensaje de error.
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //Mostramos todos los clientes que se tienen de todos los viajes. Una unica vez.
        clientesHashMap.forEach((k, cliente) -> System.out.println("Cliente: " + cliente));
        //Mostramos la cantidad de clientes que hay en total.
        System.out.println("Cantidad de clientes: " + clientesHashMap.size());
        
        //Seccion variables de cantidad para reporte.
        int contadorAereo = 0;
        int contadorTerrestre = 0;
        int contadorMaritimo = 0;
        int cantidadPasajeros = 0;
        int cantidadMillas = 0;
        int cantidadContenedores = 0;
        double costoAcumulado = 0;
        //Recorremos cada viaje con un for each.
        for(Viaje v : viajes){
            //Obtenemos el tipo para obtener datos de cada viaje en especifico
            switch(v.getTipo()){
                case 1:
                    contadorAereo++;
                    //Casteamos al tipo de viaje que es, al hacer el switch antes nos aseguramos que el casteo sea 100% fiable.
                    cantidadMillas += ((Aereo) v).getMillasAcumuladas();
                    break;
                case 2:
                    contadorTerrestre++;
                    //Casteamos al tipo de viaje que es, al hacer el switch antes nos aseguramos que el casteo sea 100% fiable.
                    cantidadPasajeros += ((Terrestre) v).getCantidadPasajeros();
                    break;
                case 3:
                    contadorMaritimo++;
                    //Casteamos al tipo de viaje que es, al hacer el switch antes nos aseguramos que el casteo sea 100% fiable.
                    cantidadContenedores += ((Maritimo) v).getCantidadContenedores();
                    //Preguntamos la cantidad de contenedores que tiene cada viaje maritimo y si tiene mas de 5 acumulamos el costo
                    //No usamos cantidadContenedores porque es un acumulador y de usarlo a la primera que se tenga +5 ya empieza a contar a todos los viajes cosa que esta mal.
                    if(((Maritimo) v).getCantidadContenedores() >= 5) {
                        //llamamos a la funcion que calcula el costo del viaje
                        costoAcumulado += ((Maritimo) v).costoTotalPorViaje();
                    }
                    break;
            }
        }

        //Seccion de reportes.
        System.out.println("Total de viajes: " + viajes.size());
        System.out.println("Hay " + contadorAereo + " viajes aéreos");
        System.out.println("Hay " + contadorTerrestre + " viajes terrestres");
        System.out.println("Hay " + contadorMaritimo + " viajes marítimos");
        System.out.println("Total de pasajeros en viajes terrestres: " + cantidadPasajeros);
        System.out.println("Total de millas en viajes aéreos: " + cantidadMillas);
        System.out.println("Total de contenedores en viajes marítimos: " + cantidadContenedores);
        System.out.println("Total de costo en viajes marítimos con 5 o mas contenedores: " + costoAcumulado);

        //SECCION EXTRA DE IMPRESION DE REPORTE!!! NO ESTA EN EL ENUNCIADO!!
        //Cada vez que se ejecute el codigo se generara un archivo del tipo txt en la carpeta del proyecto (Altura de POM.xml).
        //De querer probar la funcionalidad borrar dicho archivo "reporte.txt" y ejecutar nuevamente.
        File reporte = new File("reporte.txt");
        try {
            FileWriter writer = new FileWriter(reporte);
            writer.write("Reporte de Viajes\n");
            writer.write("Cantidad de clientes: " + clientesHashMap.size() + "\n");
            writer.write("Total de viajes: " + viajes.size() + "\n");
            writer.write("Hay " + contadorAereo + " viajes aéreos\n");
            writer.write("Hay " + contadorTerrestre + " viajes terrestres\n");
            writer.write("Hay " + contadorMaritimo + " viajes marítimos\n");
            writer.write("Total de pasajeros en viajes terrestres: " + cantidadPasajeros + "\n");
            writer.write("Total de millas en viajes aéreos: " + cantidadMillas + "\n");
            writer.write("Total de contenedores en viajes marítimos: " + cantidadContenedores + "\n");
            writer.write("Total de costo en viajes marítimos con 5 o mas contenedores: " + costoAcumulado + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo de reporte: " + e.getMessage());
        }


    }
}
