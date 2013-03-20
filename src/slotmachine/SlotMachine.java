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

import slotmachine.model.Symbol;

/**
 *
 * @author wojtas
 */
public class SlotMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Symbol a1 = new Symbol('a', null);
        Symbol a2 = new Symbol('a', false);
        Symbol a3 = a1;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        if (a1.equals(a2)) {
            System.err.println("a1 equals a2");
        }

        if (a1 == a2) {
            System.err.println("a1 == a2");
        }

        if (a1 == a3) {
            System.err.println("a1 == a3");
        }
    }
}
