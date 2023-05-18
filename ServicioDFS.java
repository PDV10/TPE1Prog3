package tp3;

import java.util.*;


public class ServicioDFS<T>{
	private Map<Integer,String> vertices;
	private Grafo<T> grafo;

	public ServicioDFS(Grafo<T> grafo) {
		this.grafo = grafo;
		this.vertices = new HashMap<Integer, String>();
	}

	public List<Integer> dfsForest() {
		Iterator<Integer> verticesAux = this.grafo.obtenerVertices();
		ArrayList<Integer> listaVertices = new ArrayList<Integer>();
		int tiempo = 0;
		//TOMAMOS LOS VERTICES UTILIZADOS EN EL GRAFO Y LOS INICIALIZAMOS EN BLANCO
		while(verticesAux.hasNext()){
			this.vertices.put(verticesAux.next(), "blanco");
		}
		//RECORREMOS TODOS LOS VERTICES ANTERIORMENTE CARGADOS
		for (int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i) == "blanco"){
				listaVertices.addAll(this.dfsForest_visit(i));
			}
		}
		return listaVertices;
	}

	private List<Integer> dfsForest_visit(int vertice){
		ArrayList<Integer> listaVertices = new ArrayList<Integer>();
		
		this.vertices.put(vertice, "Amarillo");

		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
		while (adyacentes.hasNext()){
			int auxVertice = adyacentes.next();
			String aux = this.vertices.get(auxVertice);

			if(aux.equals("blanco")){
				dfsForest_visit(auxVertice);
			}

		}
		this.vertices.put(vertice, "Negro");

		return listaVertices;
	}
}
