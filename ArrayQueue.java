// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nimay Goradia (ngoradia)

package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * This class creates an Array Queue which contains the songs
 * 
 * @author Nimay Goradia (ngoradia)
 * @version 10.30.23
 * 
 * @param <T>
 *            takes any generic type for the array queue
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    /**
     * The default capacity of the array queue is 20
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    /**
     * This is the constructor that takes an integer to set the size of the
     * ArrayQueue
     * 
     * @param capacity
     *            is the length of the array which is one more than the capacity
     *            to make sure that there is one extra space
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        T[] tempQueue = (T[])new Object[capacity + 1];
        queue = tempQueue;
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
        size = 0;
    }


    /**
     * This is the constructor that takes the default capacity and creates the
     * ArrayQueue
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * This method returns the number of items stored in the queue
     * 
     * @return the size of the array queue
     */
    public int getSize() {
        return size;
    }


    /**
     * This method gets the length of the underlining array
     * 
     * @return the length of the ArrayQueue
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }


    /**
     * This method upgrades the length of the array when the queue is full
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        T[] newQueue = (T[])new Object[getSize() * 2 + 1];

        for (int i = 0, j = dequeueIndex; i < getSize(); j = incrementIndex(
            j), i++) {
            newQueue[i] = queue[j];
        }
        queue = newQueue;
        dequeueIndex = 0;
        enqueueIndex = getSize() - 1;
    }


    /**
     * This method helps increment the index for other classes
     * 
     * @param index
     *            is the index that we want to increment
     * 
     * @return the new index is returned
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * This method resets the queue to the default capacity constructor
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = DEFAULT_CAPACITY;
        size = 0;
    }


    /**
     * This method turns the ArrayQueue into an Array
     * 
     * @return the array that is a copy of the data from the ArrayQueue is
     *         returned
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] arr = new Object[getSize()];

        int current = dequeueIndex;
        for (int i = 0; i < getSize(); i++) {
            arr[i] = queue[current];
            current = incrementIndex(current);
        }
        return arr;
    }


    /**
     * This method turns ArrayQueue into a string
     * 
     * @return the string that is a copy of the data from the ArrayQueue is
     *         returned
     */
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        Object[] strToArr = toArray();
        String str = "[";

        for (int i = 0; i < strToArr.length - 1; i++) {
            str += strToArr[i].toString() + ", ";
        }
        str += strToArr[strToArr.length - 1].toString() + "]";
        return str;
    }


    /**
     * This method checks if two ArrayQueues are equal to each other
     * 
     * @param obj
     *            is the other ArrayQueue being compared to the current
     *            ArrayQueue
     * 
     * @return true is returned if the array queues are equal to each other, and
     *         false is returned if the array queues are not equal to each other
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ArrayQueue<?> otherQueue = (ArrayQueue<?>)obj;
        if (getSize() != otherQueue.getSize()) {
            return false;
        }

        int thisCurr = dequeueIndex;
        int otherCurr = otherQueue.dequeueIndex;
        for (int i = 0; i < getSize(); i++) {
            if (!queue[thisCurr].equals(otherQueue.queue[otherCurr])) {
                return false;
            }
            thisCurr = incrementIndex(thisCurr);
            otherCurr = otherQueue.incrementIndex(otherCurr);
        }
        return true;
    }


    /**
     * This methods checks if the array queue is full
     * 
     * @return true is returned if the array queue is full, and false is
     *         returned if it is not full
     */
    private boolean isFull() {
        return getSize() == queue.length - 1;
    }


    /**
     * This method dequeues a song from the front of the array queue
     * 
     * @return the item that is removed is returned
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T removedItem = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return removedItem;

    }


    /**
     * This method enqueues a new song into the array queue
     * 
     * @param song
     *            is the song that is being added to the array queue
     */
    @Override
    public void enqueue(T song) {
        if (isFull()) {
            ensureCapacity();
        }
        enqueueIndex = incrementIndex(enqueueIndex);
        this.queue[enqueueIndex] = song;
        size++;
    }


    /**
     * Gets the front of the queue
     * 
     * @throws EmptyQueueException
     * @return the front of the queue
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * This method checks if the array queue is empty
     * 
     * @return true is returned if the array queue is empty, and false is
     *         returned if it is not empty
     */
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

}
