// O. Bittel;
// 19.04.2018

package aufgabe4;

public class GenSetApplication {

    public static void main(String[] args) {
    	
		// Testen von add und contains:
		System.out.println("***** Testen von add und contains und Iterator *****");
    	Set<Number> numArrSet = new ArraySet<>();
    	Set<Integer> intArrSet = new ArraySet<>();
    	Set<String> strArrSet = new ArraySet<>();
		
		Set<Number> numLLSet = new LinkedListSet<>();
    	Set<Integer> intLLSet = new LinkedListSet<>();
    	Set<String> strLLSet = new LinkedListSet<>();
    	
    	numArrSet.add(4.0);
    	numArrSet.add(50);
    	numArrSet.add(12.995);
    	
    	for (Number n : numArrSet)
    		System.out.print(n + ", ");
    	System.out.println("-----------");

		System.out.println("-------------------------");
		numLLSet.add(4.0);
    	numLLSet.add(50);
    	numLLSet.add(12.995);
    	
    	for (Number n : numLLSet)
    		System.out.print(n + ", ");
    	System.out.println();
    	
    	intArrSet.add(2);
    	intArrSet.add(40080);
    	intArrSet.add(69874);
    	intArrSet.add(2);
		intLLSet.add(2);
    	intLLSet.add(40080);
    	intLLSet.add(69874);
    	intLLSet.add(2);
    	
    	strArrSet.add("Hallo");
    	strArrSet.add("Welt");
    	strArrSet.add("123");
		strLLSet.add("Hallo");
    	strLLSet.add("Welt");
    	strLLSet.add("123");



    	System.out.println(numArrSet.toString());
		System.out.println(numLLSet.toString());
    	System.out.println(intArrSet.toString());
		System.out.println(intLLSet.toString());
		System.out.println("OOOOOOOOOOOOOOO");
    	System.out.println(strArrSet.toString());
		System.out.println("AAAAAAAAAAAAÖAAAAAAAA");
		System.out.println(strLLSet.toString());
    	
    	System.out.println(numArrSet.contains(4.0));
		System.out.println(numLLSet.contains(4.0));
		System.out.println(intArrSet.contains(2));
		System.out.println(intLLSet.contains(2));
		System.out.println(intArrSet.contains(40080));
		System.out.println(intLLSet.contains(40080));
		System.out.println(strArrSet.contains("123"));
		System.out.println(strLLSet.contains("123"));
		
		
		// Testen von addAll:
		System.out.println("***** Testen von addAll *****");
		Set<Integer> intArrSet2 = new ArraySet<>();
		intArrSet2.add(2);
		intArrSet2.add(3);
		intArrSet2.add(50);
		intArrSet2.addAll(intLLSet);
		System.out.println(intArrSet2.toString());
		
		numLLSet.addAll(intArrSet2);
		System.out.println(numLLSet.toString());
		
		Set<Object> objArrSet = new ArraySet<>();
		objArrSet.addAll(numLLSet);
		objArrSet.addAll(intLLSet);
		objArrSet.addAll(strLLSet);
		System.out.println(objArrSet.toString());
		
		// Testen von containsAll:
		System.out.println("***** Testen von containsAll *****");
		System.out.println(objArrSet.containsAll(numArrSet));
		System.out.println(numArrSet.containsAll(objArrSet));
		
		// Test von removeAll:
		System.out.println("***** Testen von removeAll *****");
		System.out.println(intArrSet2.toString());
		System.out.println(numArrSet.toString());
		intArrSet2.removeAll(numArrSet);
		System.out.println(intArrSet2.toString());
    }

}