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
public class NumberOfProvinces {

  public int numberOfProvinces(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length]; // Array para marcar las ciudades visitadas
    int provinces = 0; // Contador de provincias
    for (int i = 0; i < isConnected.length; i++) { // for para recorrer las ciudades
      if (!visited[i]) { // Si la ciudad no ha sido visitada
        provinces++; // Incrementamos el contador de provincias
        dfs(isConnected, visited, i); // Llamamos a la función dfs para marcar las ciudades conectadas
      }
    }
    return provinces; // Retornamos el número de provincias
  }

  private void dfs(int[][] isConnected, boolean[] visited, int city) {
    for (int other = 0; other < isConnected[0].length; other++) { // recorrer las ciudades conectadas
      if (other != city && isConnected[city][other] == 1 && !visited[other]) { // si la ciudad está conectada y no ha
                                                                               // sido visitada
        visited[other] = true; // marcar la ciudad como visitada
        dfs(isConnected, visited, other); // llamar a la función dfs para marcar las ciudades conectadas
      }
    }
  }
}
