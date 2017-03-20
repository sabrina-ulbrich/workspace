import java.util.*;

/**
 * Algorithmen und Datenstrukturen Blatt 10 Aufgabe 4
 * (C) HU Berlin, Andre Koschmieder
 */
public class LongestPath
{
	/**
	 * The main method required the filename of the graph
	 * to load as first argument. The graph is being loaded
	 * and the findLongestPath() method called.
	 */
	public static void main(String []args)
	{
		if (args.length == 0) System.out.println("Please specify the graph file as a parameter.");
		else {
			Graph g = Graph.loadGraph(args[0]);
			System.out.println("Loaded graph with "+g.getNumNodes()+" nodes.");
			findLongestPath(g);
		}
	}

	/**
	 * Find the longest path in the given (acyclic and connected) graph.
	 * As a result, print the names of the nodes at the path endpoints
	 * and the length of the path (or the number of nodes on it).
	 */
	private static void findLongestPath(Graph g)
	{
		// Um Knoten zusaetzliche Werte zuordnen zu koennen, kann z.B. eine
		// HashMap wiefolgt benutzt werden (Knoten werden Integer Werte zugeordnet):
		Map<Graph.Node,Integer> distance = new HashMap<Graph.Node,Integer>(g.getNumNodes());

		// ToDo: Aufgabe 4
		Stack<Graph.Node> stack = new Stack<Graph.Node>();
		Iterator<Graph.Node> itr;
		Graph.Node node, adjacent, target;
		int range, records;
		Graph.Node start = g.getArbitraryNode();
		node = adjacent = target = start;
		range = records = 0;
			
		for(int i = 1; i <= 2; i++) {
			distance.put(start, range);
			records = 1;
			while(records < g.getNumNodes()) {
				itr = node.iterator();
				range = (distance.get(node) + 1);
				while(itr.hasNext()) {
					adjacent = itr.next();
					if(!distance.containsKey(adjacent)) {
						distance.put(adjacent, range);
						stack.push(adjacent);
						records += 1;
						if(distance.get(adjacent) > distance.get(node) && distance.get(adjacent) > distance.get(target)) {
							target = adjacent;
						}
					}	
				}
				if(!stack.empty()) node = stack.pop();
			}
			if(i == 1) {
				start = node = target;
				range = records = 0;
				distance.clear();
				if(!stack.empty()) stack.removeAllElements();
			}
		}
		System.out.println("Longest path: FROM " + start.getName() + " TO " + target.getName() + ", path length=" + distance.get(target));
	}

}