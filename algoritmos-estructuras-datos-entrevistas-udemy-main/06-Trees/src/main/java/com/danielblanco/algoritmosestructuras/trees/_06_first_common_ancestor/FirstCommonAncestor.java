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
    return postOrderSearch(root, firstNode, secondNode).ancestor; // Buscamos el ancestro común de los dos nodos
  }

  private AncestorNode postOrderSearch(Node root, Node firstNode, Node secondNode) { // Recorrido postorden, es decir
                                                                                     // primero los hijos y luego el
                                                                                     // nodo
    if (root == null) { // Si el nodo es nulo, devolvemos un nodo ancestro nulo
      return new AncestorNode(); // Devolvemos un nodo ancestro nulo
    }
    AncestorNode leftResult = postOrderSearch(root.left, firstNode, secondNode); // Buscamos en el hijo izquierdo
    if (leftResult.ancestor != null) { // Si encontramos el ancestro en el hijo izquierdo, lo devolvemos
      return leftResult;
    }
    AncestorNode rightResult = postOrderSearch(root.right, firstNode, secondNode); // Buscamos en el hijo derecho
    if (rightResult.ancestor != null) { // Si encontramos el ancestro en el hijo derecho, lo devolvemos
      return rightResult;
    }

    AncestorNode result = new AncestorNode(); // Creamos un nodo ancestro nulo para devolver en caso de no encontrar
                                              // el ancestro

    if (leftResult.nodeFound && rightResult.nodeFound) { // Si encontramos ambos nodos en los hijos, el ancestro es el
                                                         // nodo actual
      result.ancestor = root; // El ancestro es el nodo actual
      return result; // Devolvemos el ancestro
    }

    result.nodeFound = leftResult.nodeFound || rightResult.nodeFound || root == firstNode || root == secondNode; // Si
                                                                                                                 // encontramos
                                                                                                                 // alguno
                                                                                                                 // de
                                                                                                                 // los
                                                                                                                 // nodos
                                                                                                                 // en
                                                                                                                 // el
                                                                                                                 // hijo
                                                                                                                 // izquierdo,
                                                                                                                 // derecho
                                                                                                                 // o el
                                                                                                                 // nodo
                                                                                                                 // actual,
                                                                                                                 // marcamos
                                                                                                                 // el
                                                                                                                 // nodo
                                                                                                                 // como
                                                                                                                 // encontrado
    return result; // Devolvemos el nodo ancestro
  }
}
