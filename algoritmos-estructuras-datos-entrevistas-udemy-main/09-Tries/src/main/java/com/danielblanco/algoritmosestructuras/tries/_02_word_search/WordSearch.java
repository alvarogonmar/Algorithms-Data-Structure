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
      for (int col = 0; col < cols; col++) {
        if (root.map.containsKey(board[row][col])) {
          dfs(board, root, row, col, result);
        }
      }
    }

    return result;
  }

  private void dfs(char[][] board, TrieNode current, int row, int col, List<String> result) {
    if (current == null) {
      return;
    }

    if (current.word != null) {
      result.add(current.word);
      current.word = null;
    }
    if (row < 0
        || row >= board.length
        || col < 0
        || col >= board[0].length
        || !current.map.containsKey(board[row][col])) {
      return;
    }
    char currentChar = board[row][col];
    board[row][col] = '#';
    TrieNode next = current.map.get(currentChar);
    dfs(board, next, row - 1, col, result);
    dfs(board, next, row, col + 1, result);
    dfs(board, next, row + 1, col, result);
    dfs(board, next, row, col - 1, result);

    board[row][col] = currentChar;
  }

  private TrieNode buildTrie(String[] words, int maxLen) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      if (word == null || word.length() == 0 || word.length() > maxLen) {
        continue;
      }
      TrieNode current = root;
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
