package com.danielblanco.algoritmosestructuras._01_remove_dups;

import java.util.HashSet;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

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
public class RemoveDups {

  public void removeDups(Node head) {
    if (head == null)
      return; // Comprobar si la linked list esta vacia
    HashSet<Integer> foundValues = new HashSet<>(); // Declarar un hashset para almacenar los valores encontrados
    Node current = head; // Puntero auxiliar para recorrer la linked list
    foundValues.add(current.value); // Añadir el valor del nodo actual al hashset

    while (current != null && current.next != null) {
      if (foundValues.add(current.next.value)) { // Te devuelve true si el valor se puedo aniadir a la lista y false si
                                                 // no se pudo aniadir lo que quiere decir que ya estaba en el set
        current.next = current.next.next; // Si el valor no esta en el hashset avanzamos al siguiente nodo
      }
      current = current.next; // Avanzamos al siguiente nodo
    }
  }
}
