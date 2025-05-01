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
    valuesStack.push(data);
    if (minStack.isEmpty() || data <= minStack.peek()) {
      minStack.push(data);
    }
  }

  public int pop() {
    int oldTopData = valuesStack.pop();
    if (oldTopData == minStack.peek()) {
      minStack.pop();
    }
    return oldTopData;
  }

  public int min() {
    return minStack.peek();
  }
}
