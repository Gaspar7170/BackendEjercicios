package ar.edu.utnfrc.backend;

import ar.edu.utnfrc.backend.Entidades.Mascota;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Mascota luna = new Mascota("Luna", 50, 3);
        luna.beber();
        luna.comer();
        luna.comer();
        luna.comer();
        System.out.println(luna.toString());
        luna.correr();
        luna.correr();
        luna.correr();
        luna.correr();
        luna.correr();
        luna.saltar();
        luna.saltar();
        luna.saltar();
        luna.saltar();
        luna.saltar();
        luna.dormir();
        luna.despertar();
        luna.beber();
    }
}
