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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Reprezentacja bębna w automacie jędnorękiego bandyty.
 *
 * @author wojtas
 */
public class Cylinder {

    private ArrayList<Wheel> wheels = new ArrayList<Wheel> (3);

    public void addWheel (Reel reel) {
        wheels.add(new Wheel(reel));
    }
    
    /**
     * Zakręć bębnem
     */
    public void turn() {
        for (Iterator<Wheel> it = wheels.iterator(); it.hasNext();) {
            Wheel wheel = it.next();
            wheel.turn();
        }
    }

    /**
     * Zwróc symbol znajdujący się na i-tej pozcji w zadanym kole.
     *
     * Symbole numerujemy zaczynając od góry. 0 - numer symbolu znajdujący się
     * na samej górze
     */
    public Symbol getSymbol(int wheelNo, int rowNo) {
        if (wheelNo < 0
                || wheelNo >= wheels.size()) {
            throw new RuntimeException("Nieprowidłowy indeks koła (" + wheelNo
                    + ") ");
        }
        Wheel wheel = wheels.get(wheelNo);
        return wheel.getSymbol(rowNo);
    }
}
