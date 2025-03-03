package com.danielblanco.algoritmosestructuras.arraysstringshashtables._03_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"]
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 */
public class GroupAnagramsSolution {

  public List<List<String>> groupAnagrams(String[] strs) { // O(n * m) time, O(n) space
    if (strs == null || strs.length == 0) // if para validar el input
      return Collections.emptyList(); // si el input es invalido, retornamos una lista vacia

    Map<String, List<String>> anagramMap = buildAnagramMap(strs); // O(n * m) time, O(n) space
    return new ArrayList<>(anagramMap.values()); // O(n) time, O(n) space
  }

  private Map<String, List<String>> buildAnagramMap(String[] strs) { // O(n * m) time, O(n) space
    Map<String, List<String>> anagramMap = new HashMap<String, List<String>>(); // map para guardar los anagramas
    for (String s : strs) { // for para recorrer el array de strings
      String hash = getAnagramHash(s); // string hash para guardar el hash de cada string
      if (!anagramMap.containsKey(hash)) { // if para validar si el hash ya existe en el map
        anagramMap.put(hash, new ArrayList<String>()); // si no existe, creamos una nueva lista
      }

      anagramMap.get(hash).add(s); // agregamos el string a la lista correspondiente
    }

    return anagramMap; // retornamos el map con los anagramas
  }

  private String getAnagramHash(String s) {
    int[] letterCount = new int[26];
    for (int c : s.toCharArray()) {
      letterCount[c - 'a']++;
    }

    return Arrays.toString(letterCount);
  }
}
