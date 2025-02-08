package com.danielblanco.algoritmosestructuras._03_nth_node_to_last;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Dada una lista enlazada simple y un valor N, devuelve el nodo N empezando por el final
 *
 * Ejemplo:
 *  Input: 1->2->4->6, 2
 *  Output: 4
 */
public class NthNodeToLast {

  public Node nthNodeToLast(Node head, int n) {
    Node p1 = head;
    Node p2 = head;

    for (inte i = 0; i < n; i++) {
      if (p1 == null)
        return null; // Lista no tiene N elementos
      p1 = p1.next;
    }
    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;

    }
  }
}
