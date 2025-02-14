package com.danielblanco.algoritmosestructuras.graphs._00_graph_search;

import java.util.HashMap;

public class Graph { // Clase para representar un grafo
  public HashMap<String, GraphNode> nodes; // HashMap para almacenar los nodos del grafo

  public Graph() {
    nodes = new HashMap<String, GraphNode>(); // Crear un nuevo HashMap
  }

  public GraphNode getOrCreateNode(String name) {
    GraphNode node = nodes.get(name);
    if (node == null) {
      node = new GraphNode(name);
      nodes.put(name, node);
    }
    return node;
  }

  public void addEdge(String start, String end) {
    GraphNode startNode = getOrCreateNode(start);
    GraphNode endNode = getOrCreateNode(end);
    startNode.addNeighbor(endNode);
  }
}
