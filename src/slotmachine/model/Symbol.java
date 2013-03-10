/*
 * Copyright 2013 wojtas.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    @Override
    public String toString() {
        return representation.toString();
    }
    
    
}
