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
    result = prime * result + col;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
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
