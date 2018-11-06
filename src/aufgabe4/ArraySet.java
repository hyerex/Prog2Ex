package aufgabe4;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> extends AbstractSet<T> {

    @SuppressWarnings("unchecked")
    public ArraySet() {
        size = 0;
        data = (T[]) new Object[8];
    }

    private int size;
    private T[] data;
    private int modCount = 0;

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        T[] old = data;
        data = (T[]) new Object[newCapacity];
        System.arraycopy(old, 0, data, 0, size);
    }

    public final void clear() {
        data = null;
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

    public boolean contains(Object x) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(x)) {
                return true;
            }
        } return false;
    }

    public T get(int i) throws IndexOutOfBoundsException {

        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();

        }
        return data[i];

    }

    public boolean add(T x) {
        if (size == data.length) {
            ensureCapacity(size * 2);
        }
        if(!contains(x)) {
            insert(x);
            size++;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    private void insert(T x) {
        if(size == 0){
            data[0] = x;
            return;
        } else {
            data[size] = x;
            return;
        }
    }

    public boolean remove(Object x) {

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


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            s.append(data[i]).append(", ");
        }
        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {

        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {

        private int current = 0;
        private int expectedMod = modCount;

        @Override
        public boolean hasNext() {
            if (data[current + 1] != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            if (expectedMod != modCount) {
                throw new ConcurrentModificationException();
            } else if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current++;
            return data[current];
        }
    }


}
