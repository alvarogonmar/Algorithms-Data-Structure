package com.danielblanco.algoritmosestructuras.tries._01_title_suggestions;

public class Trie { // Clase Trie para almacenar palabras y buscar prefijos
  TrieNode root;
  boolean ignoreCase;

  public Trie(boolean ignoreCase) {
    root = new TrieNode();
    this.ignoreCase = ignoreCase;
  }

  public void insert(String word) {
    TrieNode currentNode = root;

    if (ignoreCase) {
      word = word.toLowerCase();
    }

    for (char c : word.toCharArray()) { // iterar sobre cada caracter de la palabra
      TrieNode child = currentNode.children.get(c); // Verificar si el caracter ya existe en el nodo actual
      if (child == null) { // Si no existe, crear un nuevo nodo
        child = new TrieNode(); // Crear un nuevo nodo
        currentNode.children.put(c, child); // Agregar el nuevo nodo al nodo actual
      }
      currentNode = child; // Mover el puntero al nuevo nodo
    }

    currentNode.isEndOfWord = true; // Marcar el nodo actual como fin de palabra
  }

  public boolean search(String prefix) { // Buscar un prefijo en el trie
    TrieNode currentNode = root; // Start at the root

    if (ignoreCase) { // Convertir el prefijo a minúsculas si se ignoran las mayúsculas
      prefix = prefix.toLowerCase(); // Convertir el prefijo a minúsculas
    }

    for (char c : prefix.toCharArray()) { // Iterar sobre cada caracter del prefijo
      currentNode = currentNode.children.get(c); // Mover el puntero al siguiente nodo
      if (currentNode == null) // Si el nodo es nulo, la palabra no existe
        return false; // Devolver falso
    }

    return true; // Devolver verdadero
  }
}
