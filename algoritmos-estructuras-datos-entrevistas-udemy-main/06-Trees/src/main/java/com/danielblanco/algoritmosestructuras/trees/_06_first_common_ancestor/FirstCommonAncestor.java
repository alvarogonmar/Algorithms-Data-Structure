package com.danielblanco.algoritmosestructuras.trees._06_first_common_ancestor;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Devuelve el primer ancestro común de dos nodos.
 *
 * Ejemplo:
 *  Input:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *  firstCommonAncestor(1, 7) = 4
 *  firstCommonAncestor(1, 4) = null
 *  firstCommonAncestor(1, 3) = 5
 *
 */
public class FirstCommonAncestor {

  class AncestorNode { // Clase interna para devolver el ancestro común y si se encontró o no
    boolean nodeFound; // Indica si se encontró el nodo
    Node ancestor; // Nodo ancestro común de los dos nodos
  }

  public Node firstCommonAncestor(Node root, Node firstNode, Node secondNode) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
