/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author wojtas
 */
public class SymbolTest {

    public SymbolTest() {
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Symbol instance = new Symbol(Character.MIN_VALUE, false);
        // Null nie równy 
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // Nie nulowy object zawsze różny od Symbol
        object = new Object();
        result = instance.equals(object);
        assertEquals(expResult, result);
        // Dla symbolu (nawet wild) też nieprawda że równy
        result = instance.equals(object);
        assertEquals(expResult, result);
        // Dla dowolnego symbolu -> prawda że równy
        Symbol other = new Symbol(Character.MAX_VALUE, true);
        result = instance.equals(other);
        assertEquals(true, result);
        // Symbole nie wild są różne jeżeli reprezentują inne znaki
        Symbol A = new Symbol('A', false);
        Symbol B = new Symbol('B', false);
        Symbol anotherA = new Symbol('A', false);
        assertEquals(true,
                A.equals(anotherA));
        assertEquals(false,
                A.equals(B));
    }

    @Test
    public void testIsWild() {
        System.out.println("isWild");
        Symbol wild = new Symbol(Character.MIN_VALUE, Boolean.TRUE);
        Boolean result = wild.isWild();
        assertEquals(true, result);
        Symbol notWild = new Symbol(Character.MIN_VALUE, Boolean.FALSE);
        result = notWild.isWild();
        assertEquals(false, result);
    }
}
