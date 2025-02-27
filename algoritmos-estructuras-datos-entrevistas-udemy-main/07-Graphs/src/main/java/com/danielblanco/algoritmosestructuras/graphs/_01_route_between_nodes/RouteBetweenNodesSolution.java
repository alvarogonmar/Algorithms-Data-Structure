package com.danielblanco.algoritmosestructuras.graphs._01_route_between_nodes;

import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.Graph;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNode;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNodeStatus;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Dado un grafo dirigido y dos nodos, determina si hay un camino start-end
 *
 * Ejemplo: (Matriz de adyacencia que hemos visto en la teoría):
 *
 *  	 0 1 2 3 4
 *
 *  0	 0 0 0 0 0
 *  1	 0 0 0 0 0
 *  2	 0 1 0 0 0
 *  3	 0 0 1 0 0
 *  4	 0 1 0 1 0
 *
 * isRouteBetween(2, 4) = false
 * isRouteBetween(3, 1) = true
 * isRouteBetween(0, 1) = false
 * isRouteBetween(0, 0) = true
 */
public class RouteBetweenNodesSolution { // O(n)

  public boolean isRouteBetween(Graph g, GraphNode start, GraphNode end) { //
    if (start == end) // si los nodos son iguales
      return true; // devolvemos verdadero

    Queue<GraphNode> queue = new LinkedList<>(); // creamos una cola
    queue.add(start); // añadimos el nodo de inicio a la cola

    while (!queue.isEmpty()) { // mientras la cola no esté vacía
      GraphNode next = queue.remove(); // sacamos el primer nodo de la cola

      if (end == next) // si el nodo de fin es igual al nodo actual
        return true; // devolvemos verdadero

      for (GraphNode n : next.adjacents.values()) { // recorremos los nodos adyacentes al nodo actual
        if (!n.status.equals(GraphNodeStatus.Visited)) { // si el nodo no ha sido visitado
          queue.add(n); // añadimos el nodo a la cola
          n.status = GraphNodeStatus.Visited; // marcamos el nodo como visitado
        }
      }
    }

    return false; // si no existe camino, devolvemos falso
  }
}
