package com.danielblanco.algoritmosestructuras.trees._04_validate_bst;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Determina si un árbol binario es un árbol binario de búsqueda válido:
 *  - El subárbol izquierdo de un nodo contiene solamente nodos <= que él.
 *  - El subárbol derecho de un nodo contiene solamente nodos > que él.
 *  - Ambos subárboles deben ser a su vez árboles binarios de búsqueda.
 *
 * Ejemplo 1:
 *  Input:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *  Output: false
 *
 * Ejemplo 2:
 *  Input:
 *         4
 *      2     7
 *    1   3  5
 *
 *  Output: true
 */
public class ValidateBSTSolution { // Clase principal que valida si un árbol binario es un árbol binario de
                                   // búsqueda
  public boolean isValidBST(Node root) { // función principal que valida si un árbol binario es un árbol binario de
                                         // búsqueda
    return isValidBST(root, null, null); // llamamos a la función con el máximo y mínimo
  }

  public boolean isValidBST(Node root, Integer min, Integer max) { // función con el máximo y mínimo
    if (root == null) // si el nodo es nulo, retornamos true
      return true; // si el nodo es nulo, retornamos true
    if ((min != null && root.value <= min) || (max != null && root.value >= max)) // si el valor del nodo es menor o
      return false;

    return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
  }
}
