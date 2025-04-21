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
public class QueueWithStacksSolution {
  Deque<Integer> firstStack = new ArrayDeque<>(); // hacer array deque
  Deque<Integer> secondStack = new ArrayDeque<>(); // hacer segundo array deque

  public void add(Integer value) {
    firstStack.push(value);
  }

  private void shiftStacks() {
    if (secondStack.isEmpty()) { // si el segundo stack está vacío
      while (!firstStack.isEmpty()) { // mientras el primer stack no esté vacío
        secondStack.push(firstStack.pop()); // pasamos los elementos del primer stack al segundo
      }
    }
  }

  public Integer peek() { // devuelve el primer elemento de la cola
    shiftStacks(); // pasamos los elementos del primer stack al segundo
    return secondStack.peek(); // devolvemos el primer elemento del segundo stack
  }

  public Integer remove() { // elimina el primer elemento de la cola
    shiftStacks();
    return secondStack.pop(); // eliminamos el primer elemento del segundo stack
  }

  public boolean isEmpty() { // devuelve true si la cola está vacía
    return size() == 0; // si el tamaño de la cola es 0
  }

  public int size() {
    return firstStack.size() + secondStack.size();
  }
}
