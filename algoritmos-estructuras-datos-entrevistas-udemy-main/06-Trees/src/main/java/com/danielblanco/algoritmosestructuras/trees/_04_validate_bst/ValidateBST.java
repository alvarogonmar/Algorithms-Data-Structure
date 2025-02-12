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
public class ValidateBST {

  public boolean isValidBST(Node root) {
    return isValidBST(root, null, null); // llamamos a la funcion con el maximo y minimo
  }

  public boolean isValidBST(Node root, Integer min, Integer max) { // funcion con el maximo y minimo
    if (root == null) { // si el nodo es nulo, retornamos true
      return true;
    }
    if ((min != null && root.value <= min) || (max != null && root.value >= max)) { // si el valor del nodo es menor o
                                                                                    // igual al minimo o mayor o igual
                                                                                    // al maximo, retornamos false
      return false;
    }
    return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
    // llamamos a la funcion
    // con el nodo izquierdo y
    // el nodo derecho
    // Por ejemplo con el
    // ejemplo 2, el nodo 2
    // tiene un minimo de 1 y
    // un maximo de 4
    // y el nodo 7 tiene un
    // minimo de 4 y un maximo
    // de 7
    // por lo que el nodo 5
    // tiene un minimo de 4 y
    // un maximo de 7
    // y el nodo 3 tiene un
    // minimo de 1 y un maximo
    // de 2 y el nodo 1 tiene
    // un minimo de 1 y un maximo de 2
  }
}
