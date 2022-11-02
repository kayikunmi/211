import java.util.LinkedList;

public class ChainedHashSet<E> implements AmhHashSet<E> {

    private LinkedList<E>[] storage;
    private int             m;
    private int             n;
    private int             collisions;
    
    public ChainedHashSet (int capacity) {
        this.m =capacity;
        this.storage=storage;
    } // ChainedHashSet ()
    

    public boolean insert (E key) {
        return false;

    } // insert ()

    public boolean lookup (E key) {
        int h = hash(key);
		LinkedList current = storage[h];
		if (current.contains(key)) {
			return true;
		}
        else{
            return false;
        }

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
