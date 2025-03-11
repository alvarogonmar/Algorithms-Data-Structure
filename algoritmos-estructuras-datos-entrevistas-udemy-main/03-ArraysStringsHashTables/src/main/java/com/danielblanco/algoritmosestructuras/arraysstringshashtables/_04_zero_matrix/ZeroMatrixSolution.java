package com.danielblanco.algoritmosestructuras.arraysstringshashtables._04_zero_matrix;

/*
 * Dada una matriz, escribe un algoritmo para establecer ceros en la fila F y columna C si existe un
 * 0 en la celda F:C
 *
 * Ejemplo:
 *  Input: 2 1 3 0 2
 *         7 4 1 3 8
 *         4 0 1 2 1
 *         9 3 4 1 9
 *
 *  Output: 0 0 0 0 0
 *          7 0 1 0 8
 *          0 0 0 0 0
 *          9 0 4 0 9
 */
public class ZeroMatrixSolution { // O(n*m)

  public void zeroMatrix(int[][] matrix) { // O(n*m)
    boolean firstRowHasZero = hasFirstRowAnyZeroes(matrix); // boleano para saber si la primera fila tiene un 0
    boolean firstColHasZero = hasFirstColAnyZeroes(matrix); // boleano para saber si la primera columna tiene un 0

    // Comprobamos los ceros en el resto de la matriz.
    checkForZeroes(matrix);

    processRows(matrix); // Procesamos las filas
    processColumns(matrix); // Procesamos las columnas

    // Si la primera fila o columna tenía un cero, debemos procesarlas también.
    if (firstRowHasZero) { // Si la primera fila tiene un 0
      setRowToZero(matrix, 0); // Establecemos la primera fila a 0
    }

    if (firstColHasZero) { // Si la primera columna tiene un 0
      setColToZero(matrix, 0); // Establecemos la primera columna a 0
    }
  }

  private boolean hasFirstRowAnyZeroes(int[][] matrix) { // funcion para saber si la primera fila tiene un 0
    for (int i = 0; i < matrix[0].length; i++) { // recorremos la primera fila
      if (matrix[0][i] == 0) { // si encontramos un 0
        return true; // devolvemos true
      }
    }
    return false; // si no encontramos un 0 devolvemos false
  }

  private boolean hasFirstColAnyZeroes(int[][] matrix) { // funcion para saber si la primera columna tiene un 0
    for (int i = 0; i < matrix.length; i++) { // recorremos la primera columna
      if (matrix[i][0] == 0) { // si encontramos un 0
        return true; // devolvemos true
      }
    }
    return false; // si no encontramos un 0 devolvemos false
  }

  /*
   * Si encontramos un cero en F:C, escribimos un cero en la fila F de la primera
   * columna y en la
   * columna C de la primera fila. Así marcamos que la fila y la columna debe ser
   * procesada.
   */
  private void checkForZeroes(int[][] matrix) { // funcion para comprobar los ceros en la matriz
    for (int row = 1; row < matrix.length; row++) { // recorremos las filas
      for (int col = 1; col < matrix[0].length; col++) { // recorremos las columnas
        if (matrix[row][col] == 0) { // si encontramos un 0
          matrix[row][0] = 0; // establecemos la primera columna a 0
          matrix[0][col] = 0; // establecemos la primera fila a 0
        }
      }
    }
  }

  private void processRows(int[][] matrix) { // funcion para procesar las filas
    for (int row = 0; row < matrix.length; row++) {
      if (matrix[row][0] == 0) {
        setRowToZero(matrix, row);
      }
    }
  }

  private void setRowToZero(int[][] matrix, int row) {
    for (int col = 0; col < matrix[0].length; col++) {
      matrix[row][col] = 0;
    }
  }

  private void processColumns(int[][] matrix) {
    for (int col = 0; col < matrix[0].length; col++) {
      if (matrix[0][col] == 0) {
        setColToZero(matrix, col);
      }
    }
  }

  private void setColToZero(int[][] matrix, int col) {
    for (int row = 0; row < matrix.length; row++) {
      matrix[row][col] = 0;
    }
  }
}
