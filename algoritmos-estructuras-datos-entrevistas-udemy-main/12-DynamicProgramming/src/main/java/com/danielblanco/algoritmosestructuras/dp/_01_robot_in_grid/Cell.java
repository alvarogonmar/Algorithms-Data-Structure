package com.danielblanco.algoritmosestructuras.dp._01_robot_in_grid;

public class Cell { // Clase que representa una celda en una cuadrícula, utilizada para el problema
                    // del robot en la cuadrícula
  int row; // Fila de la celda
  int col; // Columna de la celda

  public Cell(int row, int col) { // Constructor que inicializa la celda con una fila y una columna específicas
    this.row = row; // Inicializa la fila de la celda
    this.col = col; // Inicializa la columna de la celda
  }

  @Override // Método hashCode para generar un código hash único para la celda
  public int hashCode() { // Utiliza el método hashCode para calcular un código hash basado en la fila y
                          // la columna
    final int prime = 31; // Número primo utilizado para la generación del código hash
    int result = 1; // Inicializa el resultado del código hash en 1
    result = prime * result + row; // Multiplica el resultado por el número primo y suma la fila
    result = prime * result + col; // Multiplica el resultado por el número primo y suma la columna
    return result; // Devuelve el código hash resultante
  }

  @Override // Método equals para comparar dos celdas y determinar si son iguales
  public boolean equals(Object obj) {// Compara la celda actual con otro objeto para ver si son iguales
    if (this == obj) // Si el objeto actual es el mismo que el objeto comparado
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cell other = (Cell) obj;
    if (row != other.row)
      return false;
    if (col != other.col)
      return false;
    return true;
  }
}
