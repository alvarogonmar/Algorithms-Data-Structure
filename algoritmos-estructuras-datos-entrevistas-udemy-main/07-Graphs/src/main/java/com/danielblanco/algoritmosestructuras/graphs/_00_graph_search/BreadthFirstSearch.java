package com.danielblanco.algoritmosestructuras.graphs._00_graph_search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch { // Aqui si examinan primero los nodos adyacentes al nodo actual antes de pasar
                                  // al siguiente nodo
  public static boolean breadthFirstSearch(Graph graph, String target) { // Funcion que recibe un grafo y un objetivo
    for (GraphNode node : graph.nodes.values()) { // iterar sobre los nodos del grafo
      if (singleBfsHelper(node, target))
        return true; // Llamar a la función auxiliar BFS con el nodo actual
    }

    return false;
  }

  private static boolean singleBfsHelper(GraphNode node, String target) {
    Queue<GraphNode> queue = new LinkedList<GraphNode>(); // Crear una cola para almacenar los nodos
    queue.add(node); // Agregar el nodo actual a la cola

    while (!queue.isEmpty()) { // Mientras la cola no esté vacía
      GraphNode currentNode = queue.remove(); // Obtener el primer nodo de la cola

      if (currentNode.value.equals(target)) // Si el valor del nodo actual es igual al objetivo
        return true; // Devolver verdadero

      currentNode.status = GraphNodeStatus.Visited; // En caso contrario Marcar el nodo actual como visitado

      for (GraphNode adj : currentNode.adjacents.values()) {
        if (adj.status == GraphNodeStatus.Unvisited) {
          queue.add(adj);
        }
      }
    }

    return false;
  }
}
