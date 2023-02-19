





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

		if( firstNodoRef == null) {
			this.firstNodoRef = newNodo;
		}

		if(lastNodoRef != null) {
			this.lastNodoRef.setNextNodo(newNodo);
		}
	
		this.lastNodoRef = newNodo;
		this._size++;
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
		if(index>0||index>size()) {
			String log = "No nodo found for index " + index + "!";
			throw new IndexOutOfBoundsException(log);
		}
	}

	public int size() { return this._size; }
}