package practico3.ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	HashMap<Integer, HashMap<Integer, T>> vertices = new HashMap<>();

	@Override
	public void agregarVertice(int verticeId) {
		// TODO Auto-generated method stub
		// ¿ es necesario controlar si existe o no ?
		if (!vertices.containsKey(verticeId))
			vertices.put(verticeId, new HashMap<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		// TODO Auto-generated method stub
		// Se elimina primero de todos los vertices que hacen referencia a este
		for (int i: vertices.keySet()){
			for (int j: vertices.get(i).keySet()){
				if (j == verticeId) {
					vertices.get(i).remove(verticeId);
				}
			}
		}
		vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// TODO Auto-generated method stub
		if (vertices.containsKey(verticeId1)){
			vertices.get(verticeId1).put(verticeId2, etiqueta);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
	 	if (vertices.containsKey(verticeId1)){
			 vertices.get(verticeId1).remove(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return vertices.containsKey(verticeId1) && vertices.get(verticeId1).containsKey(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		if (existeArco(verticeId1, verticeId2)){
			return new Arco<>(verticeId1, verticeId2, vertices.get(verticeId1).get(verticeId2));
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		int cantidadArcos = 0;
		for (int key: vertices.keySet()){
			cantidadArcos += vertices.get(key).size();
		}
		return cantidadArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		// ¿ esta bien ?
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		// ¿ esta bien ?
		return vertices.get(verticeId).keySet().iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for (int i: vertices.keySet()){
			for (int j: vertices.get(i).keySet()){
				arcos.add(new Arco<>(i, j, vertices.get(i).get(j)));
			}
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		ArrayList<Arco<T>> result = new ArrayList<>();
		for (int key: vertices.get(verticeId).keySet()){
			result.add(new Arco<>(verticeId, key, vertices.get(verticeId).get(key)));
		}
		return result.iterator();
	}

}
