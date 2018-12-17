package aufgabe8;

public class RangeSearch {

    public static void main(String[] args) {
        Integer[] a = {0, 2, 2, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 9, 10, 11};
        System.out.println(rangeSearch(a, 2, 6)); // 8
        System.out.println(rangeSearch(a, 1, 6)); // 8
        System.out.println(rangeSearch(a, 3, 6)); // 3

        System.out.println(rangeSearch(a, 2, 8)); // 12
        System.out.println(rangeSearch(a, 2, 9)); // 12

        System.out.println(rangeSearch(a, 0, 9)); // 13
        System.out.println(rangeSearch(a, -1, 9)); // 13

        System.out.println(rangeSearch(a, 3, 11)); // 9
        System.out.println(rangeSearch(a, 3, 15)); // 10

        /**
         * Laufzeitmessung
         **/
        int n = 100000; //Groesse
        Integer[] b = new Integer[n];   //Feld deklarieren
        for (int i = 0; i < n; i++) {
            b[i] = (int) (Math.random() * 1000);
        }
        //Generische Sortiermethode aus java.util.Arrays
        long start = System.nanoTime();
        java.util.Arrays.sort(b);
        long end = System.nanoTime();
        double elapsedTime = (double) (end - start) / 1.0e06;    //Zeit in msec
        System.out.println("Elapsed time (java.util.Arrays.sort()) in " + elapsedTime + " msec");

        //Testen von rangeSearch mit Array der Groesse n = 100_000
        System.out.println("Test von rangeSearch: "
                + rangeSearch(b, 250, 750));

        //sortiertem Feld unsere Sortiermethode
        java.util.Arrays.sort(b);

        //sortierem Feld Java.utils.Arrays

        long start4 = System.nanoTime();
        java.util.Arrays.sort(b);
        long end4 = System.nanoTime();
        double elapsedTime4 = (double) (end4 - start4) / 1.0e06;
        System.out.println("Elapsed time (java.util.Arrays.sort() (sortiertes Feld)) in " + elapsedTime4 + " msec");

    }

    public static <T extends Comparable<? super T>> int rangeSearch(T[] a, T u, T v) {
        assert isSorted(a);
        int li = binarySearch(a, a.length - 1, u);
        int re = binarySearch(a, a.length - 1, v);
        return re - li;
    }

    private static <T extends Comparable<? super T>> int binarySearch(T[] a, int li, int re, T x) {

        if (re < li)
            return li;
        else {
            int m = (li + re) / 2;
            if (x.compareTo(a[m]) < 0)
                return binarySearch(a, li, m - 1, x);
            else if (x.compareTo(a[m]) > 0)
                return binarySearch(a, m + 1, re, x);
            else
                return m;
        }
    }


    private static <T extends Comparable<? super T>> int binarySearch(T[] a, int re, T x) {

        int m = binarySearch(a, 0, re, x);
        if (m > 0 && m <= re && a[m - 1].compareTo(a[m]) == 0) {
            m = binarySearch(a, m - 1, x);
        }
        return m;
    }

    private static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        for (int i = 0; i < a.length-1; i++)
            if (a[i+1].compareTo(a[i]) < 0)
                return false;
        return true;
    }
}
