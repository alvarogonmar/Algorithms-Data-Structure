package com.danielblanco.algoritmosestructuras._00_stackqueue;

public class MyQueue {
  private Node first; // Almacenar el primer nodo de la cola
  private Node last; // Almacenar el último nodo de la cola

  public void add(int value) { // Agregar un nodo al final de la cola
    Node newLast = new Node(value); // Crear un nuevo nodo con el valor
    if (last != null) { // Si la cola no está vacía
      last.next = newLast; // El siguiente nodo del último nodo es el nuevo nodo
    }

    last = newLast; // El nuevo nodo es el último nodo

    if (first == null) { // Si la cola está vacía
      first = last; // El primer nodo es el último nodo
    }
  }

  public int remove() {
    if (first == null) {
      throw new MyEmptyQueueException();
    }

    int firstValue = first.value;
    first = first.next;

    if (first == null) {
      last = null;
    }

    return firstValue;
  }

  public int peek() {
    if (first == null) {
      throw new MyEmptyQueueException();
    }

    return first.value;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
