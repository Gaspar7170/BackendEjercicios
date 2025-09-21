package com.frc.isi.museo.util;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.frc.isi.museo.entidades.Autor;
import com.frc.isi.museo.entidades.EstiloArtistico;
import com.frc.isi.museo.entidades.Museo;
import com.frc.isi.museo.entidades.ObraArtistica;
import com.frc.isi.museo.menu.ApplicationContext;


public class CSVparser {
    //NOMBRE_OBRA,ANIO_CREACION,AUTOR,NOMBRE_MUSEO,ESTILO_ARTISTICO,MONTO_ASEGURADO,SEGURO_TOTAL
    //Las Meninas,1656,Diego Velázquez,Museo Nacional Centro de Arte Reina Sofía,Barroco,831374,1
    
    public static List<ObraArtistica> parseCSV(ApplicationContext context) {
        List<ObraArtistica> obras = new ArrayList();
         // Obtenemos el File desde el contexto
        File archivo = context.get("path", File.class);
        if (archivo == null) {
            System.out.println("Archivo no encontrado");
        }
        try(Stream<String> lines = Files.lines(archivo.toPath())) {
            lines.skip(1) // Saltar la cabecera
                 .map(line -> line.split(",")) // Dividir cada línea por comas
                 .forEach(fields -> {
                    String nombre = fields[0];
                    String anio = fields[1];
                    String autor = fields[2];
                    String nombreMuseo = fields[3];
                    String estilo = fields[4];
                    Double montoAsegurado = Double.parseDouble(fields[5]);
                    boolean seguro;
                    if(Integer.parseInt(fields[6]) == 1){seguro = true;}else{seguro = false;};
                    Autor autorC = new Autor(autor);
                    Museo nombreMuseoC  = new Museo(nombreMuseo);
                    EstiloArtistico estiloC = new EstiloArtistico(estilo);
                    obras.add(new ObraArtistica(nombre, anio, montoAsegurado, seguro,nombreMuseoC ,estiloC, autorC));
                    System.out.println(obras);                                    
                 });
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return obras;
    }
}
