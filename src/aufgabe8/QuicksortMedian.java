package aufgabe8;

public class QuicksortMedian {
    public static <T extends Comparable<T>> void sort(T[] array, int li, int re) {
        if (li < re) {
            //Wenn Feldgroeße kleiner 100 benutze InsertionSort
            if ((re - li) < 100) {
                insertionSort(array, li, re + 1);
            } else {
                //Teilschritt:
                int part = partition(array, li, re);
                //Herrscheschritt:
                sort(array, li, part - 1);//linke Teilliste sortieren
                sort(array, part + 1, re);//rechte Teilliste sortieren
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] array, int li, int re) {
        for (int i = li + 1; i < re; i++) {
            T v = array[i];
            int j = i - 1;
            while (j >= 0 && v.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = v;
        }
    }



    private static <T extends Comparable<T>> int partition(T[] array, int li, int re) {

        T pivot = median(array[li], array[(li + re) / 2], array[re]);

        T left = array[li];
        T right = array[re - 1];
        T tmp;
        int i= li + 1;
        while (li < re)  {
            if (left.compareTo(pivot) < 0) {
                li++;
            }
            if (right.compareTo(pivot) > 0) {
                re--;
            } else {

                tmp = left;
                left = right;
                right = tmp;
            }
        }
        return i;
    }

    public static <T extends Comparable<T>> T median(T pivot1, T pivot2, T pivot3) {
        T tmp;

        if (pivot1.compareTo(pivot3) < 0) {
            tmp = pivot1;
            pivot1 = pivot3;
            pivot3 = tmp;
        }
        if (pivot1.compareTo(pivot2) > 0) {
            tmp = pivot1;
            pivot1 = pivot2;
            pivot2 = tmp;
        }

        if (pivot2.compareTo(pivot3) > 0) {
            tmp = pivot2;
            pivot2 = pivot3;
            pivot3 = tmp;
        }


        return pivot2;
    }

    public static void main(String[] args0) {
        Integer[] array = {1, 4, 6, 2, 10, 50, 82, 1, 20, 2, 3};
        sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
