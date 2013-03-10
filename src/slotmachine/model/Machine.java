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
 * Klasa reprezentująca maszynę do gry w jędnorękiego bandytę.
 *
 * @author wojtas
 */
public class Machine {

    private final Cylinder cylinder = new Cylinder();
    private final GameRules gameRules;
    
    public Machine (GameRules gameRules) {
        this.gameRules = gameRules;
        Reel reel = gameRules.getReel();
        int slotsNumber = gameRules.slotsNumber();
        for (int i = 0; i < slotsNumber; i++) {
            Wheel wheel = new Wheel(reel);
            cylinder.addWheel(reel);
        } 
    }

    public void pullArm () {
        cylinder.turn();
    }

    Symbol [][] symbolsOnScreen () {
        final int visibleRows = gameRules.visibleRows();
        final int slotsNumber = gameRules.slotsNumber();
        Symbol [][] screenSymbols = new Symbol [visibleRows][slotsNumber];
        for (int i = 0; i < visibleRows; i++) {
            for (int j = 0; j < slotsNumber; j++) {
                screenSymbols [i][j] = cylinder.getSymbol(j, i);
            }
        }
        return screenSymbols;
    }
    
    @Override
    public String toString() {
        Symbol[][] symbols = symbolsOnScreen();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < symbols.length; i++) {
            Symbol[] symbols1 = symbols[i];
            for (int j = 0; j < symbols1.length; j++) {
                Symbol symbol = symbols1[j];
                builder.append(symbol);
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    
}
