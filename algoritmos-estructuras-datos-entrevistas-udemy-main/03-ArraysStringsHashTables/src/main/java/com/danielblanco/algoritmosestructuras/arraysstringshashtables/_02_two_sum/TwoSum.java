package com.danielblanco.algoritmosestructuras.arraysstringshashtables._02_two_sum;

import java.util.HashMap;

/*
 * Dado un array de números enteros y un target, retorna los índices de dos
 * números para los que la suma de ambos sea igual al target.
 *
 * Puedes asumir que hay solamente una solución.
 *
 * Ejemplo 1:
 *  Input: nums = [9,2,5,6], target = 7
 *  Output: [1,2]
 *  Explicación: nums[1] + nums[2] == 7, devolvemos [1, 2].
 *
 * Ejemplo 2:
 *  Input: nums = [9,2,5,6], target = 100
 *  Output: null
 * 
 * Si hicieramos un doble for anidado sería O(n^2)
 * 
 * 
 * Hash Table:
 * Almacenar los complementos de los numeros y su indice
 * [-2, 5, 2, 1] O(N)
 * 
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return null;
    } else {
      Map<Integer, Integer> compMap = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {

      }
    }
  }
}
