package com.danielblanco.algoritmosestructuras.graphs._00_graph_search;

public class DepthFirstSearch {
  public static boolean depthFirstSearch(Graph graph, String target) { // Funcion que recibe un grafo y un objetivo
    for (GraphNode node : graph.nodes.values()) { // iterar sobre los nodos del grafo
      if (recursiveDfsHelper(node, target)) { // Llamar a la función auxiliar recursiva
        return true; // Si la función auxiliar devuelve verdadero, devolver verdadero
      }
    }

    return false;
  }

  private static boolean recursiveDfsHelper(GraphNode currentNode, String target) {
    if (currentNode.value.equals(target))
      return true; // Si el valor del nodo actual es igual al objetivo, devolver verdadero

    currentNode.status = GraphNodeStatus.Visited;

    for (GraphNode node : currentNode.adjacents.values()) {
      if (node.status != GraphNodeStatus.Visited) {
        if (recursiveDfsHelper(node, target))
          return true;
      }
    }
    return false;
  }
}
