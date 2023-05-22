package tp3;

import java.util.*;


public class ServicioCaminos<T> {

	private ArrayList<Arco> arcosVisitados;
	private List<List<Integer>> caminos;
	private Grafo<T> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<T> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.caminos = new ArrayList<>();
	}


	public List<List<Integer>> caminos() {
		ArrayList<Integer> camino_parcial = new ArrayList<>();
		camino_parcial.add(this.origen);
		lista_Caminos(camino_parcial, this.origen);
		return this.caminos;
	}
//OBTENEMOS LOS ARCOS DEL ORIGEN
//OBTENEMOS LOS VERTICES DE DESTINO DE LOS ARCOS
//
	private void lista_Caminos(ArrayList<Integer> camino_parcial, int vertice){
		Iterator<Arco<T>> arcos = this.grafo.obtenerArcos(vertice);
		while(arcos.hasNext()) {
			Arco<T> arco = arcos.next();
			int verticeAux = arco.getVerticeDestino();
			if(!this.arcosVisitados.contains(arco)){
				this.arcosVisitados.add(arco);
				camino_parcial.add(verticeAux);
			}

			if (esSolucion(camino_parcial) && camino_parcial.size() <= this.lim) {
				this.caminos.add(camino_parcial);
			}else{
				lista_Caminos(camino_parcial,verticeAux);
			}

		}
	}

	private boolean esSolucion(ArrayList<Integer> lista){
		return lista.get(lista.size()-1) == this.destino;
	}
}
