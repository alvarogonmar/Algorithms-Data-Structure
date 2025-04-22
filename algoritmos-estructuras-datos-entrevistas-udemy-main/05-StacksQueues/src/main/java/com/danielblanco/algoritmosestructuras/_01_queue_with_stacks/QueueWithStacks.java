package com.danielblanco.algoritmosestructuras._01_queue_with_stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implementa una clase MyQueue utilizando dos stacks.
 *
 * Como Stack usaremos la Interfaz Deque, que proporciona las operaciones de una cola doblemente terminada,
 * permitiéndola usar como Pila o Cola (solo las operaciones de Pila están permitidas en este ejercicio).
 *
 * Java también tiene la clase Stack, pero su uso no está recomendado por extender de la clase Vector, que
 * no tiene demasiado sentido, y por ser una clase específica y no una interfaz. Si quieres saber más sobre
 * este tema puedes acceder al siguiente enlace:
 * https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
 */
public class QueueWithStacks {
  Deque<Integer> firstStack = new ArrayDeque<>();
  Deque<Integer> secondStack = new ArrayDeque<>();

  public void add(Integer value) { // Añade un elemento a la cola
    firstStack.push(value); // Añadimos el elemento al primer stack
  }

  public Integer peek() {
    dumpElementsIntoSecondStack(); // Pasamos los elementos de la primera pila a la segunda
    return secondStack.peek(); // peek() devuelve el elemento en la cima de la pila, sin eliminarlo
  }

  public Integer remove() {
    dumpElementsIntoSecondStack();
    return secondStack.pop(); // pop() devuelve y elimina el elemento en la cima de la pila
  }

  private void dumpElementsIntoSecondStack() { // Método privado para pasar los elementos de la primera pila a la
                                               // segunda
    while (!firstStack.isEmpty()) { /// Mientras la pila no esté vacía
      secondStack.push(firstStack.pop()); // Pasamos los elementos de la primera pila a la segunda
    }
  }

  public boolean isEmpty() { // Devuelve true si la cola está vacía
    return size() == 0; // Si el tamaño de la cola es 0
  }

  public int size() { // Devuelve el tamaño de la cola
    return firstStack.size() + secondStack.size(); // Devuelve el tamaño de la cola
  }
}
