package com.saloma.tech;

public class LinkedListo<T> {
	private Nodo<T> entryReference;

	public LinkedListo() { this.entryReference = null; }

	public void add(T content) {
		Nodo<T> newNodo = new Nodo<>(content);

		if(isEmpty()) {
			this.entryReference = newNodo;
			return;
		}

		Nodo<T> nodoRefAux = this.entryReference;
		for(int i = 0; i < this.size()-1; i++) {
			nodoRefAux = nodoRefAux.getNextNodo();
		}

		nodoRefAux.setNextNodo(newNodo);
	}

	public T remove(int index)
			throws IndexOutOfBoundsException {
		Nodo<T> pivotNodo = getNodo(index);
		T content = pivotNodo.getContent();

		if(index == 0) {
			this.entryReference = pivotNodo.getNextNodo();
			return content;
		}

		Nodo<T> prevNodo = getNodo(index - 1);
		prevNodo.setNextNodo(pivotNodo.getNextNodo());

		return content;
	}

	public T get(int index) {
		if(isEmpty()) { return null; }
		return getNodo(index).getContent();
	}

	private Nodo<T> getNodo(int index)
			throws IndexOutOfBoundsException {
		validateIndex(index);

		Nodo<T> nodoRefAux = this.entryReference;

		for(int idx = 0; idx < index; idx++) {
			nodoRefAux = nodoRefAux.getNextNodo();
		}

		return nodoRefAux;
	}

	private void validateIndex(int index)
			throws IndexOutOfBoundsException {
		if(index >= size() || index < 0) {
			String log = "No nodo found for index " + index + "!";
			throw new IndexOutOfBoundsException(log);
		}
	}

	public int size() {
		Integer _size = 0;
		Nodo<T> nodoRefAux = this.entryReference;

		while(nodoRefAux != null) {
			_size++;

			if(nodoRefAux.getNextNodo() == null) { break; }

			nodoRefAux = nodoRefAux.getNextNodo();
		}

		return _size;
	}

	public boolean isEmpty() { return this.entryReference == null; }

	@Override
	public String toString() {
		String str = "{ ";

		if(isEmpty()) { return "null"; }

		Nodo<T> nodoRefAux = this.entryReference;
		
		while(nodoRefAux != null) {
			str += nodoRefAux + " --> ";
			nodoRefAux = nodoRefAux.getNextNodo();
		}

		str += "null }";

		return str;
	}
}
