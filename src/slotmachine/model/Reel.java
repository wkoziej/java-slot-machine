package slotmachine.model;

/**
 * Reprezentacja obręczy z symbolami na kole w automacie jednorękiego bandyty.
 *
 * @author wojtas
 */
public class Reel {

    private final Symbol symbols[];

    private Reel() {
        symbols = null;
    }

    public Reel(Symbol init[]) {
        if (init != null) {
            symbols = new Symbol[init.length];
            System.arraycopy(init, 0, symbols, 0, init.length);
        } else {
            symbols = null;
        }
    }

    public int getSize() {
        return symbols == null ? 0 : symbols.length;
    }
    
    public Symbol getSymbolAt (int symbolIndex) {
        return symbols [symbolIndex];
    }
    // TODO: zaimplementować equals i hashCode oraz ich testy
}
