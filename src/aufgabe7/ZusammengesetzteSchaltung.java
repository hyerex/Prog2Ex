package aufgabe7;

import java.util.ArrayList;
import java.util.List;

public abstract class ZusammengesetzteSchaltung implements Schaltung{

    List<Schaltung> schaltung = new ArrayList<>();

    public int getAnzahlWiderstaende(){
        int anzahl = 0;
        for(Schaltung s : schaltung){
            anzahl = anzahl + s.getAnzahlWiderstaende();
        }
        return anzahl;
    }

    public void add(Schaltung s){
        schaltung.add(s);
    }

    public void remove(Schaltung s){
        schaltung.remove(s);
    }


    public static void main(String[] args) {

        Schaltung ps1 = new Parallelschaltung();
        ps1.add(new Widerstand(400));
        ps1.add(new Widerstand(100));

        Schaltung ps2 = new Parallelschaltung();
        ps2.add(new Widerstand(200));
        ps2.add(new Widerstand(600));
        ps2.add(new Widerstand(300));

        Schaltung rs = new Reihenschaltung();
        rs.add(ps1);
        rs.add(ps2);
        rs.add(new Widerstand(120));

        System.out.println(rs.getWiderstand()); // 300
        System.out.println(rs.getAnzahlWiderstaende()); // 6
    }
}
