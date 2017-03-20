import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class ShortestPath {

	/**
	 * The main method required the filename of the graph to load as first argument.
	 * The graph is being loaded and the findShortestPath() method called.
	 */
	public static void main(String []args) {
		if (args.length == 0) System.out.println("Please specify the graph file as a parameter.");
		else {
			Graph g = Graph.loadGraph(args[0]);
			System.out.println("Loaded graph with "+g.getNumNodes()+" nodes.");
			findShortestPath(g);
		}
	}

	/**
	 * Find the shortest path in the given (acyclic and connected) graph.
	 * As a result, print the names of the nodes at the path endpoints
	 * and the length of the path (or the number of nodes on it).
	 */
	private static void findShortestPath(Graph g)
	{
		// Um Knoten zusaetzliche Werte zuordnen zu koennen, kann z.B. eine
		// HashMap wiefolgt benutzt werden (Knoten werden Integer Werte zugeordnet):
		Map<Graph.Node,Integer> distance = new HashMap<Graph.Node,Integer>(g.getNumNodes());

		// ToDo: Aufgabe
	}
}
