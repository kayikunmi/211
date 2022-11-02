import java.util.LinkedList;

public class ChainedHashSet<E> implements AmhHashSet<E> {

    private LinkedList<E>[] storage;
    private int             m;
    private int             n;
    private int             collisions;
    
    public ChainedHashSet (int capacity) {
        LinkedList[] storage = new LinkedList [capacity]; 
        for(int i =0; i< capacity; i++){
            storage[i] = new LinkedList<E>();
        }
        this.m = capacity;
        this.n = 0;
        this.storage = storage;
        collisions = 0;
    } // ChainedHashSet ()
    

    public boolean insert (E key) {
        //fnd out where its suposed to be
        int h = key.hashCode()%m;
        //if its not in the table, add it
        if (lookup(key)!= true) {
            //check for collision
            if(!storage[h].isEmpty()){
                collisions++;
            }
			storage[h].add(key);
            //increment size
			n++; 
            return true;
		}
        //if its already there, don't add
        else{
            return false;
        }
    } // insert ()



    public boolean lookup (E key) {
        //find where its supposed to be
        int h = key.hashCode()%m;
		if (storage[h].contains(key)) {
			return true;
		}
        else{
            return false;
        }

    } // lookup ()

    public boolean remove (E key) {
        //fnd out where its suposed to be
        int h = key.hashCode()%m;
        //if its in the list, remove it
        if (lookup(key) == true) {
            storage[h].remove(storage[h].indexOf(key));
            //decrement size
			n--;
            return true;
        }
        else{
            return false;
        }

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
