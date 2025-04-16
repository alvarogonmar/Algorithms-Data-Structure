package com.danielblanco.algoritmosestructuras.heaps._03_relative_ranks;

import java.util.PriorityQueue;

/*
 * Recibes un array de puntuaciones, en el que el valor de la posición i se corresponde
 * con la puntuación del participante i. No puede haber puntuaciones repetidas.
 *
 * Devuelve un array con la posición obtenida por cada participante, dando medallas a los
 * tres primeros.
 *
 * Ejemplo 1:
 *  Input: [5,4,3,2,1]
 *  Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 *
 * Ejemplo 2:
 *  Input: [10,3,8,9,4]
 *  Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 */
public class RelativeRanks { // RelativeRanks
  /*
   * La solución consiste en crear un heap máximo con las puntuaciones de los
   * participantes.
   * Luego, se van sacando los elementos del heap y se les asigna la posición
   * correspondiente.
   * Se utiliza un switch para asignar las medallas a los tres primeros.
   */

  public String[] findRelativeRanks(int[] score) {
    int numberOfParticipants = score.length; // se obtiene el número de participantes
    String[] result = new String[numberOfParticipants]; // se crea un array para almacenar los resultados

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> score[b] - score[a]); // se crea un heap máximo
    for (int i = 0; i < numberOfParticipants; i++) { // se añaden los participantes al heap
      maxHeap.add(i); // se añade el índice del participante al heap
    }
    int position = 1; // se inicializa la posición en 1
    while (!heap.isEmpty()) { // mientras el heap no esté vacío
      int player = heap.poll(); // se saca el participante con la puntuación más alta

      switch (position) { // se asigna la posición correspondiente
        case 1: // si es el primer participante
          result[player] = "Gold Medal"; // se le asigna la medalla de oro
          break;
        case 2: // si es el segundo participante
          result[player] = "Silver Medal"; // se le asigna la medalla de plata
          break;
        case 3:
          result[player] = "Bronze Medal";
          break;

        default:
          result[player] = Integer.toString(position);
          break;
      }
      position++;
    }
    return result;
  }
}
