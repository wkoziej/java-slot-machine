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
package slotmachine;

import slotmachine.controller.GameController;
import slotmachine.model.SimplestGameRules;
import slotmachine.model.Machine;
import slotmachine.view.MainFrame;

/**
 *
 * @author wojtas
 */
public class SlotMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final SimplestGameRules gameRules = new SimplestGameRules();
        final Machine machine = new Machine(gameRules);
        //machine.pullArm();
        final GameController gameController = new GameController(machine);
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(gameController).setVisible(true);
            }
        });
        
        /*
        final SimplestGameRules gameRules = new SimplestGameRules();
        System.out.println(gameRules);

        Machine machine = new Machine(gameRules);
        System.out.println(machine);

        GameController gameController = new GameController(machine);

        for (int i = 0; i < 10; i++) {
            gameController.insertCoin();
            gameController.play();
            System.out.println(gameController);
        }
        */
    }
}
