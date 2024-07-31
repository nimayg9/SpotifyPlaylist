// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import list.AList;

/**
 * This class This object handles all the calculations for the program, and it
 * helps when we are trying to add or rejecting a song depending on the
 * requirements before we add it to the playlist
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 11.06.2023
 */
public class PlaylistCalculator {

    private Playlist[] playlists;
    /**
     * Constant setting the limit for the number of playlists in the array
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * Constant setting the minimum percentage for the the genre percentage
     * values
     */
    public static final int MIN_PERCENT = 0;
    /**
     * Constant setting the maximum percentage for the the genre percentage
     * values
     */
    public static final int MAX_PERCENT = 100;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;

    /**
     * This constructor initializes the fields using the parameters and allows
     * us to calculate the decisions for the program
     * 
     * @param songQueue
     *            is the queue of all the songs that we are removing and
     *            organizing into playlists properly
     * @param playlists
     *            is the array of playlists that will contain the 3 playlists
     *            that our songs could possibly be put into
     */
    public PlaylistCalculator(
        ArrayQueue<Song> songQueue,
        Playlist[] playlists) {
        if (songQueue == null) {
            throw new IllegalArgumentException();
        }
        this.songQueue = songQueue;
        this.playlists = playlists;
        rejectedTracks = new AList<Song>();
    }


    /**
     * This method removes a song from the queue and adds it to the rejected
     * tracks AList
     */
    public void reject() {
        rejectedTracks.add(songQueue.getFront());
        getQueue().dequeue();
    }


    /**
     * This method finds the playlist with the most room left
     * 
     * @param nextSong
     *            is the song we are checking to see where it fits
     * @return the playlist with the most room that can fit the song is
     *         returned
     */
    private Playlist getPlaylistWithMostRoom(Song aSong) {
        Playlist playlistWithMostRoom = null;
        int maxSpace = 0;
        for (Playlist playlist : getPlaylists()) {
            if (playlist.isQualified(aSong) && (playlist
                .getSpacesLeft() > maxSpace)) {
                maxSpace = playlist.getSpacesLeft();
                playlistWithMostRoom = playlist;
            }
        }
        return playlistWithMostRoom;
    }


    /**
     * This method will attempt to add a song to the playlist
     * 
     * @return true if the song can be added
     */
    public boolean addSongToPlaylist() {
        if (getQueue().isEmpty()) {
            return false;
        }
        Song song = getQueue().getFront();
        Playlist playlist = getPlaylistForSong(song);
        if (playlist != null) {
            playlist.addSong(song);
            getQueue().dequeue();
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * This method will decide if the next song can be added to the playlist
     * 
     * @param nextSong
     *            is the song that we want to put in a specific playlist
     * @return the playlist the song should go into
     */
    public Playlist getPlaylistForSong(Song nextSong) {
        if (nextSong == null) {
            return null;
        }
        String playlistName = nextSong.getPlaylistName();
        Playlist suggestedPlaylist = null;
        for (int i = 0; i < getPlaylists().length; i++) {
            if (getPlaylists()[i].getName() == playlistName) {
                suggestedPlaylist = playlists[i];
            }
        }
        if (suggestedPlaylist != null && (suggestedPlaylist.isQualified(
            nextSong))) {
            return suggestedPlaylist;
        }
        return getPlaylistWithMostRoom(nextSong);
    }


    /**
     * This method is a getter method for the songQueue field
     * 
     * @return the songQueue is returned
     */
    public ArrayQueue<Song> getQueue() {
        return songQueue;
    }


    /**
     * This method gets the playlist index for the given string of the
     * playlist's name
     * 
     * @param playlistName
     *            is the name of the playlist that we want the index of
     * @return the index of the playlist, and -1 if it doesn't exist
     */
    public int getPlaylistIndex(String playlistName) {
        for (int i = 0; i < playlists.length; i++) {
            if (getPlaylists()[i].getName().equals(playlistName)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * This method is a getter method for the playlists field
     * 
     * @return the playlists array is returned
     */
    public Playlist[] getPlaylists() {
        return playlists;
    }
}
