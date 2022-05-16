package practico3.ejercicio4;

import practico3.ejercicio1.GrafoDirigido;

public class Main {

    public static void main(String[] args) {
        GrafoDirigido gd = new GrafoDirigido();
        gd.agregarVertice(1);
        gd.agregarVertice(2);
        gd.agregarVertice(3);
        gd.agregarVertice(4);
        gd.agregarVertice(5);
        gd.agregarArco(1,4,"unocuatro");
        gd.agregarArco(1,2,"unodos");
        gd.agregarArco(2,3,"dostres");
        gd.agregarArco(2,5,"doscinco");
        gd.agregarArco(3,5,"trescinco");
        CaminoSimple cs = new CaminoSimple(gd);
        System.out.println(cs.caminoSimple(1,5));
    }
}
