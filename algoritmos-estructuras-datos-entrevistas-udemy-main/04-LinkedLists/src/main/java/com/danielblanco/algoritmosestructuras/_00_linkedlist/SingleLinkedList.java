package com.danielblanco.algoritmosestructuras._00_linkedlist;

public class SingleLinkedList {
  public Node head;

  public void appendToTail(int value) { // Aniadir un odo a la lista
    if (head == null) {
      head = new Node(value); // Iniciar el nodo con el valor que nos pasan como argumento
      return;
    }
    // Recorrer la linked list hasta el ultimo nodo y añadir el nuevo nodo al ultimo
    // nodo
    Node current = head; // Puntero auxiliar para recorrer la linked list
    while (current.next != null) { // Mientras no lleguemos al final de la linked list
      current = current.next; // Avanzamos al siguiente nodo
    }
    current.next = new Node(value); // Añadimos el nuevo nodo al final de la linked list
  }

  public void deleteNode(int value) { // Eliminar el primer nodo que tenga como valor value
    if (head == null) // Comprobar si hay nodos en la lista
      return;

    if (head.value == value) { // Si el valor de head es igual al que queremos eliminar
      head = head.next; // Avazamos head al siguiente nodo y el recolector de basura de java lo elimina
      return;
    }

    // 4-3-1
    Node current = head; // Puntero en nodo inicial
    while (current.next != null) { // Se AVANZA mientras haya nodos
      if (current.next.value == value) { // SI el valor siguiente es igual al que queremos eliminar
        current.next = current.next.next; // Asignamos como nodo sigueinte del actual al sigueinte del siguiente
        return;
      }
      current = current.next; // CASO CONTRARIO: avanzar puntero
    }
  }

  public void print() { // Imprimir la linked list
    if (head == null) {
      System.out.println("END");
      return;
    }
    Node current = head;
    while (current.next != null) {
      System.out.print(current.value + " -> ");
      current = current.next;
    }
    System.out.println(current.value + " -> END");
  }
}
