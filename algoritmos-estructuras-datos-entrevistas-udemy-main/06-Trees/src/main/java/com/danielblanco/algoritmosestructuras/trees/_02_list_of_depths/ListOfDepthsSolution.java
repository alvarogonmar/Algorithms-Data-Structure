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
public class ListOfDepthsSolution { // clase principal que devuelve una lista enlazada con los nodos de cada nivel
  public List<LinkedList<Node>> listOfDepths(Node root) { // función principal que devuelve una lista enlazada con los
                                                          // nodos de cada nivel
    if (root == null) { // si el árbol está vacío
      return null; // devolver null
    }

    List<LinkedList<Node>> result = new ArrayList<>(); // crear una lista para almacenar los nodos de cada nivel

    LinkedList<Node> current = new LinkedList<>(); // crear una lista enlazada para almacenar los nodos del nivel actual
    current.add(root); // añadir la raíz a la lista enlazada

    while (!current.isEmpty()) { // mientras la lista enlazada no esté vacía
      result.add(current); // añadir la lista enlazada a la lista de resultados
      LinkedList<Node> parents = current; // guardar la lista enlazada actual en una variable temporal
      current = new LinkedList<Node>(); // crear una nueva lista enlazada para el siguiente nivel

      for (Node node : parents) { // recorrer la lista enlazada de nodos
        if (node.left != null) { // si el nodo tiene un hijo izquierdo
          current.add(node.left); // añadir el hijo izquierdo a la lista enlazada
        }

        if (node.right != null) { // si el nodo tiene un hijo derecho
          current.add(node.right);
        }
      }
    }
    return result;
  }
}
