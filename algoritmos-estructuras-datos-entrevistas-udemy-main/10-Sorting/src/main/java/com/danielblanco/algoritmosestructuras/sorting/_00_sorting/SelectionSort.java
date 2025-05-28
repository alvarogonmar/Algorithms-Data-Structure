package com.danielblanco.algoritmosestructuras.sorting._00_sorting;

public class SelectionSort { // Algoritmo de ordenación por selección
  static void sort(int[] array) { // Método para ordenar el array

    for (int i = 0; i < array.length - 1; i++) { // Recorremos el array hasta el penúltimo elemento
      // En cada iteración seleccionamos el mínimo y lo movemos al inicio de la parte
      // desordenada
      // del array.
      int minIndex = findMinimumElementIndex(array, i); // Encontramos el índice del elemento mínimo a partir de la
                                                        // posición i
      SearchUtils.swap(array, i, minIndex); // Intercambiamos el elemento actual con el mínimo encontrado
    }
  }

  private static int findMinimumElementIndex(int[] array, int start) { // Método para encontrar el índice del elemento
                                                                       // mínimo en el array a partir de la posición
                                                                       // start
    int minIndex = start;
    for (int i = start + 1; i < array.length; i++) {
      if (array[i] < array[minIndex])
        minIndex = i;
    }

    return minIndex;
  }
}
