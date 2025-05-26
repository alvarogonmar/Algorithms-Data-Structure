package com.danielblanco.algoritmosestructuras.sorting._00_sorting;

public class SearchUtils { // Clase de utilidades para búsquedas y ordenación
  static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
