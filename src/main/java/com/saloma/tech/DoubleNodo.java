package com.saloma.tech;

public class DoubleNodo<T> {
	private T content;
	private DoubleNodo<T> prevNodo;
	private DoubleNodo<T> nextNodo;

	public DoubleNodo(T content) {
		setContent(content);
		this.prevNodo = null;
		this.nextNodo = null;
	}

	public T getContent() { return this.content; }
	public void setContent(T content) { this.content = content; }

	public DoubleNodo<T> getPrevNodo() { return this.prevNodo; }
	public void setPrevNodo(DoubleNodo<T> nodo) {
		this.prevNodo = nodo;
	}

	public DoubleNodo<T> getNextNodo() { return this.nextNodo; }
	public void setNextNodo(DoubleNodo<T> nodo) {
		this.nextNodo = nodo;
	}

	@Override
	public String toString() { return "Nodo{" + this.content + "}"; }
}
