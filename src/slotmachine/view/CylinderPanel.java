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

import java.awt.Color;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import slotmachine.model.Cylinder;
import slotmachine.model.Wheel;

/**
 *
 * @author wokoziej
 */
public class CylinderPanel extends Panel {

    //private Cylinder cylinder;
    List<LabelWheelPanel> wheelList;

    public CylinderPanel(Cylinder cylinder) {
        setBackground(Color.BLUE);
        //this.cylinder = cylinder;
        wheelList = new ArrayList<LabelWheelPanel>();
        for (Iterator it = cylinder.getWheels().iterator(); it.hasNext();) {
            Wheel wheel = (Wheel) it.next();
            final LabelWheelPanel labeledWheelPanel = new LabelWheelPanel(wheel);
            wheelList.add(labeledWheelPanel);
            //java.awt.EventQueue.invokeLater(labeledWheelPanel);
            add(labeledWheelPanel);
        }

    }

    public void animateTurn() {
/*
        new Runnable() {
            public void run() { */
                for (int i = 0; i < 20; i++) {


                    for (Iterator it = wheelList.iterator(); it.hasNext();) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CylinderPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        LabelWheelPanel wheelPanel = (LabelWheelPanel) it.next();
                        wheelPanel.turn();
                    }
                }
          /*  }
        }.run();*/
    }
}
