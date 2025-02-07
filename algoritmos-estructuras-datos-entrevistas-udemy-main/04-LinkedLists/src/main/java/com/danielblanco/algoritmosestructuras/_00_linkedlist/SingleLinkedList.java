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
    current.next = new Node(value);
  }

  public void deleteNode(int value) {
    if (head == null)
      return;

    if (head.value == value) {
      head = head.next;
      return;
    }

    // 4-3-1
    Node current = head;
    while (current.next != null) {
      if (current.next.value == value) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }

  public void print() {
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
