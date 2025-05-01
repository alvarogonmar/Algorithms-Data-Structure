package com.danielblanco.algoritmosestructuras._04_stack_min;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * ¿Cómo diseñarías un Stack que además de las operaciones de push y pop también
 * contase con una operación para obtener el mínimo?
 */
public class StackMin {

  private Deque<Integer> valuesStack = new ArrayDeque<>(); // Stack para los valores
  private Deque<Integer> minStack = new ArrayDeque<>(); // Stack para los mínimos

  public void push(Integer data) {
    valuesStack.push(data); // Agrega el valor al stack de valores
    if (data <= minStack.peek() || minStack.isEmpty()) {
      minStack.push(data); // Si el valor es menor al mínimo actual, lo agrega al stack de mínimos
    }
  }

  public int pop() {
    int value = valuesStack.pop(); // Saca el valor del stack de valores
    if (value == minStack.peek()) {
      minStack.pop(); // Si el valor es igual al mínimo actual, lo saca del stack de mínimos
    }
    return value; // Devuelve el valor sacado
  }

  public int min() { // Devuelve el mínimo sin sacarlo
    return minStack.peek(); // Devuelve el mínimo sin sacarlo
  }
}
