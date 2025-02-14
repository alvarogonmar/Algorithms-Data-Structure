package com.danielblanco.algoritmosestructuras.graphs._00_graph_search;

import java.util.HashMap;

public class GraphNode { // Clase para representar un nodo de un grafo
  public String value; // Almacena el valor del nodo
  public GraphNodeStatus status; // Almacena el estado del nodo (visitado, no visitado, visitando)
  public HashMap<String, GraphNode> adjacents; // Almacena los nodos adyacentes al nodo actual
  // Utilizas hashMap para almacenar los nodos adyacentes, ya que es más
  // eficiente, con clave el valor del nodo y valor el nodo

  // Constructor
  public GraphNode(String value) {
    this.value = value;
    this.adjacents = new HashMap<String, GraphNode>();
    this.status = GraphNodeStatus.Unvisited;
  }

  // Constructor
  public GraphNode(String value, HashMap<String, GraphNode> adjacents) {
    this.value = value;
    this.adjacents = adjacents;
  }

  // Añade un nodo adyacente al nodo actual
  public void addNeighbor(GraphNode node) {
    if (!adjacents.containsKey(node.value)) { // Si el nodo no está en la lista de adyacentes, lo añadimos
      adjacents.put(node.value, node); // Añadimos el nodo a la lista de adyacentes
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GraphNode other = (GraphNode) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
}
