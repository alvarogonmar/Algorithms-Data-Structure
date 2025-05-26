package com.danielblanco.algoritmosestructuras.sorting._00_sorting;

/*
 * Dividimos la lista en dos recursivamente, una parte con los elementos más pequeños que el pivote
 * y la otra mitad con los más grandes.
 *
 * O(n log(n)) tiempo medio y O(n^2) peor caso porque el pivote podría estar lejos de la mediana.
 * Si el pivote seleccionado es siempre el mayor o menor número estaríamos haciando un bubble sort.
 */
public class QuickSort { // Algoritmo de ordenación rápida

  public static void sort(int[] array) { // Método para ordenar el array
    sort(array, 0, array.length - 1); // Llama al método de ordenación
  }

  private static void sort(int[] array, int low, int high) { // Método recursivo para ordenar el array
    if (low < high) {
      // Índice de partition, arr[p] se encuentra ahora en la posición correcta.
      int index = partition(array, low, high); // Llama al método de partición

      // Ordenamos los elementos antes y después de la partición de forma separada.
      sort(array, low, index - 1); // Ordena el lado izquierdo
      sort(array, index + 1, high); // Ordena el lado derecho
    }
  }

  /*
   * Esta función toma el último elemento como pivote, lo coloca en su posición
   * correcta y
   * posiciona los elementos menores que él a su izquierda y los mayores a la
   * derecha.
   */
  private static int partition(int[] array, int low, int high) { // Método de partición
    int pivot = array[high]; // Elegimos el último elemento como pivote

    // Índice del menor elemento. Indica la posición correcta del pivote hasta el
    // momento.
    int i = (low - 1); // Índice del menor elemento

    for (int j = low; j <= high - 1; j++) { // Recorremos el array desde low hasta high - 1
      if (array[j] < pivot) { // Si el elemento actual es menor que el pivote
        // Incrementamos el índice del menor elemento si el actual es menor que el
        // pivote.
        i++; // Incrementamos el índice del menor elemento
        SearchUtils.swap(array, i, j); // Intercambiamos el elemento actual con el elemento en la posición i
      }
    }

    // Movemos el pivote a la posición correcta.
    SearchUtils.swap(array, i + 1, high); // Intercambiamos el pivote con el elemento en la posición i + 1
    return i + 1;
  }
}
