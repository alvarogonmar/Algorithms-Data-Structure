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
public class RelativeRanks {

  public String[] findRelativeRanks(int[] score) {
    int numberOfParticipants = score.length;
    String[] result = new String[numberOfParticipants];

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> score[b] - score[a]);
    for (int i = 0; i < numberOfParticipants; i++) {
      maxHeap.add(i);
    }
    int position = 1;
    while (!heap.isEmpty()) {
      int player = heap.poll();

      switch (position) {
        case 1:
          result[player] = "Gold Medal";
          break;
        case 2:
          result[player] = "Silver Medal";
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
