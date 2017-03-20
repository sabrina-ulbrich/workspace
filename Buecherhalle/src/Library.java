/**
 * The class library maintains book-objects: they can be inserted,
 * deleted and listed
 */
public class Library {
	private Book[] listOfBooks;
	private int capacityIncrement, stockIndex;
	
	/**
	 * The Constructor sets the initial capacity of books and the
	 * amount to increment the book capacity, when the library is full;
	 * stockIndex is set to 0, when a new library is created, because
	 * no books are in the library, before they are not inserted
	 */
	Library(int initialCapacity, int capacityIncrement) {
		this.capacityIncrement = capacityIncrement;
		listOfBooks = new Book[initialCapacity];
		stockIndex = 0;
	}
	
	/**
	 * insert a book to the library and
	 * increments the stock when it is full
	 */
	public void insert(Book b) {
		if(stockIndex == listOfBooks.length){
			Book[] temp = new Book[listOfBooks.length + capacityIncrement];
			for(int i = 0; i < listOfBooks.length; i++){
				temp[i] = listOfBooks[i];
			}
			listOfBooks = temp;
		}
		listOfBooks[stockIndex++] = b;
	}

	/**
	 * delete a book from the library
	 * separate Methode! findBook
	 */
	public void delete(Book b) {
		int gap = -1;
		for(int i = 0; i < stockIndex; i++){
			if(listOfBooks[i].equals(b)){
				gap = i;
				break;
			}
		}
		for(int i = gap; i < stockIndex-1; i++){
			listOfBooks[i] = listOfBooks[i+1];
		}
		listOfBooks[stockIndex-1] = null;
		stockIndex--;
	}

	/**
	 * print the entire list of books
	 */
	public void print(){
		for(int i = 0; i < stockIndex; i++){
			System.out.println(listOfBooks[i]); // implizierter Aufruf der toString()-Methode
		}
	}
}
