package com.danielblanco.algoritmosestructuras.tries._00_trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
  Map<Character, TrieNode> children; // Mapa de caracteres a nodos
  boolean isEndOfWord; // Indica si el nodo es el final de una palabra

  public TrieNode() { // Constructor de la clase
    children = new HashMap<Character, TrieNode>(); // Inicializa el mapa
  }
}
