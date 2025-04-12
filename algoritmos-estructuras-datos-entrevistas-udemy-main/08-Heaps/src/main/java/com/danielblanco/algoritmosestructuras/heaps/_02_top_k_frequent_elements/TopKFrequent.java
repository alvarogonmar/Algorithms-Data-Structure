package com.danielblanco.algoritmosestructuras.heaps._02_top_k_frequent_elements;

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
public class TopKFrequent { // TopKFrequent

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(); // Crea un mapa para almacenar los elementos y su frecuencia
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1); // Incrementa el valor de la clave num en 1 si existe, si no, lo
                                                  // inicializa en 0 y le suma 1
    }
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // Recorre el mapa y añade los elementos al heap
      maxHeap.add(entry); // Añade el elemento al heap
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = maxHeap.poll().getKey();
    }
    return result;
  }
}
