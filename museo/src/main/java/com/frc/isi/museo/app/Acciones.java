package com.frc.isi.museo.app;

import java.util.List;

import com.frc.isi.museo.entidades.ObraArtistica;
import com.frc.isi.museo.menu.ApplicationContext;
import com.frc.isi.museo.util.CSVparser;

public class Acciones {
    // public void nombreMetodo(ApplicationContext context) cada metodo de esta
    // clase la firma debe ser esta
    public void listarObras(ApplicationContext context) {
        //parser.parseCSV(context).stream().forEach(System.out::println);
        List<ObraArtistica> lista = CSVparser.parseCSV(context);

    }
}
