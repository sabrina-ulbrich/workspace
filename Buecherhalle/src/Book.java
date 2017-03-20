/**
 * 
 */

/**
 * The class 'Book' creates objects of books with the attributes
 * title, author, genre, yearOfPublication and isbnNumber
 */
public class Book {
	private String title, author, genre, isbnNumber;
	private int yearOfPublication;
	
	/**
	 * The constructor initializes the book object with its attributes
	 */
	Book(String newTitle, String newAuthor, String newGenre, int newYearOfPublication, String newIsbnNumber){
		title = newTitle;
		author = newAuthor;
		genre = newGenre;
		yearOfPublication = newYearOfPublication;
		isbnNumber = newIsbnNumber;
	}
	
	/**
	 * toString() returns the attributes of a book in a special format
	 */
	public String toString(){
		return title + ", " + author + "\n" + yearOfPublication + "\n" + genre + "\n" + isbnNumber;
	}
	
//	public boolean equals(Book book) {
//		if(this == book) return true;
//		if((book.title.equals(this.tirle)) && ) {
//			
//		}
//	}
}
