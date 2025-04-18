package com.danielblanco.algoritmosestructuras.arraysstringshashtables._01_is_unique;

/*
 * Dado un método que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 * 
 * a: b c d e
 * b: c d e
 * 
 * O(n^2)
 * 
 * Hash Table:
 * a b c d e 
 * 
 * for O(N)
 * Consulta el hashtable O(1)
 */
public class IsUnique {

  private static int NUMBER_OF_CHARS = 128;

  public boolean isUnique(String s) {
    if (s.length() > NUMBER_OF_CHARS) // si la longitud de la cadena es mayor que el número de caracteres posibles, no
                                      // puede ser única
      return false; // retorna false

    Set<Character> characters = new HashSet<>();
    for (Character c : s.toCharArray()) {
      if (characters.contains(c))
        return false;
      characters.add(c);
    }
    return true;
  }
}
