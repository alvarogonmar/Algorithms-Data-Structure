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

  private int k; // kth elemento más grande
  private PriorityQueue<Integer> heap; // MinHeap

  public KthLargest(int k, int[] nums) { // Constructor
    this.k = k; // kth elemento más grande
    heap = new PriorityQueue<>(); // MinHeap

    for (int num : nums) { // Añade los elementos al heap
      heap.add(num); // Añade el elemento al heap
    }

    while (heap.size() > k) { // Mantiene el tamaño del heap
      heap.poll(); // Elimina el elemento más pequeño
    }
  }

  public int add(int val) { // Añade un nuevo elemento
    heap.add(val);
    if (heap.size() > k) {
      heap.poll();
    }
    return heap.peek();
  }
}
