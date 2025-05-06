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
public class MaximumDepthSolution { // Clase principal que calcula la profundidad máxima de un árbol binario
  public int maxDepth(Node root) { // Función principal que calcula la profundidad máxima
    if (root == null) { // Si el árbol está vacío
      return 0; // Devolver 0

    int depthLeft = maxDepth(root.left) + 1;
    int depthRight = maxDepth(root.right) + 1;

    return Math.max(depthLeft, depthRight);
  }
}
