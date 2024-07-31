// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import student.TestCase;

/**
 * This class tests the GenreSet class
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 10.30.23
 */
public class GenreSetTest extends TestCase {

    private GenreSet gs0;
    private GenreSet gs;
    private GenreSet gs2;
    private GenreSet gs3;
    private GenreSet gs4;
    private GenreSet gs5;
    private GenreSet gs6;
    private GenreSet gs7;
    private GenreSet gs8;
    private GenreSet gs9;
    private GenreSet gs10;
    private GenreSet gs11;
    private GenreSet gs12;
    private GenreSet gs13;

    /**
     * This creates the two genre sets to help with the test methods
     */
    public void setUp() {
        gs0 = new GenreSet(0, 0, 0);
        gs = new GenreSet(30, 0, 50);
        gs2 = new GenreSet(10, 80, 0);
        gs3 = new GenreSet(30, 0, 50);
        gs4 = null;
        gs5 = new GenreSet(30, 10, 40);
        gs6 = new GenreSet(30, 0, 40);
        gs7 = new GenreSet(30, 10, 50);
        gs8 = new GenreSet(-1, 5, 7);
        gs9 = new GenreSet(60, 5, 7);
        gs10 = new GenreSet(1, 60, 0);
        gs11 = new GenreSet(1, 5, 70);
        gs12 = new GenreSet(70, 70, 70);
        gs13 = new GenreSet(70, -1, 70);
    }


    /**
     * This tests the getRock method
     */
    public void testGetRock() {
        assertEquals(0, gs.getRock());
    }


    /**
     * This tests the getPop method
     */
    public void testGetPop() {
        assertEquals(30, gs.getPop());
    }


    /**
     * This tests the getCountry method
     */
    public void testGetCountry() {
        assertEquals(50, gs.getCountry());
    }


    /**
     * This tests the toString method
     */
    public void testToString() {
        assertEquals("Pop:30 Rock:0 Country:50", gs.toString());
    }


    /**
     * This tests the equals method
     */
    public void testEquals() {
        assertTrue(gs.equals(gs));
        assertFalse(gs.equals(gs2));
        assertTrue(gs.equals(gs3));
        assertFalse(gs.equals(gs4));

        Object obj = new Object();
        assertFalse(gs.equals(obj));

        assertFalse(gs.equals(gs5));
        assertFalse(gs.equals(gs6));
    }


    /**
     * This tests the isWithinRange method
     */
    public void testIsWithinRange() {
        assertTrue(gs.isWithinRange(gs0, gs));
        assertTrue(gs6.isWithinRange(gs0, gs5));

        assertFalse(gs5.isWithinRange(gs0, gs6));
        assertFalse(gs0.isWithinRange(gs, gs5));
        assertFalse(gs3.isWithinRange(gs, gs5));
        assertFalse(gs7.isWithinRange(gs, gs5));
        assertFalse(gs8.isWithinRange(gs, gs5));
        assertFalse(gs9.isWithinRange(gs, gs5));
        assertFalse(gs10.isWithinRange(gs, gs5));
        assertFalse(gs11.isWithinRange(gs, gs5));
        assertFalse(gs12.isWithinRange(gs, gs5));
        assertFalse(gs13.isWithinRange(gs, gs5));
    }


    /**
     * This method tests the compareTo method
     */
    public void testCompareTo() {
        assertEquals(-1, gs.compareTo(gs2));
        assertEquals(1, gs2.compareTo(gs));
        assertEquals(0, gs.compareTo(gs3));
    }
}
