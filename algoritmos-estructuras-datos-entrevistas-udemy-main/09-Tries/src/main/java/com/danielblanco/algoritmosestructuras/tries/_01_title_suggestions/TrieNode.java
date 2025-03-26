package com.danielblanco.algoritmosestructuras.tries._01_title_suggestions;

import java.util.HashMap;
import java.util.Map;

public class TrieNode { // TrieNode class
  Map<Character, TrieNode> children; // Map to store children nodes
  boolean isEndOfWord;

  public TrieNode() {
    children = new HashMap<Character, TrieNode>();
  }
}
