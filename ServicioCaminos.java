package tp3;

import java.util.ArrayList;
import java.util.List;


public class ServicioCaminos<T> {

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
	}

	public List<List<Integer>> caminos() {
		// Resolver Caminos
		return new ArrayList<>();
	}

}
