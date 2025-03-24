package com.danielblanco.algoritmosestructuras.tries._01_title_suggestions;

/*
 * Implementa un método que reciba un array de títulos de libros, un array con prefijos de búsqueda
 * y que devuelva un array indicando si existen libros con esos prefijos o no.
 *
 * También se indicará si las mayúsculas y minúsculas son tratadas como iguales con un parámetro.
 *
 * Ejemplo 1:
 *  Input:
 *    books: ["Whatever", "Book 1", "water", "Book 35"]
 *    prefixes: ["Wo", "Wa", "Boo", "fr"]
 *    ignoreCase: false
 *
 *  Output:
 *    [false, false, true, false]
 *
 * Ejemplo 2:
 *  Input:
 *    books: ["Whatever", "Book 1", "water", "Book 35"]
 *    prefixes: ["Wo", "Wa", "Boo", "fr"]
 *    ignoreCase: true
 *
 *  Output:
 *    [false, true, true, false]
 */
public class TitleSuggestions {

  public boolean[] titleSuggestions(String[] books, String[] prefixes, boolean ignoreCase) {
    Trie dictionary = new Trie(ignoreCase); // Crear un nuevo trie
    for (String book : books) { // Insertar cada libro en el trie
      dictionary.insert(book); // Insertar el libro en el trie
    }
    boolean[] result = new boolean[prefixes.length]; // Crear un array de booleanos
    for (int i = 0; i < prefixes.length; i++) { // Buscar cada prefijo en el trie
      result[i] = dictionary.search(prefixes[i]); // Buscar el prefijo en el trie
    }
    return result;
  }
}
