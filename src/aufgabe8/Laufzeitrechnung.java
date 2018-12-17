package aufgabe8;

import java.util.Arrays;

public class Laufzeitrechnung {

    public static void main(String[] args) {
        int n = 1000;
        int m = 5000;
        Integer[] a = new Integer[n];
        for(int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random()*m);
        }
        test2(a, 0, n-1);
    }

    private static <T extends Comparable<? super T>> void test(Integer[] a, int li, int re) {

        Integer[] b = new Integer[a.length];
        Integer[] c = new Integer[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        System.arraycopy(a, 0, c,   0, a.length);

        long time1 = System.nanoTime();
        Quicksort.sort(a, li, re);
        time1 = System.nanoTime() - time1;

        long time2 = System.nanoTime();
        QuicksortMedian.sort(b, li, re);
        time2 = System.nanoTime() - time2;

        long time3 = System.nanoTime();
        Arrays.sort(c);
        time3 = System.nanoTime() - time3;


        System.out.println("Hybrid: " + time1/1E6 + "ms");
        System.out.println("Median: " + time2/1E6 + "ms");
        System.out.println("ArrayS: " + time3/1E6 + "ms");

    }

    private static <T extends Comparable<? super T>> void test2(Integer[] a, int li, int re) {

        Integer[] b = new Integer[a.length];
        Integer[] c = new Integer[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        System.arraycopy(a, 0, c,   0, a.length);

        long start = System.nanoTime();
        Quicksort.sort(a, li, re);
        long end = System.nanoTime();

        long start1 = System.nanoTime();
        QuicksortMedian.sort(b, li, re);
        long end1 = System.nanoTime();

        double elapsedTime = (double) (end - start)/1.0e06;
        System.out.println(" Elapsed Sort time in " + elapsedTime + " msec");
        double elapsedTime1 = (double) (end1 - start1)/1.0e06;
        System.out.println(" Elapsed Median time in " + elapsedTime1 + " msec");


    }

}
