package com.danielblanco.algoritmosestructuras.graphs._03_build_order;

import java.util.List;

import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.Graph;

/*
 * Dada una lista de proyectos y las dependencias entre ellos, devuelve un orden de
 * compilación válido para dichos proyectos.
 *
 * La lista de dependencias es una lista de pares de strings (a, b), que indican que el
 * proyecto b depende del a (el a debe ser compilado con antelación).
 *
 * Ejemplo 1:
 *  Input:
 *    projects: a, b, c, d
 *    dependencies: [(a, b), (a, c), (a, d), (c, b), (d, b), (d, c)]
 *  Output: a, d, c, b
 *
 * Ejemplo2:
 *  Input:
 *    projects: a, b, c, d
 *    dependencies: [(a, b), (b, c), (c, d), (d, a)]
 *  Output: Lanza excepción. No se puede construir ya que se forma un ciclo.
 *
 */
public class BuildOrder {

  public List<String> buildOrder(String[] projects, String[][] dependencies) {
    Graph graph = buildDependencyGraph(projects, dependencies); // construir grafo de dependencias

  private Graph buildDependencyGraph(String[] projects, String[][] dependencies) { // construir grafo de dependencias
    Graph graph = new Graph(); // crear grafo vacío

    for (String project : projects) { // añadir nodos al grafo
      graph.getOrCreateNode(project); // añadir nodo al grafo con el nombre del proyecto
    }
  }
}
