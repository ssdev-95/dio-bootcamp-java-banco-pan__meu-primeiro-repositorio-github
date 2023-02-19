package com.saloma.tech;

public class Stacko<T> {
	private Nodo<T> topStackNodoRef;

	public Stacko() { this.topStackNodoRef = null; }

	public void push(Nodo<T> nodo) {
		nodo.setNextNodo(this.topStackNodoRef);
		this.topStackNodoRef = nodo;
	}

	public Nodo<T> pop() {
		Nodo<T> nodoRefAux = this.topStackNodoRef;
		this.topStackNodoRef = nodoRefAux.getNextNodo();
		return nodoRefAux;
	}

	public Nodo<T> top() { return this.topStackNodoRef; }

	@Override
	public String toString() {
		Nodo<T> nodoRefAux = this.topStackNodoRef;
		String rowPlaceholder = "==============\n     Stack\n--------------\n";

		while(nodoRefAux != null) {
			rowPlaceholder += (nodoRefAux + "\n");
			nodoRefAux = nodoRefAux.getNextNodo();
		}

		rowPlaceholder += "==============";
		
		return rowPlaceholder;
	}
}
