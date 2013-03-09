package slotmachine.model;

/**
 * Model klasy reprezentującej symbol w grze jędnoręki bandyta.
 *
 * @author wojtas
 */
public class Symbol {
    // Jak prezentowany będzie symbol

    private final Character representation;
    // Czy może zastąpić dowolny inny
    private final Boolean wild;

    private Symbol() {
        representation = Character.MIN_VALUE;
        wild = Boolean.FALSE;
    }

    public Symbol(Character represetation, Boolean wild) {
        this.representation = represetation;
        this.wild = wild;
    }

    /**
     * Jeżeli symbol reprezentować może dowlolny (jest "wild") to zwracamy true
     * W przeciwnym razie zwracamy true, jeżeli reprezentacje są równe.
     *
     * @param object
     * @return true jeżeli isWild()==true, poza
     * getRepresentaion().equals(representaion)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Symbol)) {
            return false;
        }
        Symbol symbol = (Symbol) object;
        if (isWild() || symbol.isWild()) {
            return true;
        } else {
            return representation.equals(symbol.representation);
        }
    }

    public Boolean isWild() {
        return wild;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.representation != null ? this.representation.hashCode() : 0);
        hash = 47 * hash + (this.wild != null ? this.wild.hashCode() : 0);
        return hash;
    }
}
