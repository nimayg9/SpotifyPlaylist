// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import java.util.Arrays;

/**
 * This class creates the playlist with the name and the minimum and maximum
 * genre set values and the song capacity
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 11.04.2023
 */
public class Playlist implements Comparable<Playlist> {

    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    /**
     * This constructor initializes the fields using the parameters and allows
     * us to call to create a new playlist using this constructor later on
     * 
     * @param playlistName
     *            is the name of the playlist
     * @param minPop
     *            is the minimum percentage of pop
     * @param minRock
     *            is the minimum percentage of rock
     * @param minCountry
     *            is the minimum percentage of country
     * @param maxPop
     *            is the maximum percentage of pop
     * @param maxRock
     *            is the maximum percentage of rock
     * @param maxCountry
     *            is the maximum percentage of country
     * @param playlistCap
     *            is the maximum number of songs that can be put into the
     *            playlist
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap) {

        name = playlistName;
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        capacity = playlistCap;
        songs = new Song[capacity];
        numberOfSongs = 0;
    }


    /**
     * This method allows us to get the minGenreSet set
     * 
     * @return the minimum genre set is returned
     */
    public GenreSet getMinGenreSet() {
        return minGenreSet;
    }


    /**
     * This method allows us to change the name to whatever string (name) we put
     * into the parameter
     * 
     * @param newName
     *            this is the new playlist name which we are setting
     */
    public void setName(String newName) {
        name = newName;
    }


    /**
     * This method allows us to check the amount of available slots left in the
     * playlist
     * 
     * @return the number of available places left in the playlist
     */
    public int getSpacesLeft() {
        return getCapacity() - numberOfSongs;
    }


    /**
     * This method allows us to get the maxGenreSet set
     * 
     * @return the maximum genre set is returned
     */
    public GenreSet getMaxGenreSet() {
        return maxGenreSet;
    }


    /**
     * This method compares two playlists to each other
     * 
     * @param otherPlaylist
     *            is the playlist we are comparing the current one to
     * @return returns a negative value if the current playlist is less than
     *         the other playlist, returns a positive value if the current
     *         playlist is greater than the other playlist, and returns 0 if
     *         the current playlist is equal to the other playlist
     */
    @Override
    public int compareTo(Playlist otherPlaylist) {
        if (this.getCapacity() < otherPlaylist.getCapacity()) {
            return -1;
        }
        else if (this.getCapacity() > otherPlaylist.getCapacity()) {
            return 1;
        }
        else {
            if (this.getSpacesLeft() > otherPlaylist.getSpacesLeft()) {
                return 1;
            }
            else if (this.getSpacesLeft() < otherPlaylist.getSpacesLeft()) {
                return -1;
            }
            else {
                int minGSCompare = this.getMinGenreSet().compareTo(otherPlaylist
                    .getMinGenreSet());
                if (minGSCompare != 0) {
                    return minGSCompare;
                }
                else {
                    int maxGSCompare = this.getMaxGenreSet().compareTo(
                        otherPlaylist.getMaxGenreSet());
                    if (maxGSCompare != 0) {
                        return maxGSCompare;
                    }
                    else {
                        if (this.getName().compareTo(otherPlaylist
                            .getName()) != 0) {
                            return this.getName().compareTo(otherPlaylist
                                .getName());
                        }
                        return 0;
                    }
                }
            }
        }
    }


    /**
     * This method returns the number of songs in the playlist
     * 
     * @return the number of songs in the playlist is returned
     */
    public int getNumberOfSongs() {
        return numberOfSongs;
    }


    /**
     * This method adds a new song to the playlist and returns true if it was
     * added
     * 
     * @param newSong
     *            the song we are adding to the playlist
     * @return true is returned if the song was able to be added, and false if
     *         not
     */
    public boolean addSong(Song newSong) {
        if (isQualified(newSong)) {
            getSongs()[getNumberOfSongs()] = newSong;
            numberOfSongs++;
        }
        return false;
    }


    /**
     * This method makes the playlist a string
     * 
     * @return this method returns the string form of the playlist
     */
    public String toString() {
        String strPlaylist = "Playlist: " + getName() + ", ";
        String strNumSongs = "# of songs: " + numberOfSongs + " ";
        String strCap = "(cap: " + getCapacity() + ")" + ", ";
        String strPop = "Pop:" + minGenreSet.getPop() + "%-" + maxGenreSet
            .getPop() + "%" + ", ";
        String strRock = "Rock:" + minGenreSet.getRock() + "%-" + maxGenreSet
            .getRock() + "%" + ", ";
        String strCountry = "Country:" + minGenreSet.getCountry() + "%-"
            + maxGenreSet.getCountry() + "%";
        String strMinsMaxs = "Requires: " + strPop + strRock + strCountry;
        return strPlaylist + strNumSongs + strCap + strMinsMaxs;
    }


    /**
     * This method tells us if the playlist is full
     * 
     * @return true is returned if there is no room left in the playlist
     */
    public boolean isFull() {
        return numberOfSongs == getCapacity();
    }


    /**
     * This method tells us if 2 playlists are equal to each other
     * 
     * @param other
     *            is the playlist we are comparing the current one to
     * @return true is returned if the 2 playlists are equal and are in the same
     *         order
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Playlist pl = (Playlist)other;
        if (this.getName() != pl.getName()) {
            return false;
        }
        if (!this.getMinGenreSet().equals(pl.getMinGenreSet())) {
            return false;
        }
        if (!this.getMaxGenreSet().equals(pl.getMaxGenreSet())) {
            return false;
        }
        if (this.getCapacity() != pl.getCapacity()) {
            return false;
        }
        if (this.getNumberOfSongs() != pl.getNumberOfSongs()) {
            return false;
        }
        return Arrays.equals(this.songs, pl.songs);
    }


    /**
     * This method returns the songs array
     * 
     * @return the song array is returned
     */
    public Song[] getSongs() {
        return songs;
    }


    /**
     * This method returns the capacity of the playlist
     * 
     * @return the capacity is returned
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * This method returns the name of the playlist
     * 
     * @return the name is returned
     */
    public String getName() {
        return name;
    }


    /**
     * This method checks if a song is qualified to be in the playlist
     * 
     * @param checkSong
     *            this is the song that we are checking to see is qualified or
     *            not
     * @return returns true if the song is qualified, and false if not
     */
    public boolean isQualified(Song checkSong) {
        if (isFull()) {
            return false;
        }
        if (checkSong == null) {
            return false;
        }
        return checkSong.getGenreSet().isWithinRange(minGenreSet, maxGenreSet);
    }

}
