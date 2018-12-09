package aufgabe7;

public class Parallelschaltung extends ZusammengesetzteSchaltung {

    @Override
    public double getWiderstand() {
        double omega = 0;
        for(Schaltung s : schaltung){
            omega = omega + 1/s.getWiderstand();
        }
        return 1/omega;
    }

}
