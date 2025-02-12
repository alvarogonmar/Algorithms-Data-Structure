package com.danielblanco.algoritmosestructuras.trees._05_is_subtree;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Determina si el árbol second es subárbol del árbol first.
 *
 * Ejemplo 1:
 *  Input:
 *    first:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *    second:
 *         4
 *      2     7
 *    1   3  5
 *
 *  Output: false
 *
 * Ejemplo 2:
 *  Input:
 *    first:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *    second:
 *         5
 *      1     3
 *    8
 *
 * Output: true
 * 
 *  4 - 5 - 1 - 8 - 3 - 7
 * 5 - 1 - 8 - 3 esto esta dentro de 4 - 5 - 1 - 8 - 3 - 7 por lo tanto es un subarbol
 */
public class IsSubTree {

  public boolean isSubtree(Node first, Node second) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
