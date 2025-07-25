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
public class SetSubsetsSolution { // Clase que representa el problema de encontrar todos los subconjuntos de un
                                  // conjunto de enteros

  List<List<Integer>> subsets(List<Integer> set) { // Método que devuelve todos los subconjuntos de un conjunto de
                                                   // enteros
    List<List<Integer>> subsets = new ArrayList<List<Integer>>(); // Lista para almacenar los subconjuntos encontrados
    subsets.add(new ArrayList<Integer>()); // The '0' subset // Agrega el subconjunto vacío a la lista de subconjuntos

    for (Integer element : set) { // Itera sobre cada elemento del conjunto
      duplicateSubsetsAddingElement(element, subsets); // Duplica los subconjuntos existentes y agrega el elemento
      // actual
    }

    return subsets; // Retorna la lista de subconjuntos encontrados
  }

  private void duplicateSubsetsAddingElement(Integer element, List<List<Integer>> subsets) { // Método que duplica los
    int currentSize = subsets.size(); // subconjuntos existentes y agrega el elemento
                                      // actual
    for (int i = 0; i < currentSize; i++) { // Obtiene el tamaño actual de la lista de subconjuntos
      List<Integer> newSubset = new ArrayList<Integer>(subsets.get(i)); // Crea un nuevo subconjunto a partir del
                                                                        // subconjunto existente
      newSubset.add(element); // Agrega el elemento actual al nuevo subconjunto
      subsets.add(newSubset); // Agrega el nuevo subconjunto a la lista de subconjuntos
    }
  }
}
