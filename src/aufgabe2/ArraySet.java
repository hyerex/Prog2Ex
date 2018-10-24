package aufgabe2;


public class ArraySet extends AbstractSet {

    public ArraySet() {
        size = 0;
        data = new int[8];
    }

    private int size;
    private static final int defaultCapaciy = 8;
    private int[] data;

    public final void clear() {
        int[] nullArray = null;
        data = nullArray;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(int x) {
        for (int i = 0; i < size; i++) {
            if (data[i] == x) {
                return true;
            }
        } return false;
    }

    public int get(int i) throws IndexOutOfBoundsException {

        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();

        }
        return data[i];

    }

    public boolean add(int x) {
        if(size == data.length) {
            ensureCapacity(size * 2);
        }

        if(!contains(x)) {
            insert(x);
            size++;
            return true;
        } else {
            return false;
        }
    }

    private void insert(int x) {
        if(size == 0){
            data[0] = x;
            return;
        }
        for (int i = 0; i <= size; i++) {
            if(data[i] > x || i == size){
                System.arraycopy(data, i, data, i +1, size - i);
                data[i] = x;
                return;
            }
        }
    }

    public boolean remove(int x) {

        if (this.contains(x)) {
            if(size > 0) {
                size--;
            } else {
                size = 0;
            }



            for(int i = 0; i < size(); i++) {
                if(data[i] == x) {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
        return false;
    }


    //Methode ensureCapacity verdoppelt das Feld
    private void ensureCapacity(int newCapacity) {

        if (newCapacity < size) {
            return;
        } else {
            int[] old = data;
            data = new int[newCapacity];
            System.arraycopy(old, 0, data, 0, size);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            s.append(data[i]).append(", ");
        }
        return s.toString();
    }
}
