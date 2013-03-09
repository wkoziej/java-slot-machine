package slotmachine.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * Reprezentacja bębna w automacie jędnorękiego bandyty.
 *
 * @author wojtas
 */
public class Cylinder {

    private ArrayList<Wheel> wheels = new ArrayList<Wheel> (3);

    public void addWheel (Reel reel) {
        wheels.add(new Wheel(reel));
    }
    
    /**
     * Zakręć bębnem
     */
    public void turn() {
        for (Iterator<Wheel> it = wheels.iterator(); it.hasNext();) {
            Wheel wheel = it.next();
            wheel.turn();
        }
    }

    /**
     * Zwróc symbol znajdujący się na i-tej pozcji w zadanym kole.
     *
     * Symbole numerujemy zaczynając od góry. 0 - numer symbolu znajdujący się
     * na samej górze
     */
    public Symbol getSymbol(int wheelNo, int rowNo) {
        if (wheelNo < 0
                || wheelNo >= wheels.size()) {
            throw new RuntimeException("Nieprowidłowy indeks koła (" + wheelNo
                    + ") ");
        }
        Wheel wheel = wheels.get(wheelNo);
        return wheel.getSymbol(rowNo);
    }
}
