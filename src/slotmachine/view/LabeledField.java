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

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/**
 *
 * @author wokoziej
 */
public class LabeledField extends Panel {

    private Label label;
    private TextField textField;

    public LabeledField(String label, String initialVal) {
        setLayout(new FlowLayout (FlowLayout.RIGHT));
        this.label = new Label(label);
        textField = new TextField(initialVal, 3);
        add(this.label);
        add(textField);
    }

    public void setValue(String value) {
        textField.setText(value);
    }

    Integer getValue() {
       return Integer.parseInt(textField.getText());
    }
}
