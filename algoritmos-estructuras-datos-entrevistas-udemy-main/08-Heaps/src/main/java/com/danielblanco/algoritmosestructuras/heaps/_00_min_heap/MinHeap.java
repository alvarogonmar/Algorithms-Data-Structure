package com.danielblanco.algoritmosestructuras.heaps._00_min_heap;

import java.util.Arrays;

public class MinHeap {
  private int[] Heap;
  private int size;
  private int maxSize;

  public MinHeap(int size) { // funcion para crear un heap
    this.maxSize = size;
    this.size = 0;
    Heap = new int[size];
  }

  private int parentIndex(int i) { // funcion para obtener el indice del padre
    return (i - 1) / 2;
  }

  private int leftChildIndex(int i) { // funcion para obtener el indice del hijo izquierdo
    return (i * 2) + 1;
  }

  private int rightChildIndex(int i) { // funcion para obtener el indice del hijo derecho
    return (i * 2) + 2;
  }

  private boolean isLeaf(int i) { // funcion para saber si un nodo es hoja
    if (rightChildIndex(i) >= size && leftChildIndex(i) >= size) {
      return true;
    }
    return false;
  }

  public void insert(int element) { // funcion para insertar un elemento en el heap
    if (size >= maxSize) {
      return;
    }
    Heap[size] = element;
    int current = size;

    while (Heap[current] < Heap[parentIndex(current)]) {
      swap(current, parentIndex(current));
      current = parentIndex(current);
    }
    size++;
  }

  public int extractMin() { // funcion para extraer el minimo del heap
    if (size <= 0)
      return Integer.MIN_VALUE;

    int popped = Heap[0];
    Heap[0] = Heap[--size];
    minHeapify(0);
    return popped;
  }

  private void minHeapify(int i) { // funcion para mantener la propiedad de heap
    if (!isLeaf(i)) { // si no es hoja
      if (Heap[i] > Heap[leftChildIndex(i)] || Heap[i] > Heap[rightChildIndex(i)]) { // si el nodo es mayor que alguno
                                                                                     // de sus hijos
        if (Heap[leftChildIndex(i)] < Heap[rightChildIndex(i)]) { // si el hijo izquierdo es menor que el derecho
          swap(i, leftChildIndex(i)); // intercambiamos el nodo con el hijo izquierdo
          minHeapify(leftChildIndex(i)); // llamamos recursivamente a la funcion con el hijo izquierdo
        } else {
          swap(i, rightChildIndex(i)); // si el hijo derecho es menor que el izquierdo
          minHeapify(rightChildIndex(i)); // llamamos recursivamente a la funcion con el hijo derecho
        }
      }
    }
  }

  public void printHeapPretty() { // funcion para imprimir el heap de forma bonita
    for (int i = 0; i < (size / 2); i++) { // recorremos el heap
      System.out.print("Parent : " + Heap[i]); // imprimimos el padre
      if (leftChildIndex(i) < size) // si el hijo izquierdo existe
        System.out.print(" Left : " + Heap[leftChildIndex(i)]); // imprimimos el hijo izquierdo
      if (rightChildIndex(i) < size) // si el hijo derecho existe
        System.out.print(" Right :" + Heap[rightChildIndex(i)]); // imprimimos el hijo derecho
      System.out.println();
    }
  }

  public void printHeap() {
    System.out.println(Arrays.toString(Heap));
  }

  private void swap(int x, int y) {
    int tmp;
    tmp = Heap[x];
    Heap[x] = Heap[y];
    Heap[y] = tmp;
  }
}
