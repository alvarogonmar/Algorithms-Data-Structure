package com.danielblanco.algoritmosestructuras._01_remove_dups;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;
import java.util.HashSet;

/*
 * Escribe un algoritmo para eliminar los elementos duplicados en una Lista enlazada
 *
 * Ejemplo:
 *  Input: 1->2->2->3->4->1
 *  Output: 1->2->3->4
 *
 *
 *
 * Follow-up: ¿Cuál sería tu solución si no pudieras utilizar memoria adicional?
 */
public class RemoveDupsSolution { // O(n)

  public void removeDups(Node head) { // O(n)
    HashSet<Integer> foundValues = new HashSet<Integer>(); // HashSet para almacenar los valores encontrados
    foundValues.add(head.value); // Añadimos el primer valor a la lista
    Node current = head; // Nodo actual

    while (current != null && current.next != null) { // Mientras no lleguemos al final de la linked list
      if (!foundValues.add(current.next.value)) { // Si el valor ya ha sido encontrado
        // Si ya hemos encontrado ese nodo debemos eliminarlo
        current.next = current.next.next; // Saltamos el nodo actual
      }

      // Por último avanzamos el nodo actual para seguir iterando sobre la lista
      current = current.next; // Avanzamos al siguiente nodo
    }
  }
}
