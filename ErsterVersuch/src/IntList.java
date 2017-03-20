
public class IntList {
	
	  private int value;
	  private IntList rest;

	  public IntList (int v, IntList next) {
	    value = v;
	    rest = next;
	  }

	  public int getValue() { return value; }

	  public void setValue(int val) { value = val; }

	  public IntList getRest() { return rest; }

	  public int length() {
	    if (rest == null)
	      return 1;
	    else
	      return 1 + rest.length();
	  }

	  public String toString() {
	    String myValue = Integer.toString(value);
	    if (rest == null)
	      return myValue;
	    else
	      return myValue + ", " + rest.toString();
	  }

	  public IntList find(int key) {
	    if (value == key)
	      return this;
	    else if (rest == null)
	      return null;
	    else
	      return rest.find(key);
	  }

	  public IntList nth(int n) {
	    if (n == 0)
	      return this;
	    else if (rest == null)
	      return null;
	    else
	      return rest.nth(n-1);
	  }

	  public void addToEndM(int val) {
	    if (rest != null)
	      // a cell in the middle of the list
	      rest.addToEndM(val);
	    else // the last cell
	      rest = new IntList(val, null);
	  }

	  public IntList reverseM() {
	    return reverseM(null); 
	  }

	  private IntList reverseM(IntList prev) {
	    if (rest == null) {
	      rest = prev;
	      return this;
	    }
	    else {
	      IntList front = rest.reverseM(this);
	      rest = prev;
	      return front;
	    }
	  }

	  public IntList addInorderM(int n) {
	    if (n < value)
	      return new IntList (n, this);
	    else if (n == value)
	      return this;
	    else if (rest == null) {
	      rest = new IntList(n, null);
	      return this;
	    }
	    else {
	      rest = rest.addInorderM(n);
	      return this;
	    }
	  }

	  public IntList remove(int n) {
	    if (value == n)
	      return rest;
	    else if (rest == null)
	      return this;
	    else
	      return new IntList(value, rest.remove(n));
	  }
}
