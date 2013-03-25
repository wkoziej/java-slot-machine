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

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import slotmachine.controller.GameController;
import slotmachine.model.Machine;
import slotmachine.model.SimplestGameRules;

/**
 *
 * @author wokoziej
 */
public class MainFrame extends Frame {

    private final CylinderPanel cylinderPanel;
    private final Panel controlsPanel;
    private final IntegerInputPanel payLinesInput;
    private final IntegerInputPanel lineBetInput;
    private final LabeledField betValue;
    private final LabeledField pointsCountField;

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    public MainFrame(final GameController gameController) throws HeadlessException {

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        setLayout(new BorderLayout(2, 1));

        cylinderPanel = new CylinderPanel(gameController.getCylinder());
        add(cylinderPanel, BorderLayout.NORTH);

        controlsPanel = new Panel(new GridLayout(0, 1));
        payLinesInput = new IntegerInputPanel("Liczba płatnych linii", 1, 1, 10);

        controlsPanel.add(payLinesInput);


        payLinesInput.addPropertyChangeListener("value", new PropertyChangeListener() {
           
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if (pce.getPropertyName().equals("value")) {
                    Integer newValue = (Integer) pce.getNewValue();
                    gameController.setPayLineCount(newValue);
                    betValue.setValue(String.valueOf(gameController.betValue()));
                }
            }
        });

        lineBetInput = new IntegerInputPanel("Stawka za linię", 1, 1, 10);
        lineBetInput.addPropertyChangeListener("value", new PropertyChangeListener() {
           
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if (pce.getPropertyName().equals("value")) {
                     Integer newValue = (Integer) pce.getNewValue();
                    gameController.setLineBet(newValue);
                    betValue.setValue(String.valueOf(gameController.betValue()));
                }
            }
        });
        controlsPanel.add(lineBetInput);
        pointsCountField = new LabeledField("Liczba punktów", "0");
        controlsPanel.add(pointsCountField);
        betValue = new LabeledField("Wysokość zakładu", "1");
        controlsPanel.add(betValue);
        final LabeledField winCountField = new LabeledField("Wygrana", "0");
        controlsPanel.add(winCountField);

        final Button insertCoinButton = new Button("Wrzuć monetę");
        controlsPanel.add(insertCoinButton);
        insertCoinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameController.insertCoin();
                final String pointsCount = String.valueOf(gameController.getPointsCount());
                pointsCountField.setValue(pointsCount);
                System.out.print(pointsCount);
            }
        });


        final Button playButton = new Button("Graj");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Integer lastWon = winCountField.getValue();
                gameController.increasePoints (lastWon.intValue());
                winCountField.setValue("0");
                          
                if (gameController.canPlayGame()) {
                    
                    gameController.takePoints();
                    pointsCountField.setValue(String.valueOf(gameController.getPointsCount()));
                    gameController.turnCylinder();       
                    cylinderPanel.animateTurn();
                    final int pointsGained = gameController.pointsGained();
                    winCountField.setValue(String.valueOf(pointsGained));
                  
                    
                } else {
                }
            }
        });
        controlsPanel.add(playButton);

        add(controlsPanel, BorderLayout.SOUTH);
        pack();
    }
}
