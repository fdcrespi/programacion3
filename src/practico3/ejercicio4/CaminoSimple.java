package practico3.ejercicio4;

import practico3.ejercicio1.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class CaminoSimple {

    private GrafoDirigido<Integer> grafo;

    private ArrayList<Integer> visitados;
    private ArrayList<Integer> caminoMayor;

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

    public ArrayList<Integer> caminoSimpleStatus(int origen, int destino){
        this.visitados.clear();
        this.caminoMayor.clear();

        ArrayList<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen);
        this.visitados.add(origen);
        this.caminoMayor(origen,destino,caminoParcial);
        return this.caminoMayor;
    }

    private void caminoMayor(int origen, int destino, ArrayList<Integer> caminoParcial){
        if (origen == destino) {
            if(caminoParcial.size() >= caminoMayor.size()){
                caminoMayor.clear();
                caminoMayor.addAll(caminoParcial);
            }
        } else {
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()){
                int ady = adyacentes.next();
                if(!visitados.contains(ady)){
                    caminoParcial.add(ady);
                    this.visitados.add(ady);
                    caminoMayor(ady, destino, caminoParcial);
                    caminoParcial.remove(ady);
                    this.visitados.remove(ady);
                }
            }
        }
    }

}
