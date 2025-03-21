package com.danielblanco.algoritmosestructuras.graphs._04_number_of_provinces;

/*
 * Tenemos N ciudades y queremos calcular el número de provincias existentes.
 * Una provincia la forman todas las ciudades que están conectadas entre sí.
 *
 * Ejemplo:
 *  Input:
 *
 *     a b c
 *   a 1 1 0
 *   b 1 1 0
 *   c 0 0 1
 *
 *  Output: 2
 */
public class NumberOfProvincesSolution { // O(n^2)
  public int numberOfProvinces(int[][] isConnected) { // funcion principal que recibe la matriz de adyacencia
    boolean[] visited = new boolean[isConnected.length]; // creamos un array de booleanos para saber si ya visitamos un
                                                         // nodo
    int count = 0; // contador de provincias
    for (int i = 0; i < isConnected.length; i++) { // recorremos la matriz de adyacencia
      if (!visited[i]) { // si no hemos visitado el nodo
        dfs(isConnected, visited, i); // hacemos un dfs para visitar todos los nodos conectados
        count++; // incrementamos el contador de provincias
      }
    }
    return count;
  }

  private void dfs(int[][] isConnected, boolean[] visited, int city) { // funcion dfs para visitar todos los nodos
    for (int other = 0; other < isConnected.length; other++) { // recorremos la matriz de adyacencia
      if (other != city && isConnected[city][other] == 1 && !visited[other]) { // si el nodo es diferente al nodo actual
                                                                               // y esta conectado y no lo hemos
                                                                               // visitado
        visited[other] = true; // marcamos el nodo como visitado
        dfs(isConnected, visited, other); // hacemos un dfs para visitar los nodos conectados
      }
    }
  }
}
