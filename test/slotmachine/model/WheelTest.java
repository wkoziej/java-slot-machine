/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wojtas
 */
public class WheelTest {

    public WheelTest() {
    }

    @Test
    public void testGetSymbol() {
        System.out.println("getSymbol");
        final Symbol a = new Symbol('A', false);
        final Symbol b = new Symbol('B', false);
        final Symbol c = new Symbol('C', false);
        final Symbol wild = new Symbol('*', true);
        Symbol[] symbols = {a, b, c, wild};
        Wheel wheel = new Wheel(new Reel(symbols));
        
        assertEquals(a, wheel.getSymbol(0));       
        assertEquals(c, wheel.getSymbol(2));
        // Zmieniamy pozycję koła
        wheel.turnTo(1);
        assertEquals(b, wheel.getSymbol(0));       
        assertEquals(wild, wheel.getSymbol(2));
        wheel.turnTo(6); // 6 == 2
        assertEquals(c, wheel.getSymbol(0));       
        assertEquals(a, wheel.getSymbol(2));
        
    }
}
