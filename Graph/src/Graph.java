import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Graph
{
	/**
	 * This class represents one node in the graph.
	 * It implements the iterable interface to iterate over all adjacent nodes.
	 */
	public static final class Node implements Iterable<Node> {
		private String name;
		private List<Node> adjacent;

		private Node(String name) {
			this.name = name;
			adjacent = new ArrayList<Node>(2);
		}

		public String getName() {
			return name;
		}

		public Iterator<Node> iterator() {
			return adjacent.iterator();
		}

		public Node[] getAdjacentNodes() {
			return adjacent.toArray(new Node[adjacent.size()]);
		}

		private void addAdjacency(Node node) {
			adjacent.add(node);
		}
	}

	private List<Node> nodes;

	private Graph(HashMap<String,Node> hashedNodes) {
		nodes = new ArrayList<Node>(hashedNodes.size());
		for (Node n: hashedNodes.values()) nodes.add(n);
	}

	public int getNumNodes() {
		return nodes.size();
	}

	public Node getArbitraryNode() {
		return nodes.get(0);
	}

	public Node[] getNodes() {
		return nodes.toArray(new Node[nodes.size()]);
	}

	/**
	 * Load a graph from a given file. The graph must be stored as a list of edges.
	 */
	public static Graph loadGraph(String filename) {
		int curLine = 0;
		HashMap<String,Node> nodes = new HashMap<String,Node>();
		BufferedReader file = null;
		try {
            file = new BufferedReader(new FileReader(filename));
			String line;
			
			while ((line = file.readLine()) != null) {
				curLine++;
				line = line.trim();
                if ((line.length() == 0) || (line.charAt(0) == ';')) continue;
				
				String []token = line.split("[ \t]+");
				Node from = nodes.get(token[0]);
				if (from == null) nodes.put(token[0],from = new Node(token[0]));
				Node to = nodes.get(token[1]);
				if (to == null) nodes.put(token[1],to = new Node(token[1]));
				from.addAdjacency(to);
				to.addAdjacency(from);
			}
			return new Graph(nodes);
        }
        catch (Exception e) {
            System.err.println("Error in graph file (line "+curLine+"): "+e.toString());
            e.printStackTrace();
        } finally {
			try {
				if (file != null) file.close();
			} catch (IOException ignore) {}
		}
		return null;
	}
}