// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

/**
 * This class creates the genre set for a song with the 3 genre percentages as
 * parameters
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 10.30.2023
 */
public class GenreSet implements Comparable<GenreSet> {

    private final int rock;
    private final int pop;
    private final int country;

    /**
     * Constructor for the Genre Set that includes the pop, rock, and country
     * percentages
     * 
     * @param pop
     *            the pop percentage
     * @param rock
     *            the rock percentage
     * @param country
     *            the country percentage
     */
    public GenreSet(int pop, int rock, int country) {
        this.rock = rock;
        this.pop = pop;
        this.country = country;
    }


    /**
     * This method gets the rock field
     * 
     * @return the rock percentage
     */
    public int getRock() {
        return rock;
    }


    /**
     * This method gets the pop field
     * 
     * @return the pop percentage
     */
    public int getPop() {
        return pop;
    }


    /**
     * This method gets the country field
     * 
     * @return the country percentage
     */
    public int getCountry() {
        return country;
    }


    /**
     * This method returns a string with the values of rock, pop, and country
     * 
     * @return a string containing the percentages of each genre is returned
     */
    public String toString() {
        return "Pop:" + getPop() + " Rock:" + getRock() + " Country:"
            + getCountry();
    }


    /**
     * This method checks if two genre sets are equal
     * 
     * @param obj
     *            is the object being compared to the current genre set
     * 
     * @return true is returned if the genre sets are equal to each other, and
     *         false is returned if the genre sets are not equal to each other
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            GenreSet gs = (GenreSet)obj;
            return (this.getPop() == gs.getPop()) && (this.getRock() == gs
                .getRock()) && (this.getCountry() == gs.getCountry());
        }
        else {
            return false;
        }
    }


    /**
     * The genre set is within range if it is between the minimum and maximum
     * genre set values
     * 
     * @param minGenreSet
     *            is the minimum genre set values to be within range
     * @param maxGenreSet
     *            is the maximum genre set values to be within range
     * 
     * @return true is returned if it is within the 2 param genre sets, and
     *         false if it is outside
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet) {
        boolean bottom = this.getPop() >= minGenreSet.getPop() && (this
            .getRock() >= minGenreSet.getRock()) && (this
                .getCountry() >= minGenreSet.getCountry());
        return bottom && isLessThanOrEqualTo(maxGenreSet);
    }


    /**
     * The genre set is less than or equal to the parameter genre
     * 
     * @param other
     *            is the genre set we are comparing the current genre set to
     * 
     * @return true is returned if it is less than or equal to the param genre
     *         set, and false otherwise
     */
    private boolean isLessThanOrEqualTo(GenreSet other) {
        return this.getPop() <= other.getPop() && (this.getRock() <= other
            .getRock()) && (this.getCountry() <= other.getCountry());
    }


    /**
     * This method compares the sum of the genre compositions of two genre sets
     * 
     * @param other
     *            is the genre set we are comparing the current genre set to
     * @return returns a negative value if the current genre set is less than
     *         the other genre set, returns a positive value if the current
     *         genre set is greater than the other genre set, and returns 0 if
     *         the current genre set is equal to the other genre set
     */
    @Override
    public int compareTo(GenreSet other) {
        int sumThis = this.getPop() + this.getRock() + this.getCountry();
        int sumOther = other.getPop() + other.getRock() + other.getCountry();

        if (sumThis < sumOther) {
            return -1;
        }
        else if (sumThis > sumOther) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
