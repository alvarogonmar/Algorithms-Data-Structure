package com.danielblanco.algoritmosestructuras.graphs._02_clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Devuelve una copia profunda (clon) de un grafo conexo y no dirigido. Puedes
 * utilizar la clase Node que se ve a continuación, más simple que Graph.
 *
 * Ejemplo:
 *  Input: Nodo de grafo conexo y no dirigido (desde él se puede llegar a los demás)
 *  Output: Un clon de ese grafo (nuevos Nodos, no las mismas referencias).
 */
public class CloneGraphSolution { // Cambio de nombre de CloneGraph a CloneGraphSolution
  public class Node { // Clase de un nodo de grafo
    public int val; // Valor del nodo
    public List<Node> neighbors; // Lista de nodos vecinos (cambio de nombre de neighbors a neighbors)
  }

  public Node cloneGraph(Node node) { // Método para clonar un grafo
    Map<Integer, Node> map = new HashMap<>(); // Cambio de nombre de graph a map
    return clone(node, map); // Cambio de nombre de cloneGraph a clone
  }

  private Node clone(Node node, Map<Integer, Node> map) { // funcion clone con parametros node y map
    if (node == null) // si el nodo es null
      return null; // return null si el nodo es null

    if (map.containsKey(node.val)) // si el map contiene la key node.val
      return map.get(node.val); // return el valor de la key node.val

    Node newNode = new Node();// Crear un nuevo nodo
    newNode.val = node.val; // Asignar el valor del nodo
    newNode.neighbors = new ArrayList<Node>(); // Crear una nueva lista de nodos

    map.put(newNode.val, newNode); // Añadir el nuevo nodo al map
    for (Node neighbor : node.neighbors) // Recorrer los nodos vecinos
      newNode.neighbors.add(clone(neighbor, map)); // Añadir el nodo clonado a la lista de nodos vecinos
    return newNode; // return el nuevo nodo
  }
}
