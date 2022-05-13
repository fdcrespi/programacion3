package practico3.ejercicio2;

import practico3.ejercicio1.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DFS {
    private Grafo<?> grafo;
    private HashMap<Integer, String> colores;
    private int tiempo;
    private HashMap<Integer, Integer> tiempos;
    private HashMap<Integer, Integer> tiempos_fin;

    public DFS(Grafo<?> grafo){
        this.grafo = grafo;
    }

    public void recorridoDFS(){
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while (vertices.hasNext()){
            int verticeId = vertices.next();
            this.colores.put(verticeId, "BLANCO");
        }
        tiempo = 0;
        while (vertices.hasNext()){
            int v = vertices.next();
            if (colores.get(v).equals("BLANCO")){
                DFS_VISIT(v);
            }
        }
    }

    private void DFS_VISIT(int v) {
        colores.replace(v, "AMARILLO");
        tiempos.put(v, ++tiempo);
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(v);
        while (adyacentes.hasNext()){
            int u = adyacentes.next();
            if (colores.get(u).equals("BLANCO")){
                DFS_VISIT(u);
            }
        }
        colores.replace(v, "NEGRO");
        tiempos_fin.put(v, ++tiempo);
    }
}
