package practico3.ejercicio6;

import practico3.ejercicio1.GrafoDirigido;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido gd = new GrafoDirigido();
        gd.agregarVertice(1);
        gd.agregarVertice(2);
        gd.agregarVertice(5);
        gd.agregarVertice(3);
        gd.agregarVertice(8);
        gd.agregarVertice(4);
        gd.agregarArco(1,2,"unodos");
        gd.agregarArco(1,3,"unotres");
        gd.agregarArco(2,5,"doscinco");
        gd.agregarArco(3,8,"tresocho");
        gd.agregarArco(3,4,"trescuatro");
        gd.agregarArco(8,5,"ochocinco");
        Conexion_PC conexion = new Conexion_PC(gd);
        //conexion.camino_a_pc_destino(1,5,2);
        System.out.println(conexion.camino_a_pc_destino(1,5,2));
    }
}
