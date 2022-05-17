package practico3.ejercicio4;

import practico3.ejercicio1.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class CaminoSimple {

    private GrafoDirigido<Integer> grafo;

    public CaminoSimple(GrafoDirigido<Integer> grafo){
        this.grafo = grafo;
    }



    public ArrayList<Integer> caminoSimple(int origen, int destino){
        ArrayList<Integer> caminoMayor = new ArrayList<>();
        ArrayList<Integer> camino = new ArrayList<>();
        if (origen == destino) {
            caminoMayor.add(origen);
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()){
                int ady = adyacentes.next();
                camino.addAll(caminoSimple(ady, destino));
                if (!camino.isEmpty()){
                    camino.add(0,origen);
                }
                if (camino.size() > caminoMayor.size()){
                    caminoMayor.clear();
                    caminoMayor.addAll(camino);
                }
                camino.clear();
            }
        }
        return caminoMayor;
    }
}
