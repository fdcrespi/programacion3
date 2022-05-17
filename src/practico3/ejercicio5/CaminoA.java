package practico3.ejercicio5;

import practico3.ejercicio1.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class CaminoA {

    private GrafoDirigido<?> G;

    public CaminoA(GrafoDirigido<?> grafo){
        this.G = grafo;
    }

    /**
     * Ejercicio 5.
     * Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
     * con todos los vértices a partir de los cuales exista un camino en G que termine en v.
     * */
    public ArrayList<Integer> caminoQueTerminanEn(Integer v){
        ArrayList<Integer> verticesConCamino = new ArrayList<>();
        Iterator<Integer> vertices = G.obtenerVertices();
        while(vertices.hasNext()){
            int verticeId = vertices.next();
            Integer esInicio = caminoADestino(verticeId, v);
            if (esInicio != null && v != esInicio){
                verticesConCamino.add(caminoADestino(verticeId, v));
            }
        }
        return verticesConCamino;
    }

    public Integer caminoADestino(Integer origen, Integer destino){
        int esorigen;
        ArrayList<Integer> caminoHaciaDestino = new ArrayList<>();
        if (origen == destino){
            return origen;
        } else {
            Iterator<Integer> adyacentes = G.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()){
                int ady = adyacentes.next();
                if (caminoADestino(ady, destino) != null){
                    return origen;
                }
            }
        }
        return null;
    }
}
