package com.saloma.tech;

public class RoundedListo<T> {
	private Nodo<T> _head;
	private Nodo<T> _tail;
	private Integer _size;

	public RoundedListo() {
		this._head = null;
		this._tail = null;
		this._size = 0;
	}

	public void add(T element) {
		Nodo<T> newNodo = new Nodo<>(element);

		if(isEmpty()) {
			this._head = newNodo;
			this._tail = this._head;
			this._head.setNextNodo(this._tail);
		} else {
			newNodo.setNextNodo(this._tail);
			this._head.setNextNodo(newNodo);
			this._tail = newNodo;
		}

		this._size++;
	}

	public void remove(int index) throws IndexOutOfBoundsException {
		if(isEmpty()) {
			String log = "Cannot remove elements of empty list.";
			throw new IndexOutOfBoundsException(log);
		}

		if(index == this._size) {
			String log = "No nodo found for index " + index + "!";
			throw new IndexOutOfBoundsException(log);
		}

		Nodo<T> nodoAux = this._tail;

		if(index == 0) {
			this._tail = nodoAux.getNextNodo();
			this._head.setNextNodo(this._tail);
		} else if(index == 1) {
			this
				._tail
				.setNextNodo(this._tail.getNextNodo().getNextNodo());
		} else {
			for(int i = 0; i < index-1; i++) {
				nodoAux = nodoAux.getNextNodo();
			}

			nodoAux
				.setNextNodo(nodoAux.getNextNodo().getNextNodo());
		}

		this._size--;
	}

	public T get(int index) throws IndexOutOfBoundsException {
		return this.getNodo(index).getContent();
	}

	public Nodo<T> getNodo(int index)
			throws IndexOutOfBoundsException {
		if(isEmpty()) {
		  return null;
		}

		if(index == 0) { return _tail; }

		if(index == _size - 1) { return _head; }

		validateIndex(index);

		Nodo<T> nodoAux = _tail;

		for(int i = 0; (i < index) && (nodoAux != null); i++) {
			nodoAux = nodoAux.getNextNodo();
		}

		return nodoAux;
	}

	public void validateIndex(int index)
			throws IndexOutOfBoundsException {
		String log = "No nodo found for index " + index + "!";

		if(index < 0 || index > _size) {
			throw new IndexOutOfBoundsException(log);
		}
	}

	public boolean isEmpty() { return this._size == 0; }

	public int size() { return this._size; }

	@Override
	public String toString() {
		String str = "[";
		Nodo<T> nodoAux = this._tail;

		for(int i = 0; (i < this._size) && (nodoAux != _head); i++) {
			str += nodoAux + "-->";
			nodoAux = nodoAux.getNextNodo();
		}

		str += nodoAux + "]";

		return str;
	}
}
