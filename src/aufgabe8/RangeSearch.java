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
    }

    public static <T extends Comparable<? super T>> int rangeSearch(T[] a, T u, T v) {
        // Ihr Code:
        // ...

        return 0;   // damit IDE kein Sysntaxfehler anzeigt.
    }

    private static <T extends Comparable<? super T>> int binarySearch(T[] a, int li, int re, T x) {
        // Ihr Code:
        //
        return 0;   // damit IDE kein Sysntaxfehler anzeigt.
    }
}
