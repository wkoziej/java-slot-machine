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
public class ReelTest {

    public ReelTest() {
    }

    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Reel instance;
        Symbol a = new Symbol('A', false);
        Symbol b = new Symbol('B', false);
        Symbol reel[] = {a, b};
        instance = new slotmachine.model.Reel( null );
        int result = instance.getSize();
        assertEquals(0, result);
        instance = new slotmachine.model.Reel( reel );
        result = instance.getSize();
        assertEquals(2, result); 
    }
}
