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
 * O(n + m) donde n es el numero de nodos del arbol first y m es el numero de nodos del arbol second
 */
public class IsSubTree {

  public boolean isSubtree(Node first, Node second) {
    String sb1 = new StringBuilder(); // string builder para el arbol first
    String sb2 = new StringBuilder(); // string builder para el arbol second
  }

  private void preOrder(Node node, StringBuilder sb) { // funcion de recorrido preorder

  }
}
