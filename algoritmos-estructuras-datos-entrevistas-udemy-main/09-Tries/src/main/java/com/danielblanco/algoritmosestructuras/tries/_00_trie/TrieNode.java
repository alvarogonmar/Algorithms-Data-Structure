package com.danielblanco.algoritmosestructuras.tries._00_trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
  Map<Character, TrieNode> children; // Mapa de caracteres a nodos
  boolean isEndOfWord;

  public TrieNode() {
    children = new HashMap<Character, TrieNode>();
  }
}
