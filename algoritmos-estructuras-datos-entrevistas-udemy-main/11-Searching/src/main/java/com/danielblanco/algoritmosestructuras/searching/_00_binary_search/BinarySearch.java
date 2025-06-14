package com.danielblanco.algoritmosestructuras.searching._00_binary_search;

public class BinarySearch { // Algoritmo de búsqueda binaria

  int binarySearch(int[] array, int target) { // Método para buscar un elemento en un array ordenado
    return binarySearch(array, 0, array.length - 1, target);// Llama al método recursivo de búsqueda binaria
  }

  private int binarySearch(int[] array, int left, int right, int target) { // Método recursivo para búsqueda binaria
    if (right >= left) { // Si el índice derecho es mayor o igual al izquierdo
      int mid = left + (right - left) / 2; // Calcula el índice medio para evitar desbordamiento

      // Elemento presente en el elemento central del array.
      if (array[mid] == target) // Si el elemento en el índice medio es igual al objetivo
        return mid;

      // Si el elemento es menor que el central, se debe encontrar a su izquierda.
      if (array[mid] > target)
        return binarySearch(array, left, mid - 1, target);

      // En caso contrario solo puede encontrarse en la mitad derecha.
      return binarySearch(array, mid + 1, right, target);
    }

    // El elemento no se ha encontrado.
    return -1;
  }
}
