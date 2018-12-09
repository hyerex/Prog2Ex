package aufgabe7;

public interface Schaltung {

    double getWiderstand();

    int getAnzahlWiderstaende();

    void add(Schaltung s);

    void remove(Schaltung s);
}
