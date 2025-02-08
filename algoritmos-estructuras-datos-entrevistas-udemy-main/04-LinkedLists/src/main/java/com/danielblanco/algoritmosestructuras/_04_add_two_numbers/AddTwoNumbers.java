package com.danielblanco.algoritmosestructuras._04_add_two_numbers;

import com.danielblanco.algoritmosestructuras._00_linkedlist.Node;

/*
 * Escribe un algoritmo que realice la suma de dos listas que representan
 * dos enteros positivos. Las listas están en posición invertida.
 *
 * Ejemplo:
 *  Input: 1->2->4, 5->2->8
 *  Output: 6->4->2->1
 *  6421 + 825 = 7246
 */
public class AddTwoNumbers {

  public Node addTwoNumbers(Node list1, Node list2) {
    Node result = new Node(-1); // Crear un nuevo nodo
    Node current = result; // Asignar el nuevo nodo a current
    int carry = 0; // Inicializar el carry en 0

    while (list1 != null || list2 != null) {
      int digit = carry; // Inicializar el dígito con el carry

      if (list1 != null) {
        digit += list1.value; // Sumar el valor de list1 al dígito
        list1 = list1.next; // Avanzar list1
      }
      if (list2 != null) {
        digit += list2.value; // Sumar el valor de list2 al dígito
        list2 = list2.next; // Avanzar list2
      }
    }
  }
}
