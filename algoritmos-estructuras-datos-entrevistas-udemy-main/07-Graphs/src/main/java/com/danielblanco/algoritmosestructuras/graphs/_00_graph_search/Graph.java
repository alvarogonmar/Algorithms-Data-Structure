package com.danielblanco.algoritmosestructuras.graphs._00_graph_search;

import java.util.HashMap;

public class Graph { // Clase para representar un grafo
  public HashMap<String, GraphNode> nodes; // HashMap para almacenar los nodos del grafo

  public Graph() {
    nodes = new HashMap<String, GraphNode>(); // Crear un nuevo HashMap
  }

  public GraphNode getOrCreateNode(String name) { // Método para obtener un nodo o crearlo si no existe
    GraphNode node = nodes.get(name); // Obtener el nodo del HashMap
    if (node == null) { // Si el nodo no existe
      node = new GraphNode(name); // Crear un nuevo nodo
      nodes.put(name, node); // Agregar el nodo al HashMap
    }
    return node;
  }

  public void addEdge(String start, String end) {
    GraphNode startNode = getOrCreateNode(start);
    GraphNode endNode = getOrCreateNode(end);
    startNode.addNeighbor(endNode);
  }
}
