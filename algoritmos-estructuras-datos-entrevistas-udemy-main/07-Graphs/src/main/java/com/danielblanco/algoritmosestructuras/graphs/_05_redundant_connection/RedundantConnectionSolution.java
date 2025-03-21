package com.danielblanco.algoritmosestructuras.graphs._05_redundant_connection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Dado un grafo formado tras añadir una arista entre dos nodos de un árbol, devuelve
 * la arista que puede ser eliminada para volver a formar un árbol.
 *
 * En caso de existir múltiples soluciones, devuelve la última arista del input.
 *
 * Ejemplo 1:
 *  Input: [[1,2],[1,3],[2,3]]
 *  Output: [2,3]
 *
 * Ejemplo 2:
 *  Input: [[1,2],[2,3],[3,4],[1,4],[1,5]]
 *  Output: [1,4]
 */
public class RedundantConnectionSolution { // O(n^2)
  private static final int MAX_NODE_VALUE = 1000; // valor máximo de nodos

  public int[] findRedundantConnection(int[][] edges) { // O(n^2)
    List<Set<Integer>> adjList = new ArrayList<>(); // creamos una lista de conjuntos para almacenar las aristas
    for (int i = 0; i < MAX_NODE_VALUE; i++) // recorremos el valor máximo de nodos
      adjList.add(new HashSet<>()); // añadimos un conjunto vacío a la lista

    for (int[] edge : edges) { // recorremos las aristas
      int first = edge[0]; // nodo origen
      int second = edge[1]; // nodo destino
      if (dfs(first, second, -1, adjList)) { // si existe un camino entre los nodos
        return edge; // devolvemos la arista
      } else {
        adjList.get(first).add(second); // añadimos el nodo destino al conjunto del nodo origen
        adjList.get(second).add(first); // añadimos el nodo origen al conjunto del nodo destino
      }
    }
    return null; // si no existe arista redundante
  }

  private boolean dfs(int first, int second, int previous, List<Set<Integer>> adjList) { // O(n)
    if (first == second) // si los nodos son iguales
      return true; // devolvemos verdadero
    for (int w : adjList.get(first)) { // recorremos los nodos adyacentes al nodo origen
      if (w == previous) // si el nodo adyacente es igual al nodo anterior
        continue; // continuamos con el siguiente nodo
      if (dfs(w, second, first, adjList)) // si existe un camino entre los nodos
        return true; // devolvemos verdadero
    }
    return false; // si no existe camino entre los nodos devolvemos falso
  }
}
