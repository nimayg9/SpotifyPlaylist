// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import student.TestCase;

/**
 * This class tests the Song class
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 10.30.23
 */
public class SongTest extends TestCase {

    private Song song;
    private Song song2;
    private Song song3;
    private Song song4;
    private Song song5;
    private Song song6;

    /**
     * This creates the songs to help with the test methods
     */
    public void setUp() {
        song = new Song("A", 0, 0, 0, "P1");
        song2 = new Song("A", 0, 0, 0, "");
        song3 = new Song("A", 0, 0, 0, "P1");
        song4 = null;
        song5 = new Song("B", 0, 0, 0, "P1");
        song6 = new Song("A", 1, 0, 0, "P1");

    }


    /**
     * This tests the getName method
     */
    public void testGetName() {
        assertEquals("A", song.getName());
    }


    /**
     * This tests the getPlaylistName method
     */
    public void testGetPlaylistName() {
        assertEquals("P1", song.getPlaylistName());
    }


    /**
     * This tests the toString method
     */
    public void testToString() {
        assertEquals("A Pop:0 Rock:0 Country:0 Suggested: P1", song.toString());
        assertEquals("No-Playlist A Pop:0 Rock:0 Country:0", song2.toString());
    }


    /**
     * This tests the equals method
     */
    public void testEquals() {
        assertTrue(song.equals(song));
        assertFalse(song.equals(song2));
        assertTrue(song.equals(song3));
        assertFalse(song.equals(song4));

        Object obj = new Object();
        assertFalse(song.equals(obj));

        assertFalse(song.equals(song5));
        assertFalse(song.equals(song6));
    }
}
