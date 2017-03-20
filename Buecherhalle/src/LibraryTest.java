/**
 * 
 */

/**
 * @author sabrina
 *
 */
public class LibraryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Book bookA = new Book("Java ist auch eine Insel", "Christian Ullenbook", "Sachbuch", 2009, "978-3836213714");
		//System.out.println(bookA.toString());
		
		Library lib = new Library(3, 1);
		//MariasLibrary lib = new MariasLibrary(3, 1);
		lib.insert(bookA);
		//lib.print();
		Book bookB = new Book("Thinking in Java", "Bruce Eckel", "Sachbuch", 2009, "978-3836213714");
		Book bookC = new Book("Begriffsschrift", "Gottlob Frege", "Sachbuch", 1879, "978-3836213714");
		Book bookD = new Book("Alice's Adventures in Wonderland", "Lewis Caroll", "Erzaehlung", 1865, "978-1112223334");
		lib.insert(bookB);
		lib.insert(bookC);
		lib.insert(bookD);
		lib.print();
		lib.delete(bookA);
		lib.print();
	}

}
