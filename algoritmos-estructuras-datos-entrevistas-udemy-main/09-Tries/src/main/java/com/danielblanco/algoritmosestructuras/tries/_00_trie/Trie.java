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
        child = new TrieNode(); // Crear un nuevo nodo
        currentNode.children.put(c, child); // Agregar el nuevo nodo al nodo actual
      }
      currentNode = child; // Mover el puntero al nuevo nodo
    }

    currentNode.isEndOfWord = true; // Marcar el nodo actual como fin de palabra
  }

  public boolean search(String prefix) {
    TrieNode currentNode = root; // Start at the root
    String prefixLowercase = prefix.toLowerCase();

    for (char c : prefixLowercase.toCharArray()) {
      currentNode = currentNode.children.get(c);
      if (currentNode == null)
        return false;
    }

    return true;
  }
}
