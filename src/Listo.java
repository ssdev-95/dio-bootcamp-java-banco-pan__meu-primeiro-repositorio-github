public class Listo<T> {
	private Nodo<T> lastNoduRef;

	public Listo() {
		this.lastNoduRef = null;
	}

	public void enqueue(T obj) {
		Nodo<T> nodu = new Nodo<>(obj);
		nodu.setNextNodo(lastNoduRef);
		this.lastNoduRef = nodu;
	}

	public T dequeue() {
		if(isEmpty()) return null;
	
		Nodo<T> firstNodu = this.lastNoduRef;
		Nodo<T> noduAux = this.lastNoduRef;

		while(true) {
			if(firstNodu.getNextNodo() != null) {
				noduAux = firstNodu;
				firstNodu = firstNodu.getNextNodo();
			} else {
				noduAux.setNextNodo(null);
				break;
			}
		}

		return firstNodu.getContent();
	}

	public T first() {
		if(isEmpty()) return null;

		Nodo<T> firstNodu = this.lastNoduRef;
		Nodo<T> noduAux = firstNodu.getNextNodo();

		while(true) {
			if(noduAux != null) {
				firstNodu = noduAux;
				noduAux = firstNodu.getNextNodo();
			} else {
				break;
			}
		}

		return firstNodu.getContent();
	}

	public boolean isEmpty() {
		return this.lastNoduRef == null;
	}

	@Override
	public String toString() {
		if(isEmpty()) return "null";

		Nodo<T> noduAux = this.lastNoduRef;
		String str = "{";

		while(noduAux != null) {
			str += " " + noduAux.getContent() + " --> ";
			noduAux = noduAux.getNextNodo();
		}

		str += noduAux + " }";

		return str;
	}
}
