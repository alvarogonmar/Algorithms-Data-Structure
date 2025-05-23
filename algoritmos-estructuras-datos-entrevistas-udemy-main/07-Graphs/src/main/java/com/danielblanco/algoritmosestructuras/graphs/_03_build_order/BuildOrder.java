package com.danielblanco.algoritmosestructuras.graphs._03_build_order;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.DepthFirstSearch;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.Graph;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNode;

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
    ArrayList<String> sortedProjects = new ArrayList<>(); // lista de proyectos en orden de compilación
    for (Graph.Node node : graph.nodes.values()) { // por cada nodo en el grafo
      depthFirstSearch(node, sortedProjects); // hacer búsqueda en profundidad
    }

    Collection.reverrse(sortedProjects); // invertir la lista de proyectos
    return sortedProjects; // devolver lista de proyectos en orden de compilación
  }

  private void depthFirstSearch(GraphNode node, ArrayList<String> sortedProjects) {
    if (node == null) // si el nodo es nulo, salir
      return; // si el nodo es nulo, salir
    if (node.status == GraphNodeStatus.Unvisited) {
      node.status = GraphNodeStatus.Visiting; // marcar nodo como visitado
      for (GraphNode neighbor : node.adjacents.values()) { // por cada vecino del nodo
        depthFirstSearch(neighbor, sortedProjects); // hacer búsqueda en profundidad en el vecino
      }
      node.status = GraphNodeStatus.Visited; // marcar nodo como visitado
      sortedProjects.add(node.value); // añadir nodo a la lista de proyectos ordenados
    }
  }

  private Graph buildDependencyGraph(String[] projects, String[][] dependencies) { // construir grafo de dependencias
    Graph graph = new Graph(); // crear grafo vacío

    for (String project : projects) { // añadir nodos al grafo
      graph.getOrCreateNode(project); // añadir nodo al grafo con el nombre del proyecto
    }

    for (String[] dep : dependencies) { // por cada dependencia en la lista de dependencias
      graph.addEdge(dep[0], dep[1]); // añadir arista al grafo
    }
    return graph; // devolver grafo de dependencias
  }
}