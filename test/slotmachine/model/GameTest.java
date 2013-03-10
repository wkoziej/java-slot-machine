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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wokoziej
 */
public class GameTest {

    final GameRules gameRules = new GameRules();

    public GameTest() {
    }

    /**
     * Test of insertCoin method, of class Game.
     */
    @Test
    public void testInsertCoin() {
        System.out.println("insertCoin");
        Game instance = new Game(gameRules);
        instance.insertCoin();
        int gamePoints = instance.accountPoints();
        assertEquals(gamePoints, gameRules.coinsToPointFactor());
    }

    /**
     * Test of betCostInPoints method, of class Game.
     */
    @Test
    public void testBetCostInPoints() {
        System.out.println("betCostInPoints");
        Game game = new Game(gameRules);
        int expResult = gameRules.coinsToPointFactor(); // jedna linia i jedna moneta domyślnie w nowej grze
        int result = game.betCostInPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPlayable method, of class Game.
     */
    @Test
    public void testIsPlayable() {
        System.out.println("isPlayable");
        Game instance = new Game(gameRules);
        boolean expResult = false;
        boolean result = instance.isPlayable();
        assertEquals(expResult, result);
    }

    /**
     * Test of payForRound method, of class Game.
     */
    @Test
    public void testPayForRound() {
        System.out.println("payForRound");
        Game game = new Game(gameRules);
        game.payForRound();
        final int accountPoints = game.accountPoints();
        assertEquals(0, accountPoints);
    }
}