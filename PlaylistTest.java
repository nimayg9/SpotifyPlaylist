// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import student.TestCase;

/**
 * This class tests the Playlist class
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 11.04.2023
 */
public class PlaylistTest extends TestCase {

    private Playlist p;
    private Playlist p1;
    private Playlist p2;
    private Playlist p5;

    /**
     * This makes the playlists to help tests the methods
     */
    public void setUp() {
        p = new Playlist("A", 1, 1, 1, 99, 99, 99, 10);
    }


    /**
     * This tests the setName method
     */
    public void testSetName() {
        assertEquals("A", p.getName());
        p.setName("B");
        assertEquals("B", p.getName());
    }


    /**
     * This tests the compareTo method
     */
    public void testCompareTo() {
        p1 = new Playlist("A", 1, 1, 1, 99, 99, 99, 11);
        assertEquals(-1, p.compareTo(p1));
        assertEquals(1, p1.compareTo(p));

        p1 = new Playlist("A", 1, 1, 1, 99, 99, 99, 10);
        Song s1 = new Song("AA", 1, 1, 1, "A");
        assertEquals(0, p.compareTo(p1));
        p1.addSong(s1);
        assertEquals(1, p.compareTo(p1));
        assertEquals(-1, p1.compareTo(p));

        p2 = new Playlist("A", 1, 1, 2, 99, 99, 99, 10);
        assertEquals(-1, p.compareTo(p2));

        p2 = new Playlist("A", 1, 1, 1, 99, 99, 98, 10);
        assertEquals(1, p.compareTo(p2));

        p2 = new Playlist("B", 1, 1, 1, 99, 99, 99, 10);
        assertEquals(-1, p.compareTo(p2));
    }


    /**
     * This tests the addSong method
     */
    public void testAddSongAndIsFull() {
        p1 = new Playlist("A", 1, 1, 1, 99, 99, 99, 1);
        assertEquals(1, p1.getSpacesLeft());
        assertEquals(1, p1.getCapacity());
        assertEquals(0, p1.getNumberOfSongs());
        Song s1 = new Song("AA", 1, 1, 1, "A");
        assertFalse(p1.isFull());
        p1.addSong(s1);
        assertTrue(p1.isFull());
        assertFalse(p1.addSong(s1));
    }


    /**
     * This tests the toString method
     */
    public void testToString() {
        String str = "Playlist: A, # of songs: 0 (cap: 10), Requires: "
            + "Pop:1%-99%, Rock:1%-99%, Country:1%-99%";
        assertEquals(str, p.toString());
    }


    /**
     * This tests the equals method
     */
    public void testEquals() {
        assertTrue(p.equals(p));

        p1 = new Playlist("B", 1, 1, 1, 99, 99, 99, 10);
        assertFalse(p.equals(p1));

        p2 = new Playlist("A", 2, 1, 1, 99, 99, 99, 10);
        assertFalse(p.equals(p2));

        Playlist p3 = new Playlist("A", 1, 1, 1, 99, 99, 98, 10);
        assertFalse(p.equals(p3));

        Playlist p4 = new Playlist("A", 1, 1, 1, 99, 99, 99, 9);
        assertFalse(p.equals(p4));

        Playlist p6 = new Playlist("A", 1, 1, 1, 99, 99, 99, 10);
        assertTrue(p.equals(p6));

        Song s1 = new Song("AA", 1, 1, 1, "A");
        Song s2 = new Song("BB", 1, 1, 1, "A");
        p.addSong(s1);
        assertFalse(p.equals(p5));

        p5 = new Playlist("A", 1, 1, 1, 99, 99, 99, 10);
        p5.addSong(s2);
        assertFalse(p.equals(p5));

        p5.addSong(s1);
        assertFalse(p.equals(p5));

        Object obj = new Object();
        assertFalse(p.equals(obj));

        p6.addSong(s1);
        assertEquals(p6.getNumberOfSongs(), p.getNumberOfSongs());
        assertTrue(p.equals(p6));

        assertEquals(10, p.getCapacity());
        assertEquals(1, p.getNumberOfSongs());
        assertEquals(9, p.getSpacesLeft());

        assertEquals(10, p6.getCapacity());
        assertEquals(1, p6.getNumberOfSongs());
        assertEquals(9, p6.getSpacesLeft());
    }


    /**
     * This tests the isQualified method
     */
    public void testIsQualified() {
        assertFalse(p.isQualified(null));
        Song s1 = new Song("AA", 90, 101, 90, "A");
        assertFalse(p.isQualified(s1));
    }

}
