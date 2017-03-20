
/**
 * Algorithmen und Datenstrukturen Blatt 08 Aufgabe 3
 * (C) HU Berlin, Andre Koschmieder
 *
 * This class contains test cases for the Fibonacci Heap
 * implementation. A correct implementation gives the following output:
 *
 * $ java FibHeapTest
 * *** Testcase 1 ***
 * * FibHeap is EMPTY.
 * * FibHeap content:
 * - 33 
 * * FibHeap content:
 * - 22 
 * \ 33 
 * * FibHeap content:
 * - 22 
 * \ 33 
 * \ 25 
 * \ 66 
 * \ 40 
 * \ 77 
 * \ 38 
 * \ 50 
 * \ 23 
 * *** ExtractMin: 22
 * * FibHeap content:
 * - 23 - 25 - 66 
 *      \ 33 
 *      \ 38 - 40 - 77 
 *           \ 50 
 * *** ExtractMin: 23
 * * FibHeap content:
 * - 25 - 66 
 * \ 33 
 * \ 38 - 40 - 77 
 *      \ 50 
 * *** ExtractMin: 25
 * * FibHeap content:
 * - 33 - 66 
 * \ 38 - 40 - 77 
 *      \ 50 
 * 
 * *** Testcase 2 ***
 * * FibHeap content:
 * - 23 - 25 - 66 
 *      \ 33 
 *      \ 38 - 40 - 77 
 *           \ 50 
 * *** DecreaseKey: 77 -> 41
 * * FibHeap content:
 * - 23 - 25 - 66 
 *      \ 33 
 *      \ 38 - 40 - 41 
 *           \ 50 
 * *** DecreaseKey: 50 -> 24
 * * FibHeap content:
 * - 23 - 25 - 66 
 *      \ 33 
 *      \ 38*- 40 - 41 
 * \ 24 
 * *** DecreaseKey: 40 -> 20
 * * FibHeap content:
 * - 20 - 41 
 * \ 23 - 25 - 66 
 *      \ 33 
 * \ 24 
 * \ 38 
 * *** ExtractMin: 20
 * * FibHeap content:
 * - 23 - 25 - 66 
 *      \ 33 
 * \ 24 - 38 
 * \ 41 
 */
public class FibHeapTest
{
	public static void main(String []args)
	{
		System.out.println("*** Testcase 1 ***");
		FibHeap<Integer> fib1 = new FibHeap<Integer>();
		fib1.print();
		fib1.add(33);
		fib1.print();
		fib1.add(22);
		fib1.print();
		addMulti(fib1,new int[]{25,66,40,77,38,50,23});
		fib1.print();
		FibHeap.Node<Integer> res = fib1.extractMin();
		System.out.println("*** ExtractMin: "+res.getData());
		fib1.print();
		res = fib1.extractMin();
		System.out.println("*** ExtractMin: "+res.getData());
		fib1.print();
		res = fib1.extractMin();
		System.out.println("*** ExtractMin: "+res.getData());
		fib1.print();

		System.out.println("\n*** Testcase 2 ***");
		FibHeap<Integer> fib2 = new FibHeap<Integer>();
		fib2.add(33);
		fib2.add(22);
		fib2.add(25);
		fib2.add(66);
		FibHeap.Node<Integer> n40 = fib2.add(40);
		FibHeap.Node<Integer> n77 = fib2.add(77);
		fib2.add(38);
		FibHeap.Node<Integer> n50 = fib2.add(50);
		fib2.add(23);
		fib2.extractMin();
		fib2.print();
		System.out.println("*** DecreaseKey: 77 -> 41");
		fib2.decreaseKey(n77,41);
		fib2.print();
		System.out.println("*** DecreaseKey: 50 -> 24");
		fib2.decreaseKey(n50,24);
		fib2.print();
		System.out.println("*** DecreaseKey: 40 -> 20");
		fib2.decreaseKey(n40,20);
		fib2.print();
		res = fib2.extractMin();
		System.out.println("*** ExtractMin: "+res.getData());
		fib2.print();
	}

	private static void addMulti(FibHeap<Integer> fib,int[] data)
	{
		for (int i: data) fib.add(i);
	}
}