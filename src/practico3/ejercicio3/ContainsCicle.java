package practico3.ejercicio3;

import practico3.ejercicio1.Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class ContainsCicle {
    private Grafo<?> grafo;
    private HashMap<Integer, String> colores;

    public ContainsCicle(Grafo<?> grafo){
        this.grafo = grafo;
    }

    public boolean contieneCiclo(){
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while (vertices.hasNext()){
            int verticeId = vertices.next();
            this.colores.put(verticeId, "BLANCO");
        }
        while (vertices.hasNext()){
            int v = vertices.next();
            if (colores.get(v).equals("BLANCO")){
               return DFS_VISIT(v);
            }
        }
        return false;
    }

    private boolean DFS_VISIT(int v) {
        colores.replace(v, "AMARILLO");
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(v);
        while (adyacentes.hasNext()){
            int u = adyacentes.next();
            if (colores.get(u).equals("BLANCO")){
                if (DFS_VISIT(u)) return true;
            } else {
                if (colores.get(u).equals("AMARILLO")){
                    return true;
                }
            }
        }
        return false;
    }
}
