package com.danielblanco.algoritmosestructuras.trees._01_invert_binary_tree;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Dada la raíz de un árbol binario, devuelve el árbol binario invertido.
 *
 * Ejemplo:
 *  Input:
 *        4
 *     2     7
 *   1   3  6  9
 *
 *  *  Output:
 *        4
 *     7     2
 *   9   6  3  1
 */
public class InvertBinaryTreeSolution {

  public Node invertTree(Node root) { // O(n) - O(n)
    if (root == null) // si el nodo es nulo
      return null; // return O(1)

    Node tmp = root.left; // node temporal para guardar el nodo izquierdo
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);

    return root;
  }
}
