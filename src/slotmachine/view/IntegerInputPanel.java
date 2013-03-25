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

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author wokoziej
 */
public class IntegerInputPanel extends Panel {

    private Integer value;

    public IntegerInputPanel(String label, int initialValue, final int minValue, final int maxValue) {
        value = new Integer(initialValue);
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(new Label(label));
        final TextField intField = new TextField(String.valueOf(initialValue), 2);
        intField.setEditable(false);
        final Button decButton = new Button("-");
        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                value = Integer.parseInt(intField.getText());
                Integer old = value;
                if (value > minValue) {
                    value--;
                } else {
                    value = maxValue;
                }
                intField.setText(value.toString());
                firePropertyChange("value", old, value);
            }
        });
        add(decButton);
        add(intField);
        final Button incButton = new Button("+");
        incButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                value = Integer.parseInt(intField.getText());
                Integer old = value;
                if (value < maxValue) {
                    value++;
                } else {
                    value = minValue;
                }
                intField.setText(value.toString());
                firePropertyChange("value", old, value);
            }
        });
        add(incButton);

    }

    public Integer getInputValue() {
        return value;
    }
}
