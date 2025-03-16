package com.danielblanco.algoritmosestructuras._02_merge__two_sorted_lists;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Escribe un algoritmo para combinar dos listas enlazadas simples ordenadas.
 * El resultado debe ser una única lista enlazada ordenada. Devuelve su head.
 *
 * Ejemplo:
 *  Input: 1->2->4, 2->3->5
 *  Output: 1->2->2->3->4->5
 */
public class MergeTwoSortedListsSolution {

  public Node mergeTwoLists(Node list1, Node list2) { // O(n)
    Node dummy = new Node(Integer.MIN_VALUE); // Nodo dummy para el resultado

    // Se toman los nodos de forma ordenada hasta que se finalice una de las dos
    // listas
    Node current = dummy; // Nodo actual
    while (list1 != null && list2 != null) { // Mientras no se haya finalizado ninguna de las dos listas
      if (list1.value <= list2.value) { // Si el valor de la lista 1 es menor o igual al de la lista 2
        current.next = list1; // Añadimos el nodo de la lista 1
        list1 = list1.next; // Avanzamos al siguiente nodo de la lista 1
      } else {
        current.next = list2; // Añadimos el nodo de la lista 2
        list2 = list2.next; // Avanzamos al siguiente nodo de la lista 2
      }

      current = current.next; // Avanzamos al siguiente nodo
    }

    // Para acabar, se añaden los elementos de la lista que aún no hemos finalizado.
    if (list1 == null) { // Si la lista 1 ha finalizado
      appendList(current, list2); // Añadimos los elementos de la lista 2
    } else {
      appendList(current, list1); // Añadimos los elementos de la lista 1
    }

    return dummy.next; // Devolvemos el nodo dummy
  }

  private void appendList(Node current, Node listToAppend) { // O(n)
    while (listToAppend != null) { // Mientras no se haya finalizado la lista a añadir
      current.next = listToAppend; // Añadimos el nodo
      listToAppend = listToAppend.next; // Avanzamos al siguiente nodo
      current = current.next; // Avanzamos al siguiente nodo
    }
  }
}
