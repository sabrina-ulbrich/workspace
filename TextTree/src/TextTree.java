import java.util.HashMap;
import java.util.Map;
//import java.util.Set;

/**
 * Algorithmen und Datenstrukturen Blatt 05 Aufgabe 3
 * (C) HU Berlin, Andre Koschmieder
 *
 * Eine korrekte Implementierung sollte folgende Ausgabe liefern:
 * $ java TextTree
 * - T - e - s - t*- 1 - 2 - 3 - 4*
 *                 \ e - s*
 *                     \ r*
 *                     \ n*
 *     \ a - g*
 * CORRECT: Tree does not contain Tor.
 * CORRECT: Tree contains Tag.
 * CORRECT: Tree does not contain .
 * CORRECT: Tree does not contain ag.
 * CORRECT: Tree contains Testen.
 * CORRECT: Tree does not contain Test12345.
 * CORRECT: Tree contains Test.
 * Test
 * Test1234
 * Testes
 * Tester
 * Testen
 * Tag
 * - T - e - s - t*- e - s*
 *                     \ n*
 *     \ a - g*
 * CORRECT: Tree contains Testen.
 * CORRECT: Tree does not contain Tester.
 * CORRECT: Tree contains Tag.
 * CORRECT: Tree does not contain Test1234.
 * CORRECT: Tree contains Test.
 */
public class TextTree
{
	private Node root = new Node(null,'@'); // Root node of the text tree

	/**
	 * Add the given word to the text tree.
	 */
	public void add(String word)
	{
		// ToDo: Aufgabe 3a)
		Node parent = root;
		Node node;
		for(int i = 0; i < word.length(); i++) {
			node = parent.getChild(word.charAt(i));
			if(node == null) {
				node = new Node(parent, word.charAt(i));
				parent.addChild(word.charAt(i), node);
			}
			parent = node;
		}
		parent.setWord();
	}

	/**
	 * Determine if the given word is contained in the text tree.
	 */
	public boolean contains(String word)
	{
		return (find(word) != null);
	}

	/**
	 * Search the text tree for the given word.
	 * @return the Node object representing the word,
	 *         or null if the word is not contained in the tree.
	 */
	private Node find(String word)
	{
		// ToDo: Aufgabe 3b)
		Node parent = root;
		Node node;
		for(int i = 0; i < word.length(); i++) {
			node = parent.getChild(word.charAt(i));
			if(node == null) {
				return null;
			}
			if(node.isWord() && i == (word.length() -1)) {
				return node;
			}
			parent = node;
		}
		return null;
	}

	/**
	 * Remove the given word from the text tree, if contained.
	 * Also remove leaf nodes that do not represent a word any more.
	 */
	public void remove(String word)
	{
		// ToDo: Aufgabe 3c)
		Node node = this.find(word);
		if(node != null){
			Node parent;
			for(int i = word.length() - 1; i >= 0; i--) {
				if(node.hasChildren() && i == (word.length() -1)) {
					node.removeWord();
					break;
				}
				if(!node.hasChildren()) {
					parent = node.getParent();
					parent.removeChild(node.getChar());
					node = parent;
				}
			}
		}
	}

	/**
	 * Print a list of all words in the text tree.
	 */
	public void printWords()
	{
		root.printWordsRecursive("");
	}

	/**
	 * Print a pseudo-graphical representation of the text tree.
	 */
	public void print()
	{
		root.print();
	}

	/**
	 * Main method with a simple test case for the text tree.
	 */
	public static void main(String[] args)
	{
		TextTree tt = new TextTree();
		tt.add("Test1234");
		tt.add("Testen");
		tt.add("Tag");
		tt.add("Test");
		tt.add("Tester");
		tt.add("Testes");
//		tt.add("Haus");
//		tt.add("Haustuer");
		tt.print();
		check(tt,"Tor",false);
		check(tt,"Tag",true);
		check(tt,"",false);
		check(tt,"ag",false);
		check(tt,"Testen",true);
		check(tt,"Test12345",false);
		check(tt,"Test",true);
//		check(tt,"Haus",true);
//		check(tt,"Haustuer",true);
		tt.printWords();
		tt.remove("Tester");
		tt.remove("Test1234");
//		tt.remove("Haus");
		tt.print();
		check(tt,"Testen",true);
		check(tt,"Tester",false);
		check(tt,"Tag",true);
		check(tt,"Test1234",false);
		check(tt,"Test",true);
//		check(tt,"Haus",false);
//		check(tt,"Haustuer",true);
	}

	private static void check(TextTree tt,String s,boolean correctResult)
	{
		if ((tt.find(s) != null) == correctResult)
			System.out.println("CORRECT: Tree "+(correctResult?"contains ":"does not contain ")+s+".");
		else System.out.println("ERROR: "+s+" is falsely reported as "+(correctResult?"not contained.":"contained."));
	}
}

/**
 * A Node object represents one node in the text tree.
 */
class Node
{
	private Node parent;
	private char c;
	private Map<Character,Node> children;
	private boolean bWordEnds;

	Node(Node parent,char c)
	{
		this.parent = parent;
		this.c = c;
		children = new HashMap<Character,Node>();
	}

	void addChild(Character c,Node child)
	{
		children.put(c,child);
	}

	void removeChild(Character c)
	{
		children.remove(c);
	}

	Node getChild(Character c)
	{
		return children.get(c);
	}

	Node getParent()
	{
		return parent;
	}

	void setWord()
	{
		bWordEnds = true;
	}

	void removeWord()
	{
		bWordEnds = false;
	}

	boolean isWord()
	{
		return bWordEnds;
	}

	char getChar()
	{
		return c;
	}

	boolean hasChildren()
	{
		return !children.isEmpty();
	}

	void print()
	{
		printRecursive(0,true);
	}

	private void printRecursive(int level,boolean bFirst)
	{
		if (level > 0)
		{
			if (bFirst) System.out.print("- ");
			else {
				for (int i = 0; i < level-1; i++) System.out.print("    ");
				System.out.print("\\ ");
			}
			System.out.print(c+(bWordEnds?"*":" "));
		}
		bFirst = true;
		for (Map.Entry<Character,Node> entry: children.entrySet())
		{
			entry.getValue().printRecursive(level+1,bFirst);
			bFirst = false;
		}
		if (children.isEmpty()) System.out.println();
	}

	/**
	 * Recursively print out all words represented by the subtree
	 * consisting of the current node and all its descendants.
	 * @param word Prefix of the word represented by this node.
	 */
	void printWordsRecursive(String word)
	{
		// ToDo: Aufgabe 3d)
		if(getParent() != null) {
			word = word + c;
		}
		if(isWord()) {
			System.out.println(word);
		}
		for(Map.Entry<Character,Node> entry: children.entrySet()) {
			entry.getValue().printWordsRecursive(word);
		}
	}
}