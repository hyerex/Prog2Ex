package aufgabe7;

public class Reihenschaltung extends ZusammengesetzteSchaltung {

    @Override
    public double getWiderstand() {
        double omega = 0;
        for(Schaltung s : schaltung){
            omega = omega + s.getWiderstand();
        }
        return omega;

    }
}
