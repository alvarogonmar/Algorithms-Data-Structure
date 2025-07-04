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
public class RobotInGrid { // Clase que representa el problema del robot en la cuadrícula

  List<Cell> getPath(boolean[][] grid) { // Método que obtiene el camino desde la esquina superior izquierda a la
                                         // inferior derecha
    if (grid == null || grid.length == 0) // Verifica si la cuadrícula es nula o vacía
      return null; // Retorna null si la cuadrícula es nula o vacía
    List<Cell> path = new ArrayList<Cell>(); // Lista para almacenar el camino encontrado
    if (getPath(grid, 0, 0, path)) { // Llama al método recursivo para encontrar el camino
      Collections.reverse(path); // Invierte el camino para que vaya desde la esquina inferior derecha a la
                                 // superior izquierda
      return path; // Retorna el camino encontrado
    }
    return null; // Retorna null si no se encuentra un camino
  }

  boolean getPath(boolean[][] grid, int row, int col, List<Cell> path) { // Método recursivo que busca un camino desde
                                                                         // la posición (row, col) en la cuadrícula
    if (row >= grid.length || col >= grid[0].length || !grid[row][col]) { // Verifica si la posición está fuera de los
                                                                          // límites de la cuadrícula o si la celda no
                                                                          // es transitable
      return false; // Retorna false si la posición es inválida
    }

    Cell cell = new Cell(row, col); // Crea una nueva celda con las coordenadas actuales

    boolean isAtFinish = (row == grid.length - 1) && (col == grid[0].length - 1); // Verifica si se ha llegado a la
                                                                                  // esquina inferior derecha

    if (isAtFinish || getPath(grid, row, col + 1, path) || getPath(grid, row + 1, col, path)) { // Intenta moverse a la
                                                                                                // derecha o hacia abajo
      path.add(cell); // Agrega la celda al camino si se ha llegado a la esquina inferior derecha o si
                      // se ha encontrado un camino
      return true; // Retorna true si se ha encontrado un camino
    }

    grid[row][col] = false; // Marca la celda como no transitable para evitar ciclos en la búsqueda
    return false; // Retorna false si no se ha encontrado un camino
  }
}
