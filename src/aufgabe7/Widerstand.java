package aufgabe7;

public class Widerstand implements Schaltung{

    public Widerstand(int widerstand) {
        this.widerstand = widerstand;
    }
    double widerstand;

    @Override
    public double getWiderstand() {
        return this.widerstand;
    }

    @Override
    public int getAnzahlWiderstaende() {
        return 1;
    }

    @Override
    public void add(Schaltung s) {

    }

    @Override
    public void remove(Schaltung s) {

    }

}
