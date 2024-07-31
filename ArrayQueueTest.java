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
 * This class tests the ArrayQueue class
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 10.30.23
 */
public class ArrayQueueTest extends TestCase {

    private ArrayQueue<String> aq;
    private ArrayQueue<String> aq1;
    private ArrayQueue<String> aq3;
    private ArrayQueue<String> aq4;

    /**
     * This method makes the array queues to help tests the methods
     */
    public void setUp() {
        aq = new ArrayQueue<String>();
        aq1 = new ArrayQueue<String>(3);
        aq3 = new ArrayQueue<String>();
        aq4 = null;

    }


    /**
     * This tests the getSize method
     */
    public void testGetSize() {
        assertEquals(0, aq1.getSize());
        aq1.enqueue("a");
        assertEquals(1, aq1.getSize());
        aq1.enqueue("b");
        assertEquals(2, aq1.getSize());
        aq1.enqueue("c");
        assertEquals(3, aq1.getSize());
    }


    /**
     * This tests the getLengthOfUnderlyingArray method
     */
    public void testGetLengthOfUnderlyingArray() {
        assertEquals(4, aq1.getLengthOfUnderlyingArray());
        assertEquals(21, aq.getLengthOfUnderlyingArray());
    }


    /**
     * This tests the ensureCapacity, enqueue, and clear methods
     */
    public void testEnsureCapacityAndEnqueueAndClear() {
        assertEquals(4, aq1.getLengthOfUnderlyingArray());
        aq1.enqueue("a");
        aq1.enqueue("b");
        aq1.enqueue("c");
        assertEquals(4, aq1.getLengthOfUnderlyingArray());

        aq1.enqueue("d");
        assertEquals(7, aq1.getLengthOfUnderlyingArray());
        aq1.enqueue("e");
        aq1.enqueue("f");
        aq1.enqueue("g");
        assertEquals(13, aq1.getLengthOfUnderlyingArray());

        assertEquals(7, aq1.getSize());
        aq1.clear();
        assertEquals(0, aq1.getSize());
        assertEquals(21, aq1.getLengthOfUnderlyingArray());
    }


    /**
     * This tests the toArray method
     */
    public void testToArray() {
        Exception thrown = null;
        try {
            aq1.toArray();
        }
        catch (EmptyQueueException e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyQueueException);

        aq1.enqueue("a");
        aq1.enqueue("b");
        aq1.enqueue("c");

        Object[] resultArray = aq1.toArray();
        assertEquals(3, resultArray.length);

        assertEquals("a", resultArray[0]);
        assertEquals("b", resultArray[1]);
        assertEquals("c", resultArray[2]);

        // assertEquals(expectedArray, resultArray);
    }


    /**
     * This tests the toString method
     */
    public void testToString() {
        assertEquals("[]", aq1.toString());
        assertEquals(0, aq1.getSize());
        aq1.enqueue("a");
        assertEquals(1, aq1.getSize());
        aq1.enqueue("b");
        assertEquals(2, aq1.getSize());
        aq1.enqueue("c");
        assertEquals(3, aq1.getSize());
        assertEquals(4, aq1.getLengthOfUnderlyingArray());

        assertEquals("[a, b, c]", aq1.toString());
    }


    /**
     * This tests the equals method() {
     */
    public void testEquals() {
        assertTrue(aq.equals(aq));
        aq.enqueue("a");
        aq1.enqueue("b");
        aq3.enqueue("a");
        assertFalse(aq1.equals(aq3));
        assertTrue(aq.equals(aq3));
        assertFalse(aq.equals(aq4));

        Object obj = new Object();
        assertFalse(aq1.equals(obj));

        aq3.enqueue("a");
        assertFalse(aq1.equals(aq3));
    }


    /**
     * This tests the dequeue method
     */
    public void testDequeue() {
        Exception thrown = null;
        try {
            aq1.dequeue();
        }
        catch (EmptyQueueException e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyQueueException);

        aq1.enqueue("a");
        aq1.enqueue("b");
        aq1.enqueue("c");

        assertEquals(3, aq1.getSize());
        assertEquals("[a, b, c]", aq1.toString());

        aq1.dequeue();
        assertEquals("[b, c]", aq1.toString());
        assertEquals(2, aq1.getSize());

        aq1.dequeue();
        assertEquals(1, aq1.getSize());
        assertEquals("[c]", aq1.toString());

        aq1.dequeue();
        assertEquals(0, aq1.getSize());
        assertEquals("[]", aq1.toString());
    }


    /**
     * This method tests the exception for the getFront method
     */
    public void testGetFront() {
        Exception thrown = null;
        try {
            aq1.getFront();
        }
        catch (EmptyQueueException e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyQueueException);
    }

}
