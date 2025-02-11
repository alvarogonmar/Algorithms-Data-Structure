package com.danielblanco.algoritmosestructuras.trees._00_binarytree;

;

public class BinaryTreeTraversals { // Clase para los recorridos de un árbol binario
  public static void inOrderTraversal(Node node) { // Recorrido inOrder
    if (node != null) { // Si el nodo no es nulo
      inOrderTraversal(node.left);
      System.out.print(node.value + " ");
      inOrderTraversal(node.right);
    }
  }

  public static void preOrderTraversal(Node node) {
    if (node != null) {
      System.out.print(node.value + " ");
      preOrderTraversal(node.left);
      preOrderTraversal(node.right);
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
