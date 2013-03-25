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
 * Klasa reprezentująca pojedyncze koło w bębnie jędnorękiego bandyty.
 *
 * Składa się z definicji symboli jakie znajdują się na obręczy oraz aktualnej
 * pozycji liczonej względem pierwszego widocznego symbolu: pozycja = 0,
 * widoczny początek obręczy pozycja = 1, obręcz przesunięta tak, że pierwszej
 * (o indeksie 0) pozycji nie widać
 *
 * @author wojtas
 */
public class Wheel {

    private int position;
    private final Reel reel;

    public Wheel(Reel reel) {
        this.reel = reel;
        position = 0;
    }

    /**
     * Zakręć kołem - zmień jego pozycję na losową.
     */
    public int turn() {
        double random = Math.random();
        position = (int) (random * reel.getSize());
        return position;
    }

    /**
     * W jakiej pozycji jest ustawione koło?
     */
    public int reelPosition() {
        return position;
    }

    public Symbol getSymbol(int rowNo) {
        if (rowNo < 0 || rowNo >= reel.getSize()) {
            throw new RuntimeException("Nieprawidłowy indeks wiersza (" + rowNo + ") ");
        }
        int symbolPos = (rowNo + position) % reel.getSize();
        return reel.getSymbolAt(symbolPos);
    }

    public void turnTo(int newPosition) {
        position = newPosition % reel.getSize();
    }
}
