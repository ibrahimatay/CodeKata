package romannumerals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {

    @Test(expected = IllegalArgumentException.class)
    public void Roman_0_No()
    {
        Roman.To(0);
    }

    @Test
    public void Roman_1_I()
    {
        assertEquals("I", Roman.To(1));
    }

    @Test
    public void Roman_2_II()
    {
        assertEquals("II", Roman.To(2));
    }

    @Test
    public void Roman_3_III()
    {
        assertEquals("III", Roman.To(3));
    }

    @Test
    public void Roman_4_IV()
    {
        assertEquals("IV", Roman.To(4));
    }

    @Test
    public void Roman_5_V()
    {
        assertEquals("V", Roman.To(5));
    }

    @Test
    public void Roman_9_IX()
    {
        assertEquals("IX", Roman.To(9));
    }

    @Test
    public void Roman_10_X()
    {
        assertEquals("X", Roman.To(10));
    }

    @Test
    public void Roman_49_XLIX()
    {
        assertEquals("XLIX", Roman.To(49));
    }

    @Test
    public void Roman_50_L()
    {
        assertEquals("L", Roman.To(50));
    }

    @Test
    public void Roman_100_C()
    {
        assertEquals("C", Roman.To(100));
    }

    @Test
    public void Roman_400_CD()
    {
        assertEquals("CD", Roman.To(400));
    }

    @Test
    public void Roman_500_D()
    {
        assertEquals("D", Roman.To(500));
    }

    @Test
    public void Roman_900_CM()
    {
        assertEquals("CM", Roman.To(900));
    }

    @Test
    public void Roman_1000_M()
    {
        assertEquals("M", Roman.To(1000));
    }

    @Test
    public void Roman_11984_MMMMMMMMMMMCMLXXXIV()
    {
        assertEquals("MMMMMMMMMMMCMLXXXIV", Roman.To(11984));
    }
}
