
public class PolyTest {
	static void out(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		Derived d = new Derived();
		out( d.s );
		Base b = d;
		out( b.s ); 
	    out( d.s() );
	    out( b.s() );
	    out( d.t() );
		out( b.t() );
	}
}
