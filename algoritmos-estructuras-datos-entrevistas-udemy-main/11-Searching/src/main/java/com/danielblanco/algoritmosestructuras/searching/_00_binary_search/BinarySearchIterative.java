package com.danielblanco.algoritmosestructuras.searching._00_binary_search;

public class BinarySearchIterative { // Algoritmo de búsqueda binaria iterativa

  int binarySearch(int[] array, int target) { // Método para buscar un elemento en un array ordenado
    int left = 0; // Índice izquierdo
    int right = array.length - 1; // Índice derecho

    while (left <= right) { // Mientras el índice izquierdo sea menor o igual al derecho
      int mid = left + ((right - left) / 2);

      if (array[mid] == target)
        return mid;

      if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
}
