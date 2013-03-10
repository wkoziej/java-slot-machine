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
package slotmachine.controller;

import slotmachine.model.Game;
import slotmachine.model.Machine;

/**
 * Zardządca grą.
 *
 * @author wokoziej
 */
public class GameController {

    private Game game;
    private Machine machine;

    public GameController(Machine machine) {
        this.machine = machine;
        game = new Game(machine);
    }

    /**
     * Wrzuć monetę
     */
    public void insertCoin() {
        game.insertCoin();
    }

    /**
     * Pociągnij za ramię.
     *
     * Jeżeli zakład nie był wyższy niż liczba punktów w tej grze - pobierz
     * odpowiednią liczbę punktów z konta - sprawdź czy nowy układ bębna daje
     * nam wygraną - zwiększ konto o wygraną.
     */
    public void play() {
        boolean playing = game.isPlayable();
        if (playing) {
            game.payForRound();
        }
        machine.pullArm();
        if (playing) {
            int coins = game.prizeInCoins();
            if (coins > 0) {
                game.insertCoins(coins);
            }
        }

    }

    @Override
    public String toString() {
        return machine.toString() + "\n" + game.toString();
    }
}
