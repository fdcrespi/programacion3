package practico3.ejercicio6;

import practico3.ejercicio1.GrafoDirigido;

import java.util.ArrayList;
import java.util.Iterator;

public class Conexion_PC {
    private GrafoDirigido<?> G;

    private ArrayList<Integer> visitados;
    private ArrayList<Integer> camino;
    private Integer pcOmitir;

    public Conexion_PC(GrafoDirigido<?> grafo) {
        this.G = grafo;
        this.visitados = new ArrayList<>();
        this.camino = new ArrayList<>();
    }

    /**
     * Ejercicio 6.
     * Supongamos una conexión entre computadoras (1, ... ,n) que se encuentra modelada
     * mediante un grafo. Se requiere, si existe, dar una conexión entre dos computadoras a y b
     * existentes sabiendo que la computadora i está fuera de servicio.
     * */
    public ArrayList<Integer> camino_a_pc_destino(Integer pcOrigen, Integer pcDestino, Integer pcOmitir){
        this.visitados.clear();
        this.camino.clear();
        this.pcOmitir = pcOmitir;
        ArrayList<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(pcOrigen);
        this.visitados.add(pcOrigen);
        this.caminoCorrecto(pcOrigen,pcDestino,caminoParcial);
        return this.camino;
    }

    private void caminoCorrecto(int origen, int destino, ArrayList<Integer> caminoParcial){
        if (origen == destino){
            if (!caminoParcial.contains(pcOmitir)) {
                camino.clear();
                camino.addAll(caminoParcial);
            }
        } else {
            Iterator<Integer> adyacentes = this.G.obtenerAdyacentes(origen);
            while (adyacentes.hasNext() && camino.isEmpty()){
                int ady = adyacentes.next();
                if (!visitados.contains(ady)){
                    caminoParcial.add(ady);
                    this.visitados.add(ady);
                    caminoCorrecto(ady, destino, caminoParcial);
                    caminoParcial.remove((Integer) ady);
                    this.visitados.remove((Integer) ady);
                }
            }
        }

    }
}
