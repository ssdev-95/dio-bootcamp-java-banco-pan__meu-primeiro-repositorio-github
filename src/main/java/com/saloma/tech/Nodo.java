package com.saloma.tech;

public class Nodo<T extends Object> {
	private T content;
	private Nodo<T> nextNodo;

	public Nodo (T content) {
		this.content = content;
		this.nextNodo = null;
	}

	public void setNextNodo(Nodo<T> nodo) { this.nextNodo = nodo; }

	public Nodo<T> getNextNodo() { return nextNodo; }

	public void setContent(T content) { this.content = content; }

	public T getContent() { return content; }

	@Override
	public String toString() {
		return String.format("%1s", this.content);
	}
}
