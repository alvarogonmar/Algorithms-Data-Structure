package com.danielblanco.algoritmosestructuras._00_stackqueue;

public class MyStack {
  private Node top; // Almacenar el nodo superior (top) de la pila

  public void push(int value) { //
    Node newTop = new Node(value); // Crear un nuevo nodo con el valor
    newTop.next = top; // El siguiente nodo del nuevo nodo es el nodo superior actual
    top = newTop; // El nuevo nodo es el nodo superior
  }

  public int pop() {
    if (top == null) {
      throw new MyEmptyStackException();
    }

    int topValue = top.value;
    top = top.next;
    return topValue;
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
