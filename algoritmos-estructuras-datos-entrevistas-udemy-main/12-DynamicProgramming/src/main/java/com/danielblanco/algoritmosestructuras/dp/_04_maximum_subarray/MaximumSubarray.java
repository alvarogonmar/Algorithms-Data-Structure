package com.danielblanco.algoritmosestructuras.dp._04_maximum_subarray;

/*
 * Dado un array de enteros, encuentra el subarray con la mayor suma y devuelve dicha suma.
 *
 * Ejemplo 1:
 *  Input:
 *    [-2,1,-3,4,-1,2,1,-5,4]
 *  Output:
 *    6 (subarray [4,-1,2,1])
 *
 * Ejemplo 2:
 *  Input:
 *    [5,4,-1,7,8]
 *  Output:
 *    23 (subarray [5,4,-1,7,8], es decir, el array entero)
 *
 */
public class MaximumSubarray { // Clase que representa el problema de encontrar el subarray con la mayor suma

  public int maxSubArray(int[] nums) { // Método que encuentra el subarray con la mayor suma
    if (nums == null || nums.length == 0) // Verifica si el array es nulo o vacío
      return 0;

    int maxSum = nums[0]; // Inicializa la suma máxima con el primer elemento del array
    int currentSum = nums[0]; // Inicializa la suma actual con el primer elemento del array
    for (int i = 1; i < nums.length; i++) { // Itera desde el segundo elemento hasta el final del array
      if (currentSum < 0) // Si la suma actual es negativa, reinicia la suma actual al valor del elemento
                          // actual
        currentSum = 0; // Reinicia la suma actual si es negativa

      currentSum += nums[i];
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }
}
