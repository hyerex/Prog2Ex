package aufgabe9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {


    private class BinarySearchIterator implements Iterator<Integer>{
        List<Integer> liste = new LinkedList();
        private int counter= 0;
        private Node current = root;

        private BinarySearchIterator() {
            auffuellen(root);
        }

        public void auffuellen(Node root) {
            if (root != null) {
                liste.add(root.data);
            }
        }
        @Override
        public boolean hasNext() {
            return (root.left != null || root.right != null);
        }

        @Override
        public Integer next() {
            if (current.left != null) {
                current = current.left;
                return current.data;
            }
            if (current.right != null) {
                current = current.right;
                return current.data;
            } else {
                return 0;
            }
            
        }
    }

    static private class Node {
        int data;
        Node left;
        Node right;
        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    private Node root = null;
    private int size = 0;


    public Iterator<Integer> iterator() {
        return new BinarySearchIterator();
    }


    public void BinarySearchIterator() {
        if (root != null) {


        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("BinarySearchTree: ");
        appendR(s,root);
        s.append(" size = ").append(size);
        return s.toString();
    }

    private static void appendR(StringBuilder s, Node p) {
        if (p != null) {
            appendR(s,p.left);
            s.append(p.data).append(", ");
            appendR(s,p.right);
        }
    }

    public boolean contains(int x) {
        return containsR(x,root);
    }

    private boolean containsR(int x, Node p) {
        if (p == null)
            return false;
        else if (x < p.data)
            return containsR(x,p.left);
        else if (x > p.data)
            return containsR(x,p.right);
        else
            return true;
    }

    public void insert(int x) {
        root = insertR(x,root);
    }

    private Node insertR(int x, Node p) {
        if (p == null) {
            size++;
            return new Node(x);
        }
        if (x < p.data) {
            p.left = insertR(x, p.left);
        } else if (x > p.data) {
            p.right = insertR(x, p.right);
            // im else-Fall ist nicht zu tun; keine doppelten Werte
        }
        return p;
    }

    public void remove(int x) {
        root = removeR(x,root);
    }

    private Node removeR(int x, Node p) {
        if (p == null)
            return null;
        if (x < p.data)
            p.left = removeR(x,p.left);
        else if (x > p.data)
            p.right = removeR(x,p.right);
        else {
            // Knoten loeschen:
            if (p.left == null || p.right == null) {
                // One or no child can be deleted directly:
                size--;
                p = (p.left != null) ? p.left : p.right;
            }
            else {
                // Two children
                p.data = getMin(p.right);
                p.right = removeR(p.data,p.right);
            }
        }
        return p;
    }

    private int getMin(Node p) {
        assert (p != null);
        while(p.left != null)
            p = p.left;
        return p.data;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void prettyPrint(){prettyPrintR(root, "");}

    public void prettyPrintR(Node root, String Ein){
        if(root == null){
            System.out.println(Ein + "#");
        }
        String newEin;
        if(Ein.equals("")) {
            newEin = "|__";
        } else {
            newEin = "    " + Ein;
        }
        if (root != null) {
            System.out.println(Ein + root.data);
            if(root.left != null || root.right != null) {
                prettyPrintR(root.left, newEin);//left Child
                prettyPrintR(root.right, newEin);//right Child
            }
        }
    }

    public int height() {
        if (root != null) {
           return heightR(root, 0);
        } else {
            return 0;
        }
    }

    public static int heightR(Node root, int depth) {
        int leftdepth = depth;
        int rightdepth = depth;
        if (root.left != null) {
            leftdepth = heightR(root.left, depth + 1);
        }
        if (root.right != null) {
            rightdepth = heightR(root.right, depth + 1);
        }
        //System.out.println("heightLeft: " + depth);
        depth = Math.max(leftdepth, rightdepth);
        return depth;
    }

    public int removeMax() {
        if (root != null) {
            return removeMaxR(root, 0);
        }
        return 0;
    }

    public int removeMaxR(Node root, int max) {
        if (root.right != null) {
            removeMaxR(root.right, max);
        } else {
            this.remove(root.data);
            if (root.data > max) {
                max = root.data;
            } else {
                return max;
            }
            this.remove(max);
            return max;
        }
        return 0;
    }


    public static void main(String[] args) {

        BinarySearchTree t2 = new BinarySearchTree();
        t2.insert(5);
        t2.insert(3);
        t2.insert(8);
        t2.insert(1);
        t2.insert(4);
        t2.insert(6);
        t2.insert(7);
        //System.out.println(t2.toString());
        //System.out.println("height: " + t2.height());
        //t2.prettyPrint();
        t2.removeMax();
        System.out.println(t2.toString());
        t2.prettyPrint();


        BinarySearchTree t = new BinarySearchTree();
        int[] a = {7,2,8,1,4,3,6};
        for (int x : a) {
            t.insert(x);
        }


        List<Integer> liste = new LinkedList();

        for (int x : a) {
            liste.add(x);
           //System.out.println(x);
        }

        System.out.println(liste.toString());


    }
}
