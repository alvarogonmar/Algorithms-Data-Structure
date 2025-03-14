package com.danielblanco.algoritmosestructuras.graphs._03_build_order;

import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.Graph;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNode;
import com.danielblanco.algoritmosestructuras.graphs._00_graph_search.GraphNodeStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class BuildOrderSolution { // Cambio de nombre de BuildOrder a BuildOrderSolution
  public List<String> buildOrder(String[] projects, String[][] dependencies) { // Cambio de nombre de buildOrder a
                                                                               // buildOrderSolution
    Graph graph = buildDependencyGraph(projects, dependencies); // Cambio de nombre de buildDependencyGraph a
                                                                // buildDependencyGraph

    List<String> sortedProjects = new ArrayList<String>(); // Crear una lista de strings para almacenar los proyectos
    for (GraphNode node : graph.nodes.values()) { // Recorrer los nodos del grafo
      depthSearchFirst(node, sortedProjects); // Llamar a la función depthSearchFirst
    }

    Collections.reverse(sortedProjects); // Invertir la lista de proyectos
    return sortedProjects; // Devolver la lista de proyectos
  }

  private void depthSearchFirst(GraphNode node, List<String> orderedProjects) { // función depthSearchFirst
    if (node.status == GraphNodeStatus.Unvisited) { // si el nodo no ha sido visitado
      node.status = GraphNodeStatus.Visiting; // marcar el nodo como visitado
      for (GraphNode adjacent : node.adjacents.values()) { // recorrer los nodos adyacentes
        depthSearchFirst(adjacent, orderedProjects);
      }

      node.status = GraphNodeStatus.Visited; // marcar el nodo como visitado
      orderedProjects.add(node.value); // añadir el nodo a la lista de proyectos
    } else if (node.status == GraphNodeStatus.Visiting) {
      throw new RuntimeException(); // Found a cycle, cannot be built
    }
  }

  private Graph buildDependencyGraph(String[] projects, String[][] dependencies) { // función buildDependencyGraph
    if (dependencies == null || dependencies.length == 0) { // si no hay dependencias
      return null; // devolver nulo
    }

    Graph graph = new Graph(); // crear un nuevo grafo

    for (String project : projects) { // recorrer los proyectos
      graph.getOrCreateNode(project); // obtener o crear un nodo
    }

    for (String[] dep : dependencies) { // recorrer las dependencias
      graph.addEdge(dep[0], dep[1]); // añadir una arista
    }
    return graph; // devolver el grafo
  }
}
