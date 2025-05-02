package com.danielblanco.algoritmosestructuras._04_stack_min;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * ¿Cómo diseñarías un Stack que además de las operaciones de push y pop también
 * contase con una operación para obtener el mínimo?
 */
public class StackMinSolution {

  private Deque<Integer> valuesStack = new ArrayDeque<>(); // Stack para los valores
  private Deque<Integer> minStack = new ArrayDeque<>(); // Stack para los mínimos

  public void push(Integer data) { // Agrega el valor al stack de valores
    valuesStack.push(data); // Si el valor es menor al mínimo actual, lo agrega al stack de mínimos
    if (minStack.isEmpty() || data <= minStack.peek()) { // Si el stack de mínimos está vacío o el nuevo valor es menor
                                                         // o igual al mínimo actual
      minStack.push(data); // Agrega el nuevo valor al stack de mínimos
    }
  }

  public int pop() { // Saca el valor del stack de valores
    int oldTopData = valuesStack.pop(); // Saca el valor del stack de valores
    if (oldTopData == minStack.peek()) { // Si el valor sacado es igual al mínimo actual
      minStack.pop();
    }
    return oldTopData;
  }

  public int min() {
    return minStack.peek();
  }
}
