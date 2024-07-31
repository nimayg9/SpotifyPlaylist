// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import java.text.ParseException;
import java.io.FileNotFoundException;

/**
 * This class allows us to run the program
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 11.05.2023
 */
public class ProjectRunner {

    /**
     * This method is small and will help run the program
     * 
     * @param args
     *            are the two possible arguments that will be provided as the
     *            input filenames
     */
    public static void main(String[] args)
        throws ParseException,
        DailyMixDataException,
        FileNotFoundException {
        @SuppressWarnings("unused")
        PlaylistReader playlistReader;
        if (args.length == 2)
            playlistReader = new PlaylistReader(args[0], args[1]);
        else {
            playlistReader = new PlaylistReader("input.txt", "playlists.txt");
        }
    }

}
