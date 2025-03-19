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

  class TrieNode {
    HashMap<Character, TrieNode> map;
    String word;

    public TrieNode() {
      map = new HashMap<>();
    }
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();

    int rows = board.length;
    int cols = board[0].length;

    TrieNode root = buildTrie(words, rows * cols);

    return result;
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
      
  }
}
