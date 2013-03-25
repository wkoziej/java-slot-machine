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
package slotmachine.view;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.logging.Level;
import java.util.logging.Logger;
import slotmachine.model.Wheel;

/**
 *
 * @author wokoziej
 */
public class LabelWheelPanel extends Panel {

    private Label symbols[];
    private boolean turning;
    private Wheel wheel;

    public LabelWheelPanel(Wheel wheel) {
        turning = true;
        symbols = new Label[3];
        int wheelPosition = wheel.reelPosition();
        setLayout(new GridLayout(3, 1));
        this.wheel = wheel;
        for (int i = 0; i < symbols.length; i++) {
            Label label = new Label(wheel.getSymbol(wheelPosition + i).toString());
            symbols[i] = label;
            add(label);
        }
    }

    void turn() {
        int wheelPosition = wheel.reelPosition();
        wheel.turnTo(wheel.reelPosition() + 1);
        for (int i = 0; i < symbols.length; i++) {
            symbols[i].setText(wheel.getSymbol(i).toString());
        }
    }
}
