package practico3.ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	HashMap<Integer, HashMap<Integer, T>> map = new HashMap<>();

	@Override
	public void agregarVertice(int verticeId) {
		// TODO Auto-generated method stub
		// ¿ es necesario controlar si existe o no ?
		map.put(verticeId, new HashMap<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		// TODO Auto-generated method stub
		// Se elimina primero de todos los vertices que hacen referencia a este
		for (int i: map.keySet()){
			for (int j: map.get(i).keySet()){
				if (j == verticeId) {
					map.get(i).remove(verticeId);
				}
			}
		}
		map.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		// TODO Auto-generated method stub
		if (map.containsKey(verticeId1)){
			map.get(verticeId1).put(verticeId2, etiqueta);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
	 	if (map.containsKey(verticeId1)){
			 map.get(verticeId1).remove(verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		// TODO Auto-generated method stub
		return map.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return map.containsKey(verticeId1) && map.get(verticeId1).containsKey(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		if (existeArco(verticeId1, verticeId2)){
			return new Arco<>(verticeId1, verticeId2, map.get(verticeId1).get(verticeId2));
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return map.size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		int cantidadArcos = 0;
		for (int key: map.keySet()){
			cantidadArcos += map.get(key).size();
		}
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		// ¿ esta bien ?
		return map.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		// ¿ esta bien ?
		return map.get(verticeId).keySet().iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for (int i: map.keySet()){
			for (int j: map.get(i).keySet()){
				arcos.add(new Arco<>(i, j, map.get(i).get(j)));
			}
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		ArrayList<Arco<T>> result = new ArrayList<>();
		for (int key: map.get(verticeId).keySet()){
			result.add(new Arco<>(verticeId, key, map.get(verticeId).get(key)));
		}
		return result.iterator();
	}

}
