public class AmhArrayList<E> implements AmhList<E> {

	private Object[] _storage;
	private int _size;

	public AmhArrayList() {
		_storage = new Object[0];
		_size = 0;
	} // AmhArrayList ()

	public void add(int index, E element) throws IndexOutOfBoundsException,
			IllegalStateException {
		if (index < 0 || _size < index) {
			throw new IndexOutOfBoundsException(index);
		}
		_size += 1;
		if (_size >= _storage.length) {
			try {
				expandCapacity();
			} catch (OutOfMemoryError e) {
				throw new IllegalStateException("Allocation failed");
			}
		}
		for (int i = _size - 1; i > index; i -= 1) {
			_storage[i] = _storage[i - 1];
		}
		_storage[index] = element;
	} // add ()

	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || _size <= index) {
			throw new IndexOutOfBoundsException(index);
		}
		return (E) _storage[index];
	} // get ()

	public E remove(int index) throws IndexOutOfBoundsException {
		System.out.println("TESTING");
		if (index < 0 || _size <= index) {
			throw new IndexOutOfBoundsException(index);
		}
		_size -= 1;
		E element = (E) _storage[index];//i can't remove the last index
		// if (index == _size){ //removing the last index?
		// 	Object[] removeIndex = new Object[_size];
		// 	for (int i = 0; i < _storage.length; i += 1) {
		// 		removeIndex[i] = _storage[i];
		// 	}
		// 	_storage = removeIndex;
		// }
		for (int i = index; i < _size; i ++ ) {
			_storage[i] = _storage[i + 1];
		}
		return element;
	} // remove ()

	public E set(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || _size <= index) {
			throw new IndexOutOfBoundsException(index);
		}
		E oldElement = (E) _storage[index];
		_storage[index] = element;
		return oldElement;
	} // set ()

	public int size() {
		return _size;
	} // size ()

	private void expandCapacity() {
		// size is 0, so you can't do (0*2) bc that's 0
		// is length bigger than one?
		int changeLength = 1;
		if (_storage.length < 1) {
			changeLength = 1;
		} 
		else {
			changeLength = _storage.length;
		}
		Object[] newStorage = new Object[changeLength * 2];
			for (int i = 0; i < _storage.length; i += 1) {
				newStorage[i] = _storage[i];
			}
			_storage = newStorage;
	} // expandCapacity ()

} // AmhArrayList