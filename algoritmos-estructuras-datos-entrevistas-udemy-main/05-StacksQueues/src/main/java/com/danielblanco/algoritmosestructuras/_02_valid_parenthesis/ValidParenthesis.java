package com.danielblanco.algoritmosestructuras._02_valid_parenthesis;

import java.util.Deque;

/*
 * Dado un String que solamente contiene los caracteres '(', ')', '{', '}', '[' y ']',
 * implementa un algoritmo para determinar si es válido.
 *
 * Ejemplo 1:
 *  Input: "([]){}"
 *  Output: true
 *
 * Ejemplo 2:
 *  Input: "({)}"
 *  Output: false
 */
public class ValidParenthesis { // O(n) time complexity, O(n) space complexity

  public boolean isValid(String s) { // clase principal que revisa si el string es válido
    Deque<Character> stack = new java.util.ArrayDeque<>(); // crear un stack

    for (char c : s.toCharArray()) { // recorrer el string
      if (c == "(" || c == "{" || c == "[") { // si el caracter es un paréntesis de apertura
        stack.push(getOpposite(c)); // añadir el paréntesis de cierre al stack
      } else { // si el caracter es un paréntesis de cierre
        if (stack.isEmpty() || stack.pop() != c) { // si el stack está vacío o el paréntesis de cierre no coincide con
                                                   // el de apertura
          return false; // devolver false
        }
      }
      return stack.isEmpty(); // devolver true si el stack está vacío
    }
  }

  private Character getOpposite(Character c) { // método privado que devuelve el paréntesis de cierre
    if (c == "(") { // devolver el paréntesis de cierre
      return ")"; // si el paréntesis de apertura es (
    }
    if (c == "{") {
      return "}";
    }
    if (c == "[") {
      return "]";
    }
  }
}
