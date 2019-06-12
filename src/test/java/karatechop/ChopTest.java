package karatechop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChopTest {

    @Test
    public void Tests(){
        assertEquals(-1, Chop.To(3, new int[] { }));
        assertEquals(-1, Chop.To(3, new int[] { 1 }));
        assertEquals(0, Chop.To(1, new int[] { 1 }));

        assertEquals(0, Chop.To(1, new int[] { 1, 3, 5 }));
        assertEquals(1, Chop.To(3, new int[] { 1, 3, 5 }));
        assertEquals(2, Chop.To(5, new int[] { 1, 3, 5 }));
        assertEquals(-1, Chop.To(0, new int[] { 1, 3, 5 }));
        assertEquals(-1, Chop.To(2, new int[] { 1, 3, 5 }));

        assertEquals(-1, Chop.To(4, new int[] { 1, 3, 5 }));
        assertEquals(-1, Chop.To(6, new int[] { 1, 3, 5 }));

        assertEquals(0, Chop.To(1, new int[] { 1, 3, 5, 7 }));
        assertEquals(1, Chop.To(3, new int[] { 1, 3, 5, 7 }));
        assertEquals(2, Chop.To(5, new int[] { 1, 3, 5, 7 }));
        assertEquals(3, Chop.To(7, new int[] { 1, 3, 5, 7 }));
        assertEquals(-1, Chop.To(0, new int[] { 1, 3, 5, 7 }));
        assertEquals(-1, Chop.To(2, new int[] { 1, 3, 5, 7 }));
        assertEquals(-1, Chop.To(4, new int[] { 1, 3, 5, 7 }));
        assertEquals(-1, Chop.To(6, new int[] { 1, 3, 5, 7 }));
        assertEquals(-1, Chop.To(8, new int[] { 1, 3, 5, 7 }));
    }
}
