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
      if (dfs(first, second, -1, adjList)) { // si existe un camino entre los nodos
        return edge; // devolvemos la arista
      } else {
        adjList.get(first).add(second); // añadimos el nodo destino al conjunto del nodo origen
        adjList.get(second).add(first); // añadimos el nodo origen al conjunto del nodo destino
      }
      return null;
    }
  }

  private boolean dfs(int first, int second, int previous, List<Set<Integer>> adjList) {
    if (first == second) { // si los nodos son iguales
      return true; // devolvemos true
    } else {
      for (int other : adjList.get(first)) { // recorremos los nodos adyacentes al nodo origen
        if (other == previous) { // si el nodo adyacente es igual al nodo anterior
          continue; // continuamos con la siguiente iteración

        }
        if (dfs(other, second, first, adjList)) { // si existe un camino entre el nodo adyacente y el nodo destino
          return true; // devolvemos true
        }
      }
      return false; // si no existe camino, devolvemos false
    }
  }
}
