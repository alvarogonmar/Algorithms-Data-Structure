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
public class RelativeRanksSolution { // RelativeRanks
  public String[] findRelativeRanks(int[] score) { // findRelativeRanks
    int numberOfPlayers = score.length; // se obtiene el número de participantes
    String[] res = new String[numberOfPlayers]; // se crea un array para almacenar los resultados

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> score[b] - score[a]); // se crea un heap máximo

    for (int i = 0; i < numberOfPlayers; i++) { // se añaden los participantes al heap
      pq.add(i); // se añade el índice del participante al heap
    }

    int position = 1; // se inicializa la posición en 1
    while (!pq.isEmpty()) { // mientras el heap no esté vacío
      int playerIndex = pq.poll(); // se saca el participante con la puntuación más alta

      switch (position) { // se asigna la posición correspondiente
        case 1:
          res[playerIndex] = "Gold Medal"; // se le asigna la medalla de oro
          break; // se le asigna la medalla de oro
        case 2:
          res[playerIndex] = "Silver Medal"; // se le asigna la medalla de plata
          break; // se le asigna la medalla de plata
        case 3: // caso de que sea el tercer participante
          res[playerIndex] = "Bronze Medal"; // se le asigna la medalla de bronce
          break; // se le asigna la medalla de bronce
        default: // para los demás participantes
          res[playerIndex] = Integer.toString(position); // para los demás participantes se asigna su posición
      }

      position++; // se incrementa la posición
    }

    return res; // se devuelve el array con los resultados
  }
}
