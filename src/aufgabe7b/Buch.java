package aufgabe7b;

public class Buch {

    private String name;
    private Person entleiher;

    public Buch(String name) {
        this.name = name;
        this.entleiher = null;
    }

    public String getName() {
        return this.name;
    }

    public Person getEntleiher() {
        return this.entleiher;
    }

    public boolean wirdAusgeliehen(Person p) {
        if (this.getEntleiher() != null) {
            return false;
        }
        p.leihtAus(this);
        this.entleiher = p;
        return true;
    }

    public boolean wirdZurueckGegeben() {
        if (this.entleiher == null) {
            return false;
        }
        this.entleiher.gibtZurueck(this);
        this.entleiher = null;
        return true;
    }

    public void print() {
        System.out.println(this.name);
    }
}
