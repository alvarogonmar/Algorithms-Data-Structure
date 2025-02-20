package com.danielblanco.algoritmosestructuras.graphs._01_route_between_nodes;

import java.util.LinkedList;
import java.util.Queue;

import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.Graph;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNode;

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
public class RouteBetweenNodes {

  public boolean isRouteBetween(Graph g, GraphNode start, GraphNode end) {
    if (start == end) { // Si los nodos son iguales
      return true; // Caso base retorna true
    }
    Queue<Graph> queue = new LinkedList<>(); // Creamos una cola de nodos
    queue.add(start); // Añadimos el nodo de inicio a la cola

    while (!queue.isEmpty()) { // Mientras la cola no este vacia
      GraphNode next = queue.remove(); // Obtenemos el siguiente nodo

      if (end == next) { // Si el nodo siguiente es igual al nodo final
        return true; // Retornamos true
      }
      for (GraphNode n : next.adjacents.values()) { // Recorremos los nodos adyacentes
        if (!n.status.equals(GraphNodeStatus.Visited)) { // Si el nodo no ha sido visitado
          queue.add(n); // Añadimos el nodo a la cola
          n.status = GraphNodeStatus.Visited; // Marcamos el nodo como visitado
        }
      }
    }
    return false; // Si no se encuentra el nodo final retornamos false
  }
}
