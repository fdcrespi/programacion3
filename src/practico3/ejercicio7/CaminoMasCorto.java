package practico3.ejercicio7;

import practico3.ejercicio1.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class CaminoMasCorto {
    private GrafoDirigido<Integer> grafo;

    private ArrayList<Integer> visitados;
    private ArrayList<Integer> caminoMenor;

    public CaminoMasCorto(GrafoDirigido<Integer> g){
        this.grafo = g;
        this.visitados = new ArrayList<>();
        this.caminoMenor = new ArrayList<>();
    }

    /*
    Ejercicio 7.
    Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
    es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
    esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
    cantidad de cuadras posible.
    */

    public ArrayList<Integer> caminoMasCorto (int desde, int hasta){
        this.visitados.clear();
        this.caminoMenor.clear();
        ArrayList<Integer> caminoParcial = new ArrayList<>();
        this.visitados.add(desde);
        caminoParcial.add(desde);
        caminoCorto(desde,hasta,caminoParcial);
        return caminoMenor;
    }

    private void caminoCorto(int origen, int destino, ArrayList<Integer> caminoParcial){
        if (origen == destino) {
            if(caminoMenor.isEmpty()){
                caminoMenor.addAll(caminoParcial);
            } else {
                if (caminoParcial.size() <= caminoMenor.size()) {
                    caminoMenor.clear();
                    caminoMenor.addAll(caminoParcial);
                }
            }
        } else {
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()){
                int ady = adyacentes.next();
                if (!visitados.contains(ady)) {
                    this.visitados.add(ady);
                    caminoParcial.add(ady);
                    caminoCorto(ady, destino, caminoParcial);
                    this.visitados.remove((Integer) ady);
                    caminoParcial.remove((Integer) ady);
                }
            }
        }
    }
}
