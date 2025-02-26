package com.danielblanco.algoritmosestructuras.graphs._05_redundant_connection;

import java.util.List;

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
public class RedundantConnection {

  public int[] findRedundantConnection(int[][] edges) {
    List<Set<Integer>> adjList = new ArrayList<>(); // creamos una lista de conjuntos para almacenar las aristas,
                                                    // representa si hay una conexion entre dos nodos
    for (int i = 0; i < 1000; i++) { // recorremos el valor máximo de nodos
      adjList.add(new HashSet<>()); // añadimos un conjunto vacío a la lista
    }

    for (Int[] edge : edges) { // recorrer las aristas
      int first = edge[0]; // nodo origen
      int second = edge[1]; // nodo destino
      if (dfs(first, second, adjList)) { // si existe un camino entre los nodos
        return edge; // devolvemos la arista
      }
    }
  }
}
