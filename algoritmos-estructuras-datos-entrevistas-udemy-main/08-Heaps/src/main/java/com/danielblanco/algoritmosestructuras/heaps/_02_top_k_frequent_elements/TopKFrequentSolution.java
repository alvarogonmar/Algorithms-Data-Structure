package com.danielblanco.algoritmosestructuras.heaps._02_top_k_frequent_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Dado un conjunto de elementos y un valor k, devuelve los K elementos más frecuentes.
 * Se pueden devolver en cualquier orden.
 *
 * Ejemplo:
 *  Input:
 *    nums = [1,1,1,2,2,3]
 *    k = 2
 *
 *  Output:
 *    [1,2]
 *
 * Input:
 *    nums = [1,1,2,2,3,3,3]
 *    k = 1
 *
 *  Output:
 *    [3]
 */
public class TopKFrequentSolution { // TopKFrequent
  public int[] topKFrequent(int[] nums, int k) { // topKFrequent
    Map<Integer, Integer> map = new HashMap<>(); // Crea un mapa para almacenar los elementos y su frecuencia
    for (int n : nums) { // Recorre el array y añade los elementos al mapa
      map.put(n, map.getOrDefault(n, 0) + 1); // Incrementa el valor de la clave n en 1 si existe, si no, lo
    }

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue())); // Crea
                                                                                                                       // un
                                                                                                                       // heap
                                                                                                                       // máximo
                                                                                                                       // para
                                                                                                                       // almacenar
                                                                                                                       // los
                                                                                                                       // elementos
                                                                                                                       // y
                                                                                                                       // su
                                                                                                                       // frecuencia
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // Recorre el mapa y añade los elementos al heap
      maxHeap.add(entry); // Añade el elemento al heap
    }

    int[] res = new int[k]; // Crea un array para almacenar los k elementos más frecuentes
    for (int i = 0; i < k; i++) { // Recorre el heap y añade los k elementos más frecuentes al array
      Map.Entry<Integer, Integer> entry = maxHeap.poll();
      res[i] = entry.getKey();
    }

    return res;
  }
}
