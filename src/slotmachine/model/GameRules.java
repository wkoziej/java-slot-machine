/*
 * Copyright 2013 wokoziej.
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
 *
 * @author wokoziej
 */
public interface GameRules {

    /**
     * Lista symboli dostępnych w grze.
     */
    Symbol[] availableSymbols();

    /**
     * Przelicznik monet na punkty.
     */
    int coinsToPointFactor();

     /**
     * Liczba płatnych linii w grze.
     */
    public int payLinesCount();
          
    /**
     * Definicja obręczy w grze.
     */ 
    Reel getReel();

    /**
     * Punktacja w grze.
     */
    int payTable(Symbol symbol, int numberOfOccurrences);

    /**
     * Liczba kół, którymi możemy kręcić w grze.
     */
    int slotsNumber();

    /**
     * Ile będzie widoczych wierszy na wyświetlaczu.
     */
    int visibleRows();
    
    /**
     * Definicja płatnej linii o zadanym numerze.
     */
    public boolean[][] payLinesDefinition(int lineNo);
    
    /**
     * Minimalna liczba symboli, dla której można zdobyć punkty.
     */ 
     public int minimumSymbolsCountInLine();
}
