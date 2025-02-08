package com.danielblanco.algoritmosestructuras._05_swap_nodes_in_pairs;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Escribe un algoritmo que intercambie parejas de nodos adyacentes sin
 * modificar el valor interno de los nodos.
 *
 * Ejemplo:
 *  Input: 1->2->4->6->8
 *  Output: 2->1->6->4->8
 */
public class SwapNodesInPairs {

  public Node swapNodesInPairs(Node head) {
    if (head == null || head.next == null) { // Si la lista está vacía o tiene un solo nodo
      return head; // Retornamos la lista tal cual
    }

    Node tmp = head.next.next; // Guardamos el segundo nodo en una variable temporal 4->6->8
    head.next.next = head; // Intercambiamos los dos primeros nodos 1->2->1...
    head = head.next; // Actualizamos la cabeza de la lista 2->1...
    head.next.next = swapNodesInPairs(tmp); // Llamamos recursivamente a la función con el resto de la lista
                                            // 2->1->6->4->8
    return head; // Retornamos la lista con los nodos intercambiados
  }
}
