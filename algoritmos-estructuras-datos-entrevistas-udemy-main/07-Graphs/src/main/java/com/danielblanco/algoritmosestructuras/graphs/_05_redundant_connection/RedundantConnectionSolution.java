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
public class RedundantConnectionSolution {
  private static final int MAX_NODE_VALUE = 1000; // valor máximo de nodos

  public int[] findRedundantConnection(int[][] edges) { // O(n^2)
    List<Set<Integer>> adjList = new ArrayList<>(); // creamos una lista de conjuntos para almacenar las aristas
    for (int i = 0; i < MAX_NODE_VALUE; i++) // recorremos el valor máximo de nodos
      adjList.add(new HashSet<>()); // añadimos un conjunto vacío a la lista

    for (int[] edge : edges) { // recorremos las aristas
      int first = edge[0]; // nodo origen
      int second = edge[1]; // nodo destino
      if (dfs(first, second, -1, adjList)) { // si existe un camino entre los nodos
        return edge;
      } else {
        adjList.get(first).add(second);
        adjList.get(second).add(first);
      }
    }
    return null;
  }

  private boolean dfs(int first, int second, int previous, List<Set<Integer>> adjList) {
    if (first == second)
      return true;
    for (int w : adjList.get(first)) {
      if (w == previous)
        continue;
      if (dfs(w, second, first, adjList))
        return true;
    }
    return false;
  }
}
