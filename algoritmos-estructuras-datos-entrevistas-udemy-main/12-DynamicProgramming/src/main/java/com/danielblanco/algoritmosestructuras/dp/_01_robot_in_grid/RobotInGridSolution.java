package com.danielblanco.algoritmosestructuras.dp._01_robot_in_grid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Un robot está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el robot, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class RobotInGridSolution { // Clase que representa el problema del robot en la cuadrícula

  List<Cell> getPath(boolean[][] grid) { // Método que obtiene el camino desde la esquina superior izquierda a la
                                         // inferior derecha
    if (grid == null || grid.length == 0) // Verifica si la cuadrícula es nula o vacía
      return null; // Retorna null si la cuadrícula es nula o vacía
    List<Cell> path = new ArrayList<Cell>(); // Lista para almacenar el camino encontrado
    if (getPath(grid, 0, 0, path)) { // Llama al método recursivo para encontrar el camino
      Collections.reverse(path); // Invierte el camino para que vaya desde la esquina inferior derecha a la
      return path; // superior izquierda
    }
    return null; // Retorna null si no se encuentra un camino
  }

  boolean getPath(boolean[][] grid, int row, int col, List<Cell> path) { // Método recursivo que busca un camino desde
    if (row >= grid.length || col >= grid[0].length || !grid[row][col]) { // la posición (row, col) en la cuadrícula
      return false; // Verifica si la posición está fuera de los
    }

    Cell cell = new Cell(row, col); // límites de la cuadrícula o si la

    boolean isAtFinish = (row == grid.length - 1) && (col == grid[0].length - 1);

    if (isAtFinish || getPath(grid, row, col + 1, path) || getPath(grid, row + 1, col, path)) {
      path.add(cell);
      return true;
    }

    grid[row][col] = false;
    return false;
  }
}
