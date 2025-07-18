package com.danielblanco.algoritmosestructuras.sorting._00_sorting;

public class SearchUtils { // Clase de utilidades para búsquedas y ordenación
  static void swap(int[] array, int i, int j) { // Método para intercambiar dos elementos en un array
    int tmp = array[i]; // Almacenamos el elemento en la posición i
    array[i] = array[j]; // Asignamos el elemento en la posición j a la posición i
    array[j] = tmp; // Asignamos el elemento temporal a la posición j
  }
}
