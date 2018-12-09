package aufgabe7b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Person {

    private String name;

    List<Buch> ausgelieheneBuecher = new LinkedList();

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean leihtAus(Buch b) {
        if (b.getEntleiher() != null && b.getEntleiher() != this) {
            return false;
        }
        if (ausgelieheneBuecher.contains(b)) {
            return false;
        }
        ausgelieheneBuecher.add(b);
        return b.wirdAusgeliehen(this);

    }

    public boolean gibtZurueck(Buch b) {
        if (ausgelieheneBuecher.contains(b)) {
            ausgelieheneBuecher.remove(b);
            return b.wirdZurueckGegeben();
        }
        return false;
    }

    public void print() {
        System.out.println(this.name + " ausgeliehene Buecher: ");
        for (Buch b : ausgelieheneBuecher)  {
            System.out.print("  ");
            b.print();
        }

    }

}
