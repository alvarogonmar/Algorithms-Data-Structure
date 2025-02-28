package com.danielblanco.algoritmosestructuras.arraysstringshashtables._01_is_unique;

import java.util.HashSet;
import java.util.Set;

/*
 * Dado un método que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 */
public class IsUniqueSolution {

  // Asumiendo que es ASCII. Dependiendo de la codificación serán más
  private static int NUMBER_OF_CHARS = 128; // funcion de complejidad O(1)

  public boolean isUnique(String s) { // O(n)
    if (s.length() > NUMBER_OF_CHARS) // si la longitud de la cadena es mayor que el número de caracteres posibles
      return false; // entonces no puede ser única

    Set<Character> set = new HashSet<Character>(); // set para almacenar los caracteres
    for (char c : s.toCharArray()) { // recorremos la cadena
      if (set.contains(c)) // si el set ya contiene el caracter
        return false; // entonces no es única
      set.add(c); // si no lo contiene, lo añadimos al set
    }

    return true;
  }
}
