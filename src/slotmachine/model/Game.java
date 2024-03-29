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

import java.util.Map;

/**
 *
 * @author wokoziej
 */
public class Game {

    /**
     * Stan konta.
     */
    private int points;
    /**
     * Liczba wybranych płatnych linii.
     */
    private int linesCount;
    /**
     * Ile postawiono na każdą linię.
     */
    private int lineBet;
    /**
     * Reguły wg jakich gramy.
     */
    private final Machine machine;

    /**
     * Domyślne ustawienia dla nowej gry
     */
    public Game(Machine machine) {
        points = 0;
        linesCount = 1;
        lineBet = 1;
        this.machine = machine;
    }

    /**
     * Zasil konto gry pojedynczą monetą.
     */
    public void insertCoin() {
        insertCoins(1);
    }

    /**
     * Zasil konto gry zadaną liczbą monet monetą.
     */
    public void insertCoins(int coins) {
        points += coins * machine.gameRules().coinsToPointFactor();
    }

    /**
     * Koszt zakładu wyrażona w punktach.
     */
    public int betCostInPoints() {
        return linesCount * lineBet;
    }

    /**
     * Możliwość uruchomienia gry = czy nasza liczba punktów jest wystarczająca,
     * by obstawić taki zakład.
     */
    public boolean isPlayable() {
        return points >= betCostInPoints();
    }

    /**
     * Pobierz z konta liczbę punktów odpowiadającą zakładowi.
     */
    public void payForRound() {
        final int betCostInPoints = betCostInPoints();
        if (betCostInPoints <= points) {
            points -= betCostInPoints;
        }
    }

    /**
     * Liczba punktów/kredytów jakimi dysponujemy w tej grze.
     */
    public int accountPoints() {
        return points;
    }

    /**
     * Uwzględniając - wysokość zakładu (płatność za linię) w punktach - tabelę
     * płatności za poszczególne symbole - obstawioną liczbę linii i ich
     * definicję wylicz wartość wygranej i zwróć jej wielkość w punktach
     */
    public int prizeInPoints() {
        GameRules gameRules = machine.gameRules();
        int prize = 0;
        for (int i = 0; i < linesCount; i++) {
            Map<Symbol, Integer> symbolsOnLine = machine.countSymbolsOnLine(i);
            for (Map.Entry<Symbol, Integer> currentSymbol : symbolsOnLine.entrySet()) {
                Symbol symbol = currentSymbol.getKey();
                Integer occurrences = currentSymbol.getValue();
                prize += gameRules.payTable(symbol, occurrences);
            }
        }
        return prize * lineBet;
    }

    /**
     * Uwzględniając - wysokość zakładu (płatność za linię) w punktach - tabelę
     * płatności za poszczególne symbole - obstawioną liczbę linii i ich
     * definicję wylicz wartość wygranej i zwróć ją przeliczając na monety
     */
    public int prizeInCoins() {
        GameRules gameRules = machine.gameRules();
        return prizeInPoints() / gameRules.coinsToPointFactor();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Game {").append("points = ").append(points).
                append(", linesCount = ").append(linesCount).
                append(", lineBet = ").append(lineBet).
                append(", bet = ").append(betCostInPoints()).append(" }");
        return builder.toString();
    }

    public void setPayLinesCount(int intValue) {
        linesCount = intValue;
    }

    public void setLineBet(int intValue) {
        lineBet = intValue;
    }

    public void addPoints(int intValue) {
        points += intValue;
    }
}
