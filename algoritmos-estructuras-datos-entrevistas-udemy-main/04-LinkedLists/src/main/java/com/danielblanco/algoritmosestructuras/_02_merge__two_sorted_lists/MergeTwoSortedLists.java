package com.danielblanco.algoritmosestructuras._02_merge__two_sorted_lists;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Escribe un algoritmo para combinar dos listas enlazadas simples ordenadas.
 * El resultado debe ser una única lista enlazada ordenada. Devuelve su head.
 *
 * Ejemplo:
 *  Input: 1->2->4->6, 2->3->5
 *  Output: 1->2->2->3->4->5->6
 */
public class MergeTwoSortedLists {

  public Node mergeTwoLists(Node list1, Node list2) {
    Node aux = new Node(-1); // Nodo auxiliar para recorrer la linked list
    Node current = aux; // Puntero auxiliar para recorrer la linked list

    // Recorrer ambas listas tomando el menor valor actual de ellas e ir avanzando
    // hasta el final de ambas listas

    while (list1 != null && list2 != null) {
      if (list1.value <= list2.value) { // Si el valor de list1 es menor o igual al de list2
        current.next = list1; // Añadir el nodo de list1 al nodo actual
        list1 = list1.next; // Avanzar al siguiente nodo de list1
      } else {
        current.next = list2; // Añadir el nodo de list2 al nodo actual
        list2 = list2.next; // Avanzar al siguiente nodo de list2
      }
    }
  }
}
