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
 *  Output: true
 */
public class IsSubTreeSolution { // Clase principal que determina si un árbol es subárbol de otro

  public boolean isSubtree(Node first, Node second) { // Función principal que determina si un árbol es subárbol de otro
    StringBuilder stb1 = new StringBuilder(); // Crear un StringBuilder para el primer árbol
    StringBuilder stb2 = new StringBuilder(); // Crear un StringBuilder para el segundo árbol

    preOrder(first, stb1); // Llamar a la función preOrder para el primer árbol
    preOrder(second, stb2); // Llamar a la función preOrder para el segundo árbol

    return stb1.toString().contains(stb2.toString()); // Comprobar si el segundo árbol es subárbol del primero
  }

  private void preOrder(Node node, StringBuilder stb) { // Función auxiliar que recorre el árbol en preorden
    if (node == null) { // Si el nodo es nulo, añadir un marcador
      stb.append("X"); // Añadir un marcador para indicar un nodo nulo
      return; // Retornar para evitar recorrer nodos nulos
    }

    stb.append(node.value); // Añadir el valor del nodo al StringBuilder
    preOrder(node.left, stb); // Llamar a la función recursivamente para el hijo izquierdo
    preOrder(node.right, stb); // Llamar a la función recursivamente para el hijo derecho
  }
}
