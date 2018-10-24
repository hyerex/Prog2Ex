package aufgabe2;

public class LinkedListSet extends AbstractSet {

    public LinkedListSet() {
        clear();
    }

    public final void clear() {
        head = new Node(0, null);
        size = 0;
    }

    static private class Node {
        Node next;
        int data;
        Node(int x, Node p) {
            data = x;
            next = p;
        }
    }

    private Node head;

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(int x) {

        if (head == null || x <= head.data) {
            head = new Node(x, head);
            size++;
            return true;
        } else {
            if (!contains(x)) {
                Node p = head;
                while (p.next != null && p.next.data < x) {
                    p = p.next;
                }
                p.next = new Node(x, p.next);
                size++;
                return true;
            }
            return false;
        }

    }


    @Override
    public boolean remove(int x) {
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
    public boolean contains(int x) {
        Node p;
        for (p = head.next; p != null; p = p.next) {
            if (p.data == x) break;
        }

        if (p != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node p = head.next;
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
}
