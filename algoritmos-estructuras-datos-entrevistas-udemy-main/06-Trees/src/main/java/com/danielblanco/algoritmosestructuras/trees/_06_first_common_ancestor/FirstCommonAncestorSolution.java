package com.danielblanco.algoritmosestructuras.trees._06_first_common_ancestor;

import com.danielblanco.algoritmosestructuras.trees._00_binarytree.Node;

/*
 * Devuelve el primer ancestro común de dos nodos.
 *
 * Ejemplo:
 *  Input:
 *         4
 *      5     7
 *    1   3
 *  8
 *
 *  firstCommonAncestor(1, 7) = 4
 *  firstCommonAncestor(1, 4) = null
 *  firstCommonAncestor(1, 3) = 5
 *
 */
public class FirstCommonAncestorSolution { // Clase principal que determina el primer ancestro común de dos nodos

  class AncestorNode { // Clase auxiliar que almacena información sobre el ancestro
    boolean nodeFound; // Indica si se ha encontrado un nodo
    Node ancestor; // Almacena el ancestro común
  }

  public Node firstCommonAncestor(Node root, Node firstNode, Node secondNode) { // Función principal que determina el
                                                                                // primer ancestro común
    return postOrderSearch(root, firstNode, secondNode).ancestor; // Llamar a la función postOrderSearch para buscar el
                                                                  // ancestro
  }

  private AncestorNode postOrderSearch(Node current, Node firstNode, Node secondNode) { // Función auxiliar que realiza
                                                                                        // una búsqueda en postorden
    if (current == null) { // Si el nodo actual es nulo, retornar un nuevo AncestorNode
      return new AncestorNode(); // Crear un nuevo AncestorNode
    }

    AncestorNode leftResult = postOrderSearch(current.left, firstNode, secondNode); // Llamar a la función
                                                                                    // recursivamente para el hijo
                                                                                    // izquierdo
    if (leftResult.ancestor != null) // Si se ha encontrado un ancestro en el hijo izquierdo, retornar el resultado
      return leftResult; // Retornar el resultado del hijo izquierdo

    AncestorNode rightResult = postOrderSearch(current.right, firstNode, secondNode); // Llamar a la función
                                                                                      // recursivamente para el hijo
                                                                                      // derecho
    if (rightResult.ancestor != null) // Si se ha encontrado un ancestro en el hijo derecho, retornar el resultado
      return rightResult; // Retornar el resultado del hijo derecho

    AncestorNode result = new AncestorNode(); // Crear un nuevo AncestorNode para almacenar el resultado

    if (leftResult.nodeFound && rightResult.nodeFound) { // Si se han encontrado nodos en ambos hijos, el nodo actual es
                                                         // el ancestro
      result.ancestor = current; // Almacenar el nodo actual como ancestro
      return result; // Retornar el resultado
    }

    result.nodeFound = current == firstNode // Comprobar si el nodo actual es uno de los nodos buscados
        || current == secondNode // Comprobar si el nodo actual es uno de los nodos buscados
        || leftResult.nodeFound // Comprobar si se ha encontrado un nodo en el hijo izquierdo
        || rightResult.nodeFound; // Comprobar si se ha encontrado un nodo en el hijo derecho

    return result; // Retornar el resultado
  }
}
