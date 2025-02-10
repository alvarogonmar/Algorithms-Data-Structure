package com.danielblanco.algoritmosestructuras._03_sort_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Ordena un Stack de forma que los elementos más pequeños queden en el tope del Stack.
 * Puedes usar un Stack adicional, pero no está permitido copiar los elementos a otra
 * estructura de datos.
 *
 * Ejemplo:
 *  Input: (tope) 5->1->4->2
 *  Output: (tope) 1->2->4->5
 */
public class SortStack {

  public Deque<Integer> sort(Deque<Integer> stack) {
    Deque<Integer> sortedStack = new ArrayDeque<>(); // Creamos un Stack adicional para almacenar los elementos
                                                     // ordenados
    while (!stack.isEmpty()) { // Mientras el Stack original no este vacio
      Integer element = stack.pop(); // Sacamos el elemento del tope del Stack original
      while (!sortedStack.isEmpty() && sortedStack.peek() > element) { // Mientras el Stack ordenado no esté vacío y
                                                                       // el elemento del tope sea mayor que el elemento
                                                                       // que queremos insertar
        stack.push(sortedStack.pop()); // Pasamos el elemento del tope del Stack ordenado al Stack original
      }
      sortedStack.push(element); // Insertamos el elemento en el Stack ordenado
    }
    return sortedStack; // Devolvemos el Stack ordenado
  }
}
