package practico3.ejercicio2;

import practico3.ejercicio1.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BFS {
    private Grafo<?> grafo;
    private HashMap<Integer, Boolean> visitados;
    private ArrayList<Integer> fila = new ArrayList<>();

    public BFS(Grafo<?> grafo){
        this.grafo = grafo;
    }

    public void recorridoBFS() {
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while (vertices.hasNext()){
            int verticeId = vertices.next();
            this.visitados.put(verticeId, false);
        }
        fila.clear();
        while(vertices.hasNext()){
            int v = vertices.next();
            if (!visitados.get(v)){
                BFS_VISIT(v);
            }
        }
    }

    private void BFS_VISIT(int v){
        this.visitados.replace(v, true);
        this.fila.add(v);
        while (!fila.isEmpty()){
            int u = fila.remove(0);
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(v);
            while(adyacentes.hasNext()){
                int h = adyacentes.next();
                if(!this.visitados.get(h)){
                    this.visitados.replace(h, true);
                    this.fila.add(h);
                }
            }
        }
    }
}
