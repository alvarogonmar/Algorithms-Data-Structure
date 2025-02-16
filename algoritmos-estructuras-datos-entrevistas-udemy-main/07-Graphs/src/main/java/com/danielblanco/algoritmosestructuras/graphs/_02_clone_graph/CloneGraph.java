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

  }
}
