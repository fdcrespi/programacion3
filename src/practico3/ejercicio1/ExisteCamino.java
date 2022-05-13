package practico3.ejercicio1;
import java.util.HashMap;
import java.util.Iterator;

public class ExisteCamino {

	private Grafo<?> grafo;
	private HashMap<Integer,String> colores;
	
	public ExisteCamino(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
	}
	
	public boolean existeCamino(int origen, int destino) {
		
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			this.colores.put(verticeId, "blanco");
		}
	
		boolean hayCamino = existeCaminoVisit(origen,destino);		
		return hayCamino;
	}

	private boolean existeCaminoVisit(int origen, int destino) {

		this.colores.put(origen, "amarillo");

		if (origen == destino) {
			return true;
		} else {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
			while (it.hasNext()) {
				int adyacente = it.next();
				if (this.colores.get(adyacente).equals("blanco")) {
					boolean hayCamino = existeCaminoVisit(adyacente,destino);
					if (hayCamino)
						return true;
				}
			}
			
			// colores.put(verticeActual, "negro");
	
			return false;
		}
	}
	
}
