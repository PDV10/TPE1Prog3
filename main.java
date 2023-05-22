package tp3;

import java.util.ArrayList;
import java.util.Iterator;

public class main {
	public static <T> void main(String[] args) {
		GrafoDirigido<T> grafo = new GrafoDirigido<>();

		grafo.agregarVertice(0);
		grafo.agregarVertice(5);
		grafo.agregarVertice(1);
		grafo.agregarVertice(4);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);

		grafo.agregarArco(0,5,null);
		grafo.agregarArco(0,1,null);
		grafo.agregarArco(5,4,null);
		grafo.agregarArco(5,3,null);
		grafo.agregarArco(1,2,null);
		grafo.agregarArco(1,4,null);
		grafo.agregarArco(2,3,null);
//		grafo.agregarArco(3,1,null);
//		grafo.agregarArco(3,0,null);
		grafo.agregarArco(4,3,null);

//		ServicioDFS<T> service = new ServicioDFS<>(grafo);
//		System.out.println(service.dfsForest());

//		ServicioBFS<T> serviceBFS = new ServicioBFS<>(grafo);
//		System.out.println(serviceBFS.bfsForest());
		
		ServicioCaminos<T> caminos = new ServicioCaminos<>(grafo,0,3,2);
		System.out.println(caminos.caminos());

//		System.out.println( grafo.existeArco(0, 10));


//		System.out.println(grafo.obtenerArco(0, 10));
//		System.out.println( grafo.existeArco(0, 10));
//		System.out.println( grafo.existeArco(0, 11));
//		System.out.println( grafo.existeArco(12, 13));
//		System.out.println( grafo.existeArco(12, 14));
//		System.out.println(grafo.cantidadVertices());
//		System.out.println(grafo.cantidadArcos());
//		grafo.borrarArco(0, 10);
//		System.out.println(grafo.cantidadArcos());
//		
//		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(12);
//		while(adyacentes.hasNext()) {
//			System.out.println(adyacentes.next());
//		}

//		Iterator<Integer> vertices = grafo.obtenerVertices();
//		while(vertices.hasNext()) {
//			System.out.println(vertices.next());
//		}

//		Iterator<Arco<T>> arcos = grafo.obtenerArcos();
//		Iterator<Arco<T>> arcosDeVertice = grafo.obtenerArcos(0);
//		
	}
}
