package com.danielblanco.algoritmosestructuras.sorting._00_sorting;

public class BubbleSort { // Bubble Sort
  static void sort(int[] array) { // método para ordenar el array
    for (int i = 0; i < array.length - 1; i++) { // recorre el array
      for (int j = 0; j < array.length - i - 1; j++) { // recorre el array
        if (array[j] > array[j + 1]) { // si el elemento es mayor que el siguiente
          SearchUtils.swap(array, j, j + 1);
        }
      }
    }
  }
}
