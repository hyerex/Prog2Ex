package aufgabe4;

public class SetApplication {

    public static void main(String[] args) {

        Set l1 = new LinkedListSet();
        Set l2 = new LinkedListSet();
        Set l3 = new LinkedListSet();

        System.out.println();

        System.out.println(l1.add(1));		// true
        System.out.println(l1.add(5));		// true
        System.out.println(l1.add(8));		// true
		System.out.println(l1.add(0));		// true
        System.out.println(l1.add(5));		// false
        System.out.println(l1 + " sortierte Reihenfolge!asdfefe");
		
		System.out.println(l1.remove(5));	// true
		System.out.println(l1.remove(5));	// false
        System.out.println(l1); // {0, 1, 8}

        for (int i = 1; i <= 50; i++)
            l2.add(2*i);
        System.out.println(l2); // {2, 4, 6, ..., 100}

        l3.add(4);
        l3.add(8);

        // Teilmengenbeziehung pruefen:
		System.out.println(l1.containsAll(l2));  // false
        System.out.println(l1.contains(0));	     // true
        System.out.println(l2.containsAll(l3));  // true
		System.out.println(l2.contains(0));     // false
        System.out.println(l2.containsAll(l2));  // true

        Set l4 = new ArraySet();
        for (int i = 1; i <= 40; i++)
            l4.add(5*i);
        System.out.println(l4); // {5, 10, 15, ..., 200}
		l4.remove(200);
		System.out.println(l4); // {5, 10, 15, ..., 195}

        // Vereinigung:
        l2.addAll(l4);
        System.out.println(l2); // {2, 4, 5, 6, ..., 100, 105, ..., 195}

        // Differenzmenge:
        l2.removeAll(l4);
		System.out.println(l2); // {2, 4, 6, 8, 12, ..., 98}
		System.out.println(l4); // {5, 10, 15, ..., 195}
		
		// Leere Menge:
		l2.clear();
		System.out.println(l2); // { }
    }
}
