





package com.saloma.tech;

public class DoubleLinkedListo<T> {
	private DoubleNodo<T> firstNodoRef;
	private DoubleNodo<T> lastNodoRef;
	private Integer _size;

	public DoubleLinkedListo() {
		this.firstNodoRef = null;
		this.lastNodoRef = null;
		this._size = 0;
	}

	public void add(T element) {
		DoubleNodo<T> newNodo = new DoubleNodo<>(element);
		newNodo.setNextNodo(null);
		newNodo.setPrevNodo(lastNodoRef);

		if(isEmpty()) {
			this.firstNodoRef = newNodo;
		}

		if(lastNodoRef != null) {
			this.lastNodoRef.setNextNodo(newNodo);
		}
	
		this.lastNodoRef = newNodo;
		this._size++;
	}

	public void add(int index, T element)
			throws IndexOutOfBoundsException {
		DoubleNodo<T> newNodo = new DoubleNodo<>(element);
		DoubleNodo<T> nodoAux = getNodo(index);
		newNodo.setNextNodo(nodoAux);

		if(newNodo.getNextNodo() != null) {
			newNodo.setPrevNodo(nodoAux.getPrevNodo());
			newNodo.getPrevNodo().setNextNodo(newNodo);
		} else {
			newNodo.setPrevNodo(lastNodoRef);
			lastNodoRef = newNodo;
		}

		if(index == 0) {
			firstNodoRef = newNodo;
		} else {
			newNodo.getPrevNodo().setNextNodo(newNodo);
		}

		this._size++;
	}

	public void remove(int index) throws IndexOutOfBoundsException {
		validateIndex(index);

		if(index == 0) {
			firstNodoRef = firstNodoRef.getNextNodo();

			if(firstNodoRef != null) {
				firstNodoRef.setPrevNodo(null);
			}
		} else {
			DoubleNodo<T> nodoAux = getNodo(index);
			nodoAux.getPrevNodo().setNextNodo(nodoAux.getNextNodo());
			if(nodoAux != lastNodoRef) {
				nodoAux.getNextNodo().setPrevNodo(nodoAux.getPrevNodo());
			} else {
				lastNodoRef = nodoAux;
			}
		}

		_size--;
	}

	public T get(int index) throws IndexOutOfBoundsException {
		return getNodo(index).getContent();
	}

	private DoubleNodo<T> getNodo(int index)
			throws IndexOutOfBoundsException {
		validateIndex(index);
		DoubleNodo<T> nodoAux = null;

		for(int i = 0; (i < index) && (nodoAux != null); i++) {
			nodoAux = nodoAux.getNextNodo();
		}

		return nodoAux;
	}

	private void validateIndex(int index)
			throws IndexOutOfBoundsException {
		if(index<0||index>size()) {
			String log = "No nodo found for index " + index + "!";
			throw new IndexOutOfBoundsException(log);
		}
	}

	public int size() { return this._size; }

	public boolean isEmpty() { return this.firstNodoRef == null; }

	@Override
	public String toString() {
		DoubleNodo<T> nodo = firstNodoRef;
		String str = "[null-->";

		for(int i = 0; i < _size; i++) {
			if(nodo != null) {
			  str += nodo + "-->";
				nodo = nodo.getNextNodo();
			}
		}

		str += nodo + "]";

		return str;
	}
}
