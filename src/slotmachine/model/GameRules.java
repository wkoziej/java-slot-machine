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

import java.util.HashMap;
import java.util.Map;

/**
 * Zasady i definicja gry w jednorękiego bandytę.
 *
 * @author wojtas
 */
public class GameRules {

    private final Symbol symbols[];
    private final Map<Symbol, int[]> payTable;
    private final boolean payLines[][][];
    private final Reel reel;
    private final Symbol A = new Symbol((char) ('A'), Boolean.FALSE);
    private final Symbol B = new Symbol((char) ('A' + 1), Boolean.FALSE);
    private final Symbol C = new Symbol((char) ('A' + 2), Boolean.FALSE);
    private final Symbol D = new Symbol((char) ('A' + 3), Boolean.FALSE);
    private final Symbol E = new Symbol((char) ('A' + 4), Boolean.FALSE);
    private final Symbol F = new Symbol((char) ('A' + 5), Boolean.FALSE);
    private final Symbol wild = new Symbol((char) ('*'), Boolean.TRUE);

    /**
     *
     */
    public GameRules() {
        // Dostępne symbole
        symbols = new Symbol [] {A, B, C, D, E, F, wild};
        // Płatności za symbole
        payTable = new HashMap<Symbol, int[]>();
       
        int bottom[] = {1, 2, 4};
        int worst[] = {5, 20, 40};
        int worse[] = {10, 30, 100};
        int medium[] = {50, 100, 200};
        int better[] = {100, 200, 400};
        int best[] = {333, 666, 999};
        int zero[] = {0, 0, 0};
        
        payTable.put(A, best);
        payTable.put(B, better);
        payTable.put(C, medium);
        payTable.put(D, worse);
        payTable.put(E, worst);
        payTable.put(F, bottom);
        payTable.put(wild, zero);

        // Definicja płatnych linii        
        payLines = new boolean[][][]{{
                {false, false, false, false, false},
                {true, true, true, true, true},
                {false, false, false, false, false}
            },
            {
                {true, false, false, false, true},
                {false, true, false, true, false},
                {false, false, true, false, false}
            },
            {
                {false, false, true, false, false},
                {false, true, false, true, false},
                {true, false, false, false, true}
            },
            {
                {true, true, true, false, false},
                {false, false, false, true, false},
                {false, false, false, false, true}
            },
            {
                {false, false, false, false, true},
                {false, false, false, true, false},
                {true, true, true, false, false}
            }
        };
       
        Symbol reelSymbols [] = {A, B, C, D, E, F, wild,
                                    B, C, D, E, F, wild,
                                       C, D, E, F, wild,
                                          D, E, F, wild,
                                             E, F, wild,
                                                F};
        reel = new Reel(reelSymbols);
    }

    /**
     * Liczba kół, którymi możemy kręcić w grze.
     */
    public int slotsNumber() {
        return 5;
    }

    /**
     * Ile będzie widoczych wierszy na wyświetlaczu. 
     */
    public int visibleRows() {
        return 3;
    }
    
    /**
     * Przelicznik monet na punkty.
     */
    public int coinsToPointFactor() {
        return 5;
    }

    /**
     * Maksymalna stawka (w monetach) dla kolejki.
     */
    public int maxCoinsInRound() {
        return 5;
    }

    /**
     * Lista symboli dostępnych w grze.
     */
    public Symbol[] availableSymbols() {
        return symbols;
    }

    public Reel getReel() {
        return reel;
    }

    /**
     * Punktacja w grze.
     */
    public int payTable(Symbol symbol, int numberOfOccurrences) {
        if (numberOfOccurrences < 3
                || numberOfOccurrences > slotsNumber()
                || symbol.isWild()) {
            return 0;
        }
        // 3 <= numberOfOccurence <= 5
        return payTable.get(symbol)[numberOfOccurrences - 3];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // Dostępne symbole
        stringBuilder.append("Symbols: {");
        for (int i = 0; i < symbols.length; i++) {
            Symbol symbol = symbols[i];
            stringBuilder.append(symbol).append(' ');
        }
        stringBuilder.append("}\n");
        // Płatności
        stringBuilder.append("PayTable: {\n");
        stringBuilder.append("\t").append("\tx3").append("\tx4").append("\tx5\n");
        for (int i = 0; i < symbols.length; i++) {
            Symbol symbol = symbols[i];
            int[] symbolPayTable = payTable.get(symbol);
            stringBuilder.append("\t").append(symbol).append(" = ");
            for (int j = 0; j < symbolPayTable.length; j++) {
                int k = symbolPayTable[j];
                stringBuilder.append("\t").append(k);
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("}\n");
        stringBuilder.append("PayLines: \n");
        for (int i = 0; i < payLines.length; i++) {
            stringBuilder.append("#").append(i).append("\t");
            boolean payLineDefinition[][] = payLines[i];
            for (int j = 0; j < payLineDefinition.length; j++) {
                boolean[] row = payLineDefinition[j];
                for (int k = 0; k < row.length; k++) {
                    boolean b = row[k];
                    stringBuilder.append(b ? "X" : "0");
                }
                stringBuilder.append("\n\t");
            }
            stringBuilder.append("\n");
        }
        // Dostępne symbole
        stringBuilder.append("Reel: {");
        for (int i = 0; i < reel.getSize(); i++) {
            Symbol symbol = reel.getSymbolAt(i);
            stringBuilder.append(symbol).append(' ');
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
