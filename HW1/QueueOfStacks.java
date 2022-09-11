// ==============================================================================
//Kayikunmi Babatunde
// IMPORTS

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
// ==============================================================================



// ==============================================================================
/**
 * A queue implemented using stacks.
 *
 * @author Scott Kaplan -- sfkaplan@amherst.edu
 * @date   Feb 2021
 */
public class QueueOfStacks <E> implements AmhQueue <E> {
// ==============================================================================


    
    // ==========================================================================
    /** The stack in which the queue's elements will be stored. */
    private AmhStack<E> s1;
    private AmhStack<E> s2;
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Constructor.  Create an empty queue.
     */
    public QueueOfStacks () {

	// Specifically use a WrapperStack, which is a type of AmhStack, to
	// store the elements.
	s1 = new WrapperStack<E>();
    s2 = new WrapperStack<E>();

    } // StackOfQueues ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Add an element to the tail of the queue.
     *
     * @param element The element to add to the queue.
     * @throws IllegalStateException if the queue cannot be expanded
     *                               to accomodate the additional element.
     */
    public void add (E element) throws IllegalStateException {

	// TO DO
        while (s1.size()!=0) {
            s2.push(s1.pop());
        }
        s1.push(element);

        while (s2.size()!=0) {
            s1.push(s2.pop());
        }
    } // add ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Remove an element from the head of the queue.
     *
     * @return the element taken from the head of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E remove () throws NoSuchElementException {

	// TO DO
        if (s1.size()==0) {
            throw new NoSuchElementException("ERROR: Queue is Empty");
        }
        else {
            return s1.pop();
        }
    } // remove ()
    // ==========================================================================


    
    // ==========================================================================
    public E peek () throws NoSuchElementException {

	// TO DO
        if (s1.size()==0) {
            throw new NoSuchElementException("ERROR: Queue is Empty");
        }
        else {
            return s1.top();
        }
    } // peek ()
    // ==========================================================================


    
    // ==========================================================================
    public int size () {

	// TO DO
        if (s1.size()==0) {
            throw new NoSuchElementException("ERROR: Queue is Empty");
        }
        else {
            return s1.size() + s2.size();
        }
	
    } // size ()
    // ==========================================================================


    
// ==============================================================================
} // class QueueOfStacks
// ==============================================================================
