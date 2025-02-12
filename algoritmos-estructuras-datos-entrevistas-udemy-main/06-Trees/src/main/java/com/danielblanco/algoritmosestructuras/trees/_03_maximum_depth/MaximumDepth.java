package com.danielblanco.algoritmosestructuras.trees._03_maximum_depth;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Dada la raíz de un árbol binario, devuelve su profundidad máxima.
 *
 * Ejemplo:
 *  Input:
 *         4
 *      2     7
 *    1   3
 *  8
 *
 *  Output: 4
 */
public class MaximumDepth {

  public int maxDepth(Node root) {
    if (root == null) { // Si el nodo raíz es nulo, devolvemos 0
      return 0; // Devolvemos 0
    } else {
      int leftDepth = maxDepth(root.left) + 1; // Calculamos la profundidad del nodo izquierdo y le sumamos 1 (por el
                                               // nodo raíz)
    }
  }
}
