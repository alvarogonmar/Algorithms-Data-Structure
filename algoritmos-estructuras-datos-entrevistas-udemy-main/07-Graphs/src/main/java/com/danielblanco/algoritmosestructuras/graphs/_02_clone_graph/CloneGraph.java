package com.danielblanco.algoritmosestructuras.graphs._02_clone_graph;

import java.util.HashMap;
import java.util.List;

/*
 * Devuelve una copia profunda (clon) de un grafo conexo y no dirigido. Puedes
 * utilizar la clase Node que se ve a continuación, más simple que Graph.
 *
 * Ejemplo:
 *  Input: Nodo de grafo conexo y no dirigido (desde él se puede llegar a los demás)
 *  Output: Un clon de ese grafo (nuevos Nodos, no las mismas referencias).
 */
public class CloneGraph {

  public class Node { // Clase de un nodo de grafo
    public int val; // Valor del nodo
    public List<Node> neighbors; // Lista de nodos vecinos
  }

  public Node cloneGraph(Node node) { // Método para clonar un grafo
    HashMap<Integer, Node> map = new HashMap<>(); // Crear un nuevo HashMap
  }

  private Node clone(Node node, HashMap<Integer, Node> map) { // funcion para clonar un nodo
    if (node == null)
      return null; // si el nodo es null, return null

    if (map.containsKey(node.val)) // si el map contiene la key node.val
      return map.get(node.val); // return el valor de la key node.val

    Node newNode = new Node(); // Crear un nuevo nodo
    newNode.val = node.val; // Asignar el valor del nodo
    newNode.neighbors = new ArrayList<>(); // Crear una nueva lista de nodos

    for (Node n : node.neighbors) // Recorrer los nodos vecinos
      newNode.neighbors.add(clone(n, map)); // Añadir el nodo clonado a la lista de nodos vecinos

    return newNode; // return el nuevo nodo
  }
}
