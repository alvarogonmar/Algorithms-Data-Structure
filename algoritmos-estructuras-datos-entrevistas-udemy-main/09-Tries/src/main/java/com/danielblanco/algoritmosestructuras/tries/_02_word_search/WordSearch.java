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
public class WordSearch {

  class TrieNode { // clase para el nodo del trie
    HashMap<Character, TrieNode> map; // mapa de caracteres a nodos
    String word;

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

  private void dfs(char[][] board, TrieNode current, int row, int col, List<String> result) { // método de búsqueda en
                                                                                              // profundidad
    if (current == null) { // si el nodo es nulo
      return; // retorna
    }

    if (current.word != null) { // si la palabra es diferente de nulo
      result.add(current.word); // agrega la palabra a la lista
      current.word = null; // evita duplicados
    }
    if (row < 0
        || row >= board.length
        || col < 0
        || col >= board[0].length
        || !current.map.containsKey(board[row][col])) { // si la fila o columna son inválidas
      return; // retorna
    }
    char currentChar = board[row][col]; // guarda el caracter actual
    board[row][col] = '#'; // marca la posición como visitada
    TrieNode next = current.map.get(currentChar); // obtiene el siguiente nodo
    dfs(board, next, row - 1, col, result); // busca arriba
    dfs(board, next, row, col + 1, result); // busca derecha
    dfs(board, next, row + 1, col, result); // busca abajo
    dfs(board, next, row, col - 1, result); // busca izquierda

    board[row][col] = currentChar; // desmarca la posición
  }

  private TrieNode buildTrie(String[] words, int maxLen) { // método para construir el trie
    TrieNode root = new TrieNode(); // crea el nodo raíz
    for (String word : words) { // recorre las palabras
      if (word == null || word.length() == 0 || word.length() > maxLen) { // si la palabra es nula o vacía
        continue;
      }
      TrieNode current = root; // inicializa el nodo actual
      for (int i = 0; i < word.length(); i++) { // recorre la palabra
        char c = word.charAt(i); // obtiene el caracter
        if (!current.map.containsKey(c)) { // si el mapa no contiene el caracter
          current.map.put(c, new TrieNode()); // agrega el caracter al mapa
        }
        current = current.map.get(c); // obtiene el siguiente nodo
      }
      current.word = word; // asigna la palabra al nodo
    }
    return root;
  }
}
