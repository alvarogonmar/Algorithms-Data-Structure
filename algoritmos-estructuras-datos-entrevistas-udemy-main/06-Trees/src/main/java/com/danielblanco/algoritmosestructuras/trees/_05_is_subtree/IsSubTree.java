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

    preOrder(first, sb1); // se llama a la funcion preorder para el arbol first
    preOrder(second, sb2); // se llama a la funcion preorder para el arbol first
    return sb1.toString().contains(sb2.toString()); // se retorna si el string builder 1 contiene el string builder 2
  }

  private void preOrder(Node node, StringBuilder sb) { // funcion de recorrido preorder
    if (node == null) { // si el nodo es nulo
      sb.append("X"); // se agrega una X al string builder
      return; // se termina la funcion
    }
    sb.append(node.value); // se agrega el valor del nodo al string builder
    preOrder(node.left, sb); // se llama recursivamente a la izquierda
    preOrder(node.right, sb); // se llama recursivamente a la derecha
  }
}
