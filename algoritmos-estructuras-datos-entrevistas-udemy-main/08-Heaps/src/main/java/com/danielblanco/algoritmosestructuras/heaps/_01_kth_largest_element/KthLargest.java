package com.danielblanco.algoritmosestructuras.heaps._01_kth_largest_element;

import java.util.PriorityQueue;

/*
 * Diseña una clase para obtener el kth elemento más grande de un stream de datos.
 *
 * KthLargest(int k, int[] nums) Inicializa el objecto con el valor de K y con el conjunto de datos.
 * int add(int val) Añade un nuevo elemento y devuelve el kth mayor actual.
 *
 * Ejemplo:
 *  Input:
 *    k = 4
 *    nums = [1, 2, 3, 4, 5]
 *
 *  Output:
 *    add(6) = 3
 *    add(1) = 3
 *    add(8) = 4
 */
public class KthLargest {

  private int k;
  private PriorityQueue<Integer> heap;

  public KthLargest(int k, int[] nums) {
    this.k = k; // kth elemento más grande
    heap = new PriorityQueue<>();

    for (int num : nums) {
      heap.add(num);
    }

    while (heap.size() > k) {
      heap.poll();
    }
  }

  public int add(int val) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
