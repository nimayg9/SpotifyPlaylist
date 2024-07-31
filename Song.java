// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

/**
 * This class creates the song with the song’s name, the genre set object,
 * and the song's suggested playlist as parameters
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 10.30.2023
 */
public class Song {

    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    /**
     * This class creates the Song which contains the name, genre percentages,
     * and the suggested playlist
     * 
     * @param name
     *            is the name of the song
     * @param pop
     *            is the pop percentage
     * @param rock
     *            is the rock percentage
     * @param country
     *            is the country percentage
     * @param suggested
     *            is the suggested playlist for the song
     */
    public Song(String name, int pop, int rock, int country, String suggested) {
        this.name = name;
        this.suggestedPlaylist = suggested;
        genreSet = new GenreSet(pop, rock, country);
    }


    /**
     * This method gets the name of the song
     * 
     * @return the name of the song is returned
     */
    public String getName() {
        return name;
    }


    /**
     * This method gets the playlist's name
     * 
     * @return the suggested playlist name is returned
     */
    public String getPlaylistName() {
        return suggestedPlaylist;
    }


    /**
     * This method gets the genre set
     * 
     * @return the genre set field s returned
     */
    public GenreSet getGenreSet() {
        return genreSet;
    }


    /**
     * This method returns a string with the name of the song, values of rock,
     * pop, and country, and the suggested playlist it should be put in
     * 
     * @return the string that is created is returned
     */
    public String toString() {
        String str = "" + name + " " + this.getGenreSet().toString();

        if (suggestedPlaylist.length() > 0) {
            str += " Suggested: " + suggestedPlaylist;
            return str;
        }
        return "No-Playlist " + str;
    }


    /**
     * This method checks if two songs are the same
     * 
     * @param obj
     *            is the object that is being compared to the current song
     * 
     * @return true is returned if the songs are the same, and
     *         false is returned if the songs are not the same
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Song song = (Song)obj;
            boolean bool = true;
            if (this.name != song.getName()) {
                bool = false;
            }
            if ((!this.getGenreSet().equals(song.getGenreSet()))) {
                bool = false;
            }
            if (!(this.getPlaylistName().toString().equals(song
                .getPlaylistName().toString()))) {
                bool = false;
            }
            return bool;
        }
        else {
            return false;
        }

    }

}
