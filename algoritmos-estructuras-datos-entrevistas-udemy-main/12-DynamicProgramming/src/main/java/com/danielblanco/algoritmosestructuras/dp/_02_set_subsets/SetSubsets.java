package com.danielblanco.algoritmosestructuras.dp._02_set_subsets;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementa un método para devolver todos los subconjuntos de un conjunto de enteros
 * Ejemplo:
 *  Input: [1,2,3]
 *
 *  Output:
 *    [
 *      [1,2,3],
 *      [1,2],
 *      [1,3],
 *      [2,3],
 *      [1],
 *      [2],
 *      [3],
 *      []
 *    ]
 */
public class SetSubsets {

  List<List<Integer>> subsets(List<Integer> set) {
    List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    subsets.add(new ArrayList<Integer>()); // The '0' subset

    for (Integer element : set) {
      duplicateSubsetsAddingElement(element, subsets);
    }

    return subsets;
  }


  }
}
