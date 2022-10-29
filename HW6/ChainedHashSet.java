import java.util.LinkedList;

public class ChainedHashSet<E> implements AmhHashSet<E> {

    private LinkedList<E>[] storage;
    private int             m;
    private int             n;
    private int             collisions;
    
    public ChainedHashSet (int capacity) {

    } // ChainedHashSet ()

    public boolean insert (E key) {
        return false;

    } // insert ()

    public boolean lookup (E key) {
        return false;

    } // lookup ()

    public boolean remove (E key) {
        return false;

    }

    public int size () {

	return n;

    }

    public int getNumberCollisions () {

	return collisions;

    }

    private int hash (E key) {

	return key.hashCode();
	
    }

} // class ChainedHashSet
