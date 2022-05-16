package practico3.ejercicio5;

import practico3.ejercicio1.GrafoDirigido;

public class main {
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
        CaminoA ca = new CaminoA(gd);
        System.out.println(ca.caminoQueTerminanEn(5));
    }
}
