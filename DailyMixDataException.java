// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

/**
 * This class deals with the exceptions if the data is not correct
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 11.04.2023
 */
@SuppressWarnings("serial")
public class DailyMixDataException extends Exception {

    /**
     * This is the method that throws the DailyMixDataException if the data is
     * incorrect in the input files
     * 
     * @param message
     *            is the message thrown when this exception occurs
     */
    public DailyMixDataException(String message) {
        super(message);
    }
}
