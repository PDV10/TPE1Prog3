package tp3;

import java.lang.reflect.Array;
import java.util.*;


public class ServicioBFS<T> {

	private Grafo<T> grafo;
	private ArrayList<Integer> fila;
	private Map<Integer,Boolean> vertices;





	public ServicioBFS(Grafo<T> grafo) {
		this.grafo = grafo;
		this.vertices = new HashMap<Integer,Boolean>();
	}
	
	public List<Integer> bfsForest() {
		// obtenemos todos los vertices del grafo
		Iterator<Integer> verticesAux = this.grafo.obtenerVertices();
		fila = new ArrayList<Integer>();

		//TOMAMOS LOS VERTICES UTILIZADOS EN EL GRAFO Y LOS INICIALIZAMOS EN BLANCO
		while(verticesAux.hasNext()){
			this.vertices.put(verticesAux.next(), false);
		}
		// reiniciamos los vertices del grafo
		verticesAux = this.grafo.obtenerVertices();

		//los volvemos a iterrar desde el principio
		while(verticesAux.hasNext()){
			//obtengo el actual y avanzo al siguiente
			int auxVertice = verticesAux.next();
			// si el color del vertice actual es blanco entro al if
			if(vertices.get(auxVertice) == false){
				// agrego a la lista todo lo que retorne
				fila.addAll(this.bfsForest_visit(auxVertice));
			}
		}
		return fila;
	}

	private ArrayList<Integer> bfsForest_visit(int vertice){
		ArrayList<Integer> filaAux = new ArrayList<>();
 		this.vertices.put(vertice, true);
		this.fila.add(vertice);

		while(!filaAux.isEmpty()){
			int valorRetorno = filaAux.remove(0);
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(valorRetorno);

			while(adyacentes.hasNext()){
			int valor = adyacentes.next();
				if(this.vertices.get(valor) == false){
					this.vertices.put(valor, true);
					filaAux.add(valor);
				}
			}
		}



		return filaAux;
	}


	
}
