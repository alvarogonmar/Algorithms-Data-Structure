package com.danielblanco.algoritmosestructuras.graphs._00_graph_search;

import java.util.HashMap;

public class GraphNode { // Clase para representar un nodo de un grafo
  public String value; // Almacena el valor del nodo
  public GraphNodeStatus status; // Almacena el estado del nodo (visitado, no visitado, visitando)
  public HashMap<String, GraphNode> adjacents; // Almacena los nodos adyacentes al nodo actual
  // Utilizas hashMap para almacenar los nodos adyacentes, ya que es más
  // eficiente, con clave el valor del nodo y valor el nodo

  // Constructor
  public GraphNode(String value) { // Constructor que inicializa el nodo con un valor
    this.value = value; // Asigna el valor al nodo
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

  @Override // Método hashCode para calcular el código hash del nodo
  public int hashCode() { // Se utiliza para comparar nodos
    final int prime = 31; // Número primo para calcular el código hash
    int result = 1; // Inicializa el resultado
    result = prime * result + ((value == null) ? 0 : value.hashCode()); // Calcula el código hash del valor del nodo
    return result; // Retorna el código hash
  }

  @Override // Método equals para comparar dos nodos
  public boolean equals(Object obj) { // Se utiliza para comparar nodos
    if (this == obj) // Si son el mismo objeto, retorna verdadero
      return true; // Retorna verdadero
    if (obj == null) // Si el objeto es nulo, retorna falso
      return false; // Retorna falso
    if (getClass() != obj.getClass()) // Si el objeto no es de la misma clase, retorna falso
      return false; // Retorna falso
    GraphNode other = (GraphNode) obj; // Convierte el objeto a un nodo
    if (value == null) { // Si el valor del nodo es nulo
      if (other.value != null) // Si el valor del otro nodo no es nulo, retorna falso
        return false; // Retorna falso
    } else if (!value.equals(other.value)) // Si el valor del nodo es diferente al del otro nodo, retorna falso
      return false; // Retorna falso
    return true; // Retorna verdadero si los nodos son iguales
  }
}
