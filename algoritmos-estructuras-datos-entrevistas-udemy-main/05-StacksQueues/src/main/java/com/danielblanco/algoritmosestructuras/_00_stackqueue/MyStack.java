package com.danielblanco.algoritmosestructuras._00_stackqueue;

public class MyStack {
  private Node top; // Almacenar el nodo superior (top) de la pila

  public void push(int value) { //
    Node newTop = new Node(value); // Crear un nuevo nodo con el valor
    newTop.next = top; // El siguiente nodo del nuevo nodo es el nodo superior actual
    top = newTop; // El nuevo nodo es el nodo superior
  }

  public int pop() { // Sacar el nodo superior
    if (top == null) { // Si la pila está vacía
      throw new MyEmptyStackException(); // Lanzar una excepción
    }

    int topValue = top.value; // Guardar el valor del nodo superior
    top = top.next; // El nodo superior es el siguiente nodo
    return topValue; // Devolver el valor del nodo superior
  }

  public int peek() {
    if (top == null) {
      throw new MyEmptyStackException();
    }

    return top.value;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
