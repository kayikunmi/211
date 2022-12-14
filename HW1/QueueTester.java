// ==============================================================================
// IMPORTS

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
// ==============================================================================



// ==============================================================================
/**
 * Test implementation of an {@interface AmhQueue} against a known, correct
 * implementation.
 *
 * @author Scott Kaplan -- sfkaplan@amherst.edu
 * @date   Feb 2021
 */
public class QueueTester {
// ==============================================================================


    
    // ==========================================================================
    public static void main (String[] args) {

	// Make one QueueOfStacks to test, and one WrapperQueue to test it
	// against.
	AmhQueue<Integer> testQueue      = new QueueOfStacks<Integer>();
	AmhQueue<Integer> referenceQueue = new WrapperQueue<Integer>();

	// Do some enqueuing.
	enqueue(testQueue, referenceQueue, 1);
	enqueue(testQueue, referenceQueue, 2);
	enqueue(testQueue, referenceQueue, 3);
	
	// Do some dequeuing.
	dequeue(testQueue, referenceQueue);
	dequeue(testQueue, referenceQueue);
	dequeue(testQueue, referenceQueue);

	// Try to dequeue one item too many.
	dequeue(testQueue, referenceQueue);
	
    } // main ()
    // ==========================================================================



    // ==========================================================================
    private static void enqueue (	AmhQueue<Integer> testQueue,
				 					AmhQueue<Integer> referenceQueue,
				 					Integer value) {

	// Insert the value into the reference queue.
	boolean referenceSuccess;
	try {
	    referenceQueue.add(value);
	    referenceSuccess = true;
	} catch (IllegalStateException e) {
	    referenceSuccess = false;
	}

	// Insert the value into the test queue.
	boolean testSuccess;
	try {
	    testQueue.add(value);
	    testSuccess = true;
	} catch (IllegalStateException e) {
	    testSuccess = false;
	}

	// Did both succeed/fail in the same way?
	if (referenceSuccess != testSuccess) {
	    System.err.printf("enqueue success mismatch: adding %d, test = %b, ref = %b\n",
			      value,
			      testSuccess,
			      referenceSuccess);
	}
	if(testSuccess == referenceSuccess){
		System.out.println("Successfully Enqueued");
	}
	
    } // enqueue ()
    // ==========================================================================



    // ==========================================================================
    private static void dequeue (AmhQueue<Integer> testQueue,
				 AmhQueue<Integer> referenceQueue) {


	// Dequeue from the reference queue.
	boolean referenceSuccess;
	int     referenceValue = 0;
	try {
	    referenceValue   = referenceQueue.remove();
	    referenceSuccess = true;
	} catch (NoSuchElementException e) {
	    referenceSuccess = false;
	}

	// Dequeue from the test queue.
	boolean testSuccess;
	int     testValue = 0;
	try {
	    testValue   = testQueue.remove();
	    testSuccess = true;
	} catch (NoSuchElementException e) {
	    testSuccess = false;
	}

	// Did both succeed/fail the same way?
	if (referenceSuccess != testSuccess) {
	    System.err.printf("dequeue success mismatch: test = %b, ref = %b\n",
			      testSuccess,
			      referenceSuccess);
	} 
	else {

	    // If they succeeded, did the values match?
	    if (testSuccess && (testValue != referenceValue)) {
		System.err.printf("dequeue value mismatch: test = %d, ref = %b\n",
				  testValue,
				  referenceValue);
	    }

	}
	if(testSuccess == referenceSuccess){
		System.out.println("Successfully Dequeued");
	}
	
    } // dequeue ()
    // ==========================================================================


    
// ==============================================================================
} // class QueueTester
// ==============================================================================
