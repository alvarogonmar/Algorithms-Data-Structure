package com.danielblanco.algoritmosestructuras._03_sort_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Ordena un Stack de forma que los elementos más pequeños queden en el tope del Stack.
 * Puedes usar un Stack adicional, pero no está permitido copiar los elementos a otra
 * estructura de datos.
 *
 * Ejemplo:
 *  Input: (tope) 4->2->5->1
 *  Output: (tope) 1->2->4->5
 */
public class SortStackSolution { // clase principal que ordena un stack

  public Deque<Integer> sort(Deque<Integer> stack) { // función principal que ordena el stack
    Deque<Integer> sortedStack = new ArrayDeque<>();

    while (!stack.isEmpty()) {
      Integer element = stack.pop();
      while (!sortedStack.isEmpty() && element > sortedStack.peek()) {
        stack.push(sortedStack.pop());
      }
      sortedStack.push(element);
    }

    return sortedStack;
  }
}
