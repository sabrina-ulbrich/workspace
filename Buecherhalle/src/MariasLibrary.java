public class MariasLibrary {
	
	private Book[] bookArray;
	private int capacityIncrement;
	private int nextFreeSpot;

	public MariasLibrary (int initialCapacity, int capacityIncrement){
		bookArray=new Book[initialCapacity]; 
		this.capacityIncrement=capacityIncrement;
		nextFreeSpot=0;
	}
	
	public void insert(Book b){
		if (nextFreeSpot>=bookArray.length){
			Book [] temp= new Book [bookArray.length + capacityIncrement];
			for (int i=0; i<bookArray.length; i++){
				temp [i]= bookArray [i];
			}
			bookArray=temp;

		}
		bookArray[nextFreeSpot] = b;
		nextFreeSpot ++;
	}
	public void delete(Book b){
		int location=-1;
		
		for (int i=0; i<nextFreeSpot; i++){
			if (bookArray[i].equals(b)){
				location=i;
				break;
			}
		}
		
		if(location>=0) {
			for (int j=location; j<=nextFreeSpot-2; j++){
				bookArray[j]=bookArray[j+1];
			}
			bookArray[nextFreeSpot-1]=null;
			nextFreeSpot--;
		}
	}

	public void print(){
		for (int i=0; i<nextFreeSpot; i++){
			System.out.println (bookArray[i].toString());
		}
	}
}