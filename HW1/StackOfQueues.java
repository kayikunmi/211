// ==============================================================================
//Kayikunmi Babatunde
// IMPORTS

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
// ==============================================================================



// ==============================================================================
/**
 * A stack implemented using queues.
 *
 * @author Scott Kaplan -- sfkaplan@amherst.edu
 * @date   Feb 2021
 */
public class StackOfQueues <E> implements AmhStack <E> {
// ==============================================================================


    
    // ==========================================================================
    /** The queue in which the stack's elements will be stored. */
    private AmhQueue<E> q1;
    private AmhQueue<E> q2;
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Constructor.  Create an empty stack.
     */
    public StackOfQueues () {

	// Specifically use a WrapperQueue, which is a type of AmhQueue, to
	// store the elements.
	q1 = new WrapperQueue<E>();
    q2 = new WrapperQueue<E>();

    } // StackOfQueues ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Add an element to the top of the stack.
     *
     * @param element The element to add to the stack.
     * @throws IllegalStateException if the stack cannot be expanded
     *                               to accomodate the additional element.
     */
    public void push (E element) throws IllegalStateException {

	// TO DO
    AmhQueue<E> q;
        q2.add(element);
        while (q1.size() != 0) {
            q2.add(q1.peek());
            q1.remove();
        }
        q = q1;
        q1 = q2;
        q2 = q;
	
    } // push ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Remove an element from the top of the stack.
     *
     * @return the element taken from the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */    
    public E pop () throws NoSuchElementException {

	// TO DO
        if (q1.size() == 0){
            return q1.peek();
        }
        return q1.remove();
    } // pop ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Obtain the top element on the stack without removing it.
     *
     * @return the element at the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    public E top () throws NoSuchElementException {

	// TO DO
        return q1.peek();
    } // top ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Provide the number of elements on the stack.
     *
     * @return the length of the stack.
     */
    public int size () {

	// TO DO
        return q1.size();
    } // size ()
    // ==========================================================================


    
// ==============================================================================
} // class StackOfQueues
// ==============================================================================
