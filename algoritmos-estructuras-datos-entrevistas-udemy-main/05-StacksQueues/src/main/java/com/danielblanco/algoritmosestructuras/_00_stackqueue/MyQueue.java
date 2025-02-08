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

  public int remove() { // Sacar el primer nodo de la cola
    if (first == null) { // Si la cola está vacía
      throw new MyEmptyQueueException(); // Lanzar una excepción
    }

    int firstValue = first.value; // Guardar el valor del primer nodo
    first = first.next; // Actualizar el primer nodo

    if (first == null) { // Si la cola está vacía
      last = null; // Actualizar el último nodo
    }

    return firstValue; // Devolver el valor del primer nodo
  }

  public int peek() { // Ver el valor del primer nodo sin eliminarlo
    if (first == null) { // Si la cola está vacía
      throw new MyEmptyQueueException(); // Lanzar una excepción
    }

    return first.value; // Devolver el valor del primer nodo
  }

  public boolean isEmpty() {
    return first == null;
  }
}
