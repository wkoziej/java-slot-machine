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
     * Ile postawiono monet na każdą linię.
     */
    private int coinsCount;
    /**
     * Reguły wg jakich gramy.
     */
    private final GameRules gameRules;

    /**
     * Domyślne ustawienia dla nowej gry
     */
    public Game(GameRules gameRules) {
        points = 0;
        linesCount = 1;
        coinsCount = 1;
        this.gameRules = gameRules;
    }

    /**
     * Zasil konto gry pojedynczą monetą.
     */
    public void insertCoin() {
        points += gameRules.coinsToPointFactor();
    }

    /**
     * Koszt zakładu wyrażona w punktach.
     */
    public int betCostInPoints() {
        return linesCount * coinsCount * gameRules.coinsToPointFactor();
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
}
