// ==============================================================================
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
    while (!s1.isEmpty()) {
        s2.push(s1.pop());
    }

    // push item into the first stack
    s1.push(element);

    // Move all elements back to the first stack from the second stack
    while (!s2.isEmpty()) {
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
    if (s1.isEmpty())
    {
        System.out.println("Underflow!!");
        System.exit(0);
    }

    // return the top item from the first stack
    return s1.pop();
	
    } // remove ()
    // ==========================================================================


    
    // ==========================================================================
    public E peek () throws NoSuchElementException {

	// TO DO
    if (s1.isEmpty()) {
        throw new NoSuchElementException("Queue underflow");
    }
    else {
        return s1.peek();
    }

    } // peek ()
    // ==========================================================================


    
    // ==========================================================================
    public int size () {

	// TO DO
    return s1.size() + s2.size();
	
    } // size ()
    // ==========================================================================


    
// ==============================================================================
} // class QueueOfStacks
// ==============================================================================
