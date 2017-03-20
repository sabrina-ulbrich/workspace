public class List {
  public static void main (String[] args) {
    IntList list = new IntList(57, null);
    list = new IntList(1, list);
    list = new IntList(11, list);
    list = new IntList(2, list);
    IntList temp;
    for (temp = list;
	     temp != null;
		 temp = temp.getRest())
      System.out.println(temp.getValue() + ", ");
    System.out.println();
  }
}