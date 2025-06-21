package com.danielblanco.algoritmosestructuras.dp._03_generate_parenthesis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Dados n pares de paréntesis, implementa un algoritmo para generar todas las combinaciones
 * válidas de paréntesis.
 *
 * Ejemplo 1:
 *  Input:
 *    n: 1
 *  Output:
 *    ["()"]
 *
 * Ejemplo 2:
 *  Input:
 *    n: 3
 *  Output:
 *    ["((()))","(()())","(())()","()(())","()()()"]
 *
 */
public class GenerateParenthesisSolution { // Clase que representa el problema de generar combinaciones válidas de
                                           // paréntesis

  public List<String> generateParenthesis(int n) { // Método que genera todas las combinaciones válidas de paréntesis
    if (n < 1)
      return Collections.emptyList(); // Verifica si n es menor que 1

    List<String> result = new ArrayList<String>(); // Lista para almacenar las combinaciones válidas de paréntesis
    generateParenthesis(n, n, new StringBuilder(), result); // Llama al método recursivo para generar las combinaciones
    return result; // Retorna la lista de combinaciones válidas de paréntesis
  }

  private void generateParenthesis( // Método recursivo que genera combinaciones válidas de paréntesis
      int openLeft, int closeLeft, StringBuilder current, List<String> result) { // Parámetros:
    if (openLeft == 0 && closeLeft == 0) { // Verifica si no quedan paréntesis por agregar
      result.add(current.toString());
      return;
    }

    if (openLeft > 0) {
      generateParenthesis(openLeft - 1, closeLeft, current.append('('), result);
      current.setLength(current.length() - 1);
    }

    if (closeLeft > openLeft) {
      generateParenthesis(openLeft, closeLeft - 1, current.append(')'), result);
      current.setLength(current.length() - 1);
    }
  }
}
