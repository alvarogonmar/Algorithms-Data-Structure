package com.danielblanco.algoritmosestructuras.searching._00_binary_search;

public class BinarySearchIterative { // Algoritmo de búsqueda binaria iterativa

  int binarySearch(int[] array, int target) { // Método para buscar un elemento en un array ordenado
    int left = 0; // Índice izquierdo
    int right = array.length - 1; // Índice derecho

    while (left <= right) { // Mientras el índice izquierdo sea menor o igual al derecho
      int mid = left + ((right - left) / 2); // Calcula el índice medio para evitar desbordamiento

      if (array[mid] == target) // Si el elemento en el índice medio es igual al objetivo
        return mid; // Devuelve el índice medio

      if (array[mid] < target) { // Si el elemento en el índice medio es menor que el objetivo
        left = mid + 1; // Mueve el índice izquierdo a la derecha del medio
      } else { // Si el elemento en el índice medio es mayor que el objetivo
        right = mid - 1; // Mueve el índice derecho a la izquierda del medio
      }
    }

    return -1;
  }
}
