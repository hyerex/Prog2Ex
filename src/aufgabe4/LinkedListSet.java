package aufgabe4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListSet<T> extends AbstractSet<T> {

    public LinkedListSet() {
        clear();
    }

    public final void clear() {
        head = new Node<T>(null, null);
        size = 0;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    static private class Node<T> {
        Node<T> next;
        T data;
        Node(T x, Node<T> p) {
            data = x;
            next = p;
        }
    }

    private Node<T> head;
    private int size;
    private int modCount = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T x) {

        if (head == null) {
            head = new Node<T>(x, head);
            size++;
            modCount++;
            return true;
        }
        if (!contains(x)) {
            Node<T> p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node<T>(x, p.next);
            size++;
            modCount++;
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean remove(Object x) {
        Node p = head;
        if (contains(x)) {

            while (p.next != null && p.next.data != x) {
                p = p.next;
            } p.next = p.next.next;
            return true;
        }
        return false;

    }

    @Override
    public boolean contains(Object x) {
        for (Node<T> p = head.next; p != null; p = p.next) {
            if (p.data.equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> p = head.next;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        return p.data;
    }


    @Override
    public String toString() {
            StringBuilder s = new StringBuilder("");
            for (Node p = head.next; p != null; p = p.next) {
                s.append(p.data).append(", ");
            }
            return s.toString();
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> current = head;
        private int expectedMod = modCount;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            if (expectedMod != modCount) {
                throw new ConcurrentModificationException();
            } else if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = current.next;
            return current.data;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}


