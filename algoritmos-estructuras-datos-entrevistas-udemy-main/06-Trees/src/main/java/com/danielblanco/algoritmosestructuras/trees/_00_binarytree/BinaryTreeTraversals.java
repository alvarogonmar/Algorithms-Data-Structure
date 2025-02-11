package com.danielblanco.algoritmosestructuras.trees._00_binarytree;

;

public class BinaryTreeTraversals { // Clase para los recorridos de un árbol binario
  public static void inOrderTraversal(Node node) { // Recorrido inOrder
    if (node != null) { // Si el nodo no es nulo
      inOrderTraversal(node.left); // Recorre el nodo izquierdo
      System.out.print(node.value + " "); // Imprime el valor del nodo
      inOrderTraversal(node.right); // Recorre el nodo derecho
    }
  }

  public static void preOrderTraversal(Node node) { // Recorrido preOrder
    if (node != null) { // Si el nodo no es nulo
      System.out.print(node.value + " "); // Imprime el valor del nodo
      preOrderTraversal(node.left); // Recorre el nodo izquierdo
      preOrderTraversal(node.right); // Recorre el nodo derecho
    }
  }

  public static void postOrderTraversal(Node node) {
    if (node != null) {
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);
      System.out.print(node.value + " ");
    }
  }
}
