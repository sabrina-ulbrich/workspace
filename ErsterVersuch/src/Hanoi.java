// *** II.11 Rekursion, Komplexitaet von Algorithmen

public class Hanoi {

  static void bewege (
    int n,            // Anzahl der Scheiben 'n'            
    char start,       // liegen auf 'start'-Platz
    char hilfe,       // (mithilfe des 'hilfe'-Platzes)
    char ziel) {      // muessen auf 'ziel'-Platz  

    if (n == 1)
        System.out.println("  von " + start + " nach " + ziel);
    else {
        bewege(n-1,start, ziel, hilfe);
        System.out.println("  von " + start + " nach " + ziel);
        bewege(n-1,hilfe, start, ziel);
    }
  }

  public static void main (String argv[]) {
    int n;

    System.out.print("Anzahl der Scheiben: "); 
    n = Keyboard.readInt();			// nutzerdefinierte Klasse
    if (n > 0) {
      System.out.println("Scheibenbewegungen: ");
      bewege(n,'A','B','C');
    }
    else
      System.out.println("Zahl nicht positiv");
  }
}