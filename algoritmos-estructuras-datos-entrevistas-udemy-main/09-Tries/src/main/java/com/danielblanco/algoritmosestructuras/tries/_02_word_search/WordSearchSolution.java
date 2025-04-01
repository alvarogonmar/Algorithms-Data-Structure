package com.danielblanco.algoritmosestructuras.tries._02_word_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Dado un tablero m x n y un array de palabras, retorna todas las palabras existentes en el tablero.
 * Las palabras se pueden formar con caracteres horizontales o verticales, y un caracter no puede ser
 * usado múltiples veces en una palabra.
 *
 * Ejemplo:
 *  Input:
 *    [
 *      ["p","e","r","o"]
 *      ["a","t","a","e"]
 *      ["t","e","l","v"]
 *      ["o","f","l","v"]
 *    ]
 *
 *    words = ["pero","pato","comida", "veo", "pata"]
 *
 *  Output: ["pero","pato", "veo", "pata"]
 *
 */
public class WordSearchSolution {

  class TrieNode { // clase para el nodo del trie
    HashMap<Character, TrieNode> map; // mapa de caracteres a nodos
    String word; // palabra asociada al nodo

    public TrieNode() { // constructor de la clase
      map = new HashMap<>(); // inicializa el mapa
    }
  }

  public List<String> findWords(char[][] board, String[] words) { // método para encontrar palabras
    List<String> result = new ArrayList<>(); // lista de palabras

    int rows = board.length; // número de filas
    int cols = board[0].length; // número de columnas

    TrieNode root = buildTrie(words, rows * cols); // crea el trie
    for (int row = 0; row < rows; row++) { // recorre las filas
      for (int col = 0; col < cols; col++) { // recorre las columnas
        if (root.map.containsKey(board[row][col])) { // si el trie contiene la letra
          dfs(board, root, row, col, result); // hace la búsqueda en profundidad
        }
      }
    }
    return result; // retorna la lista de palabras
  }

  private void dfs(char[][] board, TrieNode current, int row, int col, List<String> result) {
    if (current == null) { // si el nodo es nulo
      return; // retorna
    }

    if (current.word != null) { // si el nodo tiene una palabra
      result.add(current.word);
      current.word = null; // Se pone a null para no volver a añadirla
    }

    if (row < 0 // verifica si la fila es menor a 0
        || row >= board.length // verifica si la fila es mayor o igual al número de filas
        || col < 0 // verifica si la columna es menor a 0
        || col >= board[0].length // verifica si la columna es mayor o igual al número de columnas
        || !current.map.containsKey(board[row][col])) { // verifica si el mapa no contiene la letra
      return; // retorna
    }

    char currentChar = board[row][col]; // guarda el caracter actual
    board[row][col] = '#'; // marca la posición como visitada
    dfs(board, current.map.get(currentChar), row - 1, col, result); // busca en la fila de arriba
    dfs(board, current.map.get(currentChar), row, col + 1, result); // busca en la columna de la derecha
    dfs(board, current.map.get(currentChar), row + 1, col, result); // busca en la fila de abajo
    dfs(board, current.map.get(currentChar), row, col - 1, result); // busca en la columna de la izquierda

    board[row][col] = currentChar; // desmarca la posición como visitada
  }

  private TrieNode buildTrie(String[] words, int maxLen) { // método para construir el trie
    TrieNode root = new TrieNode(); // crea el nodo raíz
    for (String word : words) { // recorre las palabras
      if (word == null || word.length() == 0 || word.length() > maxLen) { // verifica si la palabra es nula o vacía
        continue; // si la palabra es nula o vacía, continúa con la siguiente
      }
      TrieNode current = root; // inicializa el nodo actual como la raíz
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (!current.map.containsKey(c)) {
          current.map.put(c, new TrieNode());
        }
        current = current.map.get(c);
      }
      current.word = word;
    }
    return root;
  }
}
