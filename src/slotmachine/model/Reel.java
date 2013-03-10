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
 * Reprezentacja obręczy z symbolami na kole w automacie jednorękiego bandyty.
 *
 * @author wojtas
 */
public class Reel {

    private final Symbol symbols[];

    private Reel() {
        symbols = null;
    }

    public Reel(Symbol init[]) {
        if (init != null) {
            symbols = new Symbol[init.length];
            System.arraycopy(init, 0, symbols, 0, init.length);
        } else {
            symbols = null;
        }
    }

    public int getSize() {
        return symbols == null ? 0 : symbols.length;
    }
    
    public Symbol getSymbolAt (int symbolIndex) {
        return symbols [symbolIndex];
    }
    // TODO: zaimplementować equals i hashCode oraz ich testy
}
