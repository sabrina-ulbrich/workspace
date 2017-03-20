public class Test {
	
	public static void tausche1(int a, int b) {
	    int c = a;
	    a = b;
	    b = c;
	}
	public static void tausche2(int[] a) {
	    int c = a[0];
	    a[0] = a[1];
	    a[1] = c;
	}
	public static void tausche3(int[] a) {
	    a[0] = a[1] - a[0];
	    a[1] = a[1] - a[0];
	    a[0] = a[1] + a[0];
	}
	public static void tausche4(int[] a) {
	    int[] c = new int[a.length];
	    c[0] = a[1];
	    c[1] = a[0];
	    for(int i = 2; i < a.length; i++) {
	      c[i] = a[i];
	    }
	    a = c;
	}
	
	// Klassenvariable - static -
	private static int v1 = 10;
	
	// Instanzvariablen
	private int v2 = 20;
	private int v5 = 50;
	
	// Konstante Klassenvariable - final -
	static final int v3 = 30;
	
	// Klassenmethode, die fuer die ganze Klasse gilt (auch wenn es keine Objekte gibt)
	public static void f1() {
		if(--v1 > 0) {
			// v2 = 12;			Fehler: keine Instanzvaribalen in Klassenmethoden verwenden!
			// v3 = 13;			Fehler: Konstanten koennen nicht veraendert werden!
			// this.v4 = 14;	Fehler: this bezieht sich auf gegenwaertiges Objekt!
			f1();
			// f2();			Fehler: keine Instanzmethoden in Klassenmethoden verwenden!
		}
	}
	
	// Instanzmethode, die nur auf einzelne Objekte angewendet werden kann
	public void f2() {
		int v4 = 40;			// lokale Variable
		int v5 = 55;			// lokale Variable mit gleichem Bezeichner (vgl. 1. und 4. Printanweisung)
		if(--v1 > 0) {
			v2 = 22;
			// v3 = 23;			Fehler: Konstanten koennen nicht veraendert werden!
			// this.v4 = 24;	Fehler: eine lokale Variable kann sich nie auf ein Objekt beziehen!
			this.v5 = 25;		// ist oben als Instanzvariable deklariert (this = self in ruby)
			System.out.println("Value of Instance variable v5: " + this.v5);
			System.out.println("Value of Instance variable v2: " + v2);
	        System.out.println("Value of Local variable v4: " + v4);
	        System.out.println("Value of Local variable v5: " + v5);
			//f1();
			//f2();
		}
	}
	
	public static void main(String[] args) {
		
		int a = 3; int b = 5; int z = 0;
		if (a >= b)
		     if (a > 0)
		z = a; 
		     else
		    	 z = b;
		System.out.println(z);
		
		Test obj = new Test(); 
        obj.f2();
		
//		tausche1(-22,38937);
//		int[] k = {2147483647,-2147483648, 34};
//		tausche2(k);
//		tausche3(k);
//		System.out.print("tausche3: " + k[0] + " " + k[1] + " ");
//		tausche4(k);
	}
}
