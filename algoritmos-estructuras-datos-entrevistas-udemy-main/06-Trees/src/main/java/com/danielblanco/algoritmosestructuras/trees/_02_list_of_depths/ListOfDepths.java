package com.danielblanco.algoritmosestructuras.trees._02_list_of_depths;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Implementa un algoritmo que devuelva una lista enlazada con los nodos de cada nivel. Si el árbol tiene
 * N niveles debes devolver N listas enlazadas.
 *
 * Ejemplo:
 *  Input:
 *        4
 *     2     7
 *   1   3  6  9
 *
 *  Output:
 *    4
 *    2->7
 *    1->3->6->9
 */
public class ListOfDepths {

  public List<LinkedList<Node>> listOfDepths(Node root) {
    List<LinkedList<Node>> result = new ArrayList(); // Creamos una lista de listas enlazadas
    List<Node> current = new LinkedList<>(); // Creamos una lista enlazada
    current.add(root); // Añadimos el nodo raíz a la lista enlazada

    while (!current.isEmpty()) { // Mientras la lista enlazada no esté vacía
      result.add(current); // Añadimos la lista enlazada a la lista de listas enlazadas
      LinkedList<Node> parents = current; // Guardamos la lista enlazada en una variable temporal
      current = new LinkedList<>(); // Creamos una nueva lista enlazada

      for (Node node : parents) {
        if (node.left != null) { // Si el nodo izquierdo no es nulo
          current.add(node.left); // Añadimos el nodo izquierdo a la lista enlazada
        }
        if (node.right != null) { // Si el nodo derecho no es nulo
          current.add(node.right); // Añadimos el nodo derecho a la lista enlazada
        }
      }
    }
    return result; // Devolvemos la lista de listas enlazadas
  }
}
