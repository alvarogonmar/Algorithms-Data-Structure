package com.danielblanco.algoritmosestructuras.tries._00_trie;

public class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode currentNode = root; // Start at the root
    String lowercaseWord = word.toLowerCase(); // Convert the word to lowercase

    for (char c : lowercaseWord.toCharArray()) { // iterar sobre cada caracter de la palabra
      TrieNode child = currentNode.children.get(c); // Verificar si el caracter ya existe en el nodo actual
      if (child == null) { // Si no existe, crear un nuevo nodo
        child = new TrieNode();
        currentNode.children.put(c, child);
      }
      currentNode = child;
    }

    currentNode.isEndOfWord = true;
  }

  public boolean search(String prefix) {
    TrieNode currentNode = root;
    String prefixLowercase = prefix.toLowerCase();

    for (char c : prefixLowercase.toCharArray()) {
      currentNode = currentNode.children.get(c);
      if (currentNode == null)
        return false;
    }

    return true;
  }
}
