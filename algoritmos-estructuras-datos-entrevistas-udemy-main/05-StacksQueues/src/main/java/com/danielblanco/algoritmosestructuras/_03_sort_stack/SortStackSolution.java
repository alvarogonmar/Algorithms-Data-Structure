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
    Deque<Integer> sortedStack = new ArrayDeque<>(); // crear un stack auxiliar

    while (!stack.isEmpty()) { // mientras el stack no esté vacío
      Integer element = stack.pop(); // sacar el elemento del stack original
      while (!sortedStack.isEmpty() && element > sortedStack.peek()) { // mientras el stack auxiliar no esté vacío y el
                                                                       // elemento sea mayor que el tope del stack
                                                                       // auxiliar
        stack.push(sortedStack.pop()); // pasar el elemento del stack auxiliar al stack original
      }
      sortedStack.push(element); // añadir el elemento al stack auxiliar
    }

    return sortedStack; // devolver el stack auxiliar
  }
}
