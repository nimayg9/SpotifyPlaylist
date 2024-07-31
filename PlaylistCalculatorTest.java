// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * This class tests the PlaylistCalculator class
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 11.06.2023
 */
public class PlaylistCalculatorTest extends TestCase {

    private PlaylistCalculator pc;
    private ArrayQueue<Song> sq;
    private Playlist p1;
    private Playlist p2;
    private Playlist p3;

    /**
     * This makes the playlist calculator to help test the methods
     */
    public void setUp() {
        sq = new ArrayQueue<Song>();
        p1 = new Playlist("Playlist 1", 1, 1, 1, 99, 99, 99, 10);
        p2 = new Playlist("Playlist 2", 1, 1, 1, 99, 99, 99, 10);
        p3 = new Playlist("Playlist 3", 1, 1, 1, 99, 99, 99, 10);
        Playlist[] playlist = new Playlist[3];
        playlist[0] = p1;
        playlist[1] = p2;
        playlist[2] = p3;
        pc = new PlaylistCalculator(sq, playlist);
    }


    /**
     * This tests the constructor
     */
    public void testConstuctor() {
        ArrayQueue<Song> sqNull = null;
        Playlist[] playlist = new Playlist[3];
        Exception thrown = null;
        try {
            pc = new PlaylistCalculator(sqNull, playlist);
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * This tests the reject method
     */
    public void testReject() {
        Song s = new Song("AA", 1, 1, 1, "A");
        sq.enqueue(s);
        assertNotNull(sq.getFront());
        pc.reject();
        Exception thrown = null;
        try {
            sq.dequeue();
        }
        catch (EmptyQueueException e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyQueueException);
    }


    /**
     * This tests the getPlaylistWithMostRoom method
     */
    public void testGetPlaylistForSong() {
        Song s = null;
        assertNull(pc.getPlaylistForSong(null));
        assertNull(pc.getPlaylistForSong(s));

        Song s1 = new Song("AA", 1, 1, 1, "A");
        Song s2 = new Song("AA", 1, 1, 1, "A");
        Song s3 = new Song("AA", 1, 1, 1, "A");

        p1.addSong(s1);
        p1.addSong(s2);
        p2.addSong(s1);
        assertEquals(p3, pc.getPlaylistForSong(s3));

        Song s4 = new Song("AA", 1, 1, 1, "Playlist 1");
        assertEquals(p1, pc.getPlaylistForSong(s4));

        Song s5 = new Song("AA", 10, 10, 14, "Playlist 4");
        Playlist pnew1 = new Playlist("Playlist 4", 1, 1, 1, 99, 99, 99, 1);
        Playlist pnew2 = new Playlist("Playlist 5", 1, 1, 1, 99, 99, 99, 1);
        pnew1.addSong(s1);
        Playlist[] playlist1 = new Playlist[2];
        playlist1[0] = pnew1;
        playlist1[1] = pnew2;
        PlaylistCalculator pc1 = new PlaylistCalculator(sq, playlist1);
        assertTrue(pnew1.isFull());
        assertEquals(pnew2, pc1.getPlaylistForSong(s5));
    }


    /**
     * This tests the getPlaylistWithMostRoom method
     */
    public void testGetPlaylistForSong2() {
        Song s = null;
        assertNull(pc.getPlaylistForSong(null));
        assertNull(pc.getPlaylistForSong(s));

        Song s1 = new Song("AA", 1, 1, 1, "A");
        Song s2 = new Song("AA", 1, 1, 1, "A");
        Song s3 = new Song("AA", 1, 1, 1, "A");

        p1.addSong(s1);
        p3.addSong(s2);
        p3.addSong(s1);
        assertEquals(p2, pc.getPlaylistForSong(s3));
    }


    /**
     * This tests the addSongToPlaylist method
     */
    public void testAddSongToPlaylist() {
        assertFalse(pc.addSongToPlaylist());
        Song s1 = new Song("AA", 1, 1, 1, "A");
        Song s2 = new Song("AA", 1, 1, 1, "A");
        Song s3 = new Song("AA", 1, 1, 1, "A");

        sq.enqueue(s1);
        sq.enqueue(s2);
        sq.enqueue(s3);

        assertTrue(pc.addSongToPlaylist());

        Playlist pnew1 = new Playlist("Playlist 4", 1, 1, 1, 99, 99, 99, 1);
        pnew1.addSong(s1);
        Playlist[] playlist1 = new Playlist[1];
        playlist1[0] = pnew1;
        PlaylistCalculator pc1 = new PlaylistCalculator(sq, playlist1);
        assertFalse(pc1.addSongToPlaylist());
    }


    /**
     * This tests the getPlaylistIndex method
     */
    public void testGetPlaylistIndex() {
        assertEquals(0, pc.getPlaylistIndex("Playlist 1"));
        assertEquals(1, pc.getPlaylistIndex("Playlist 2"));
        assertEquals(-1, pc.getPlaylistIndex("Playlist 4"));

    }

}
