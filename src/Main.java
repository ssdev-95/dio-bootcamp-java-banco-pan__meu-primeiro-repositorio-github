



public class Main {
	public static void main(String[] args) {
		LinkedListo<Object> listo = new LinkedListo<>();

		for(int i=0; i<6; i++) { listo.add(i); }
		System.out.println(listo);

		// TODO: Removes list item at index 3;
		listo.remove(3);
		System.out.println(listo);
	}
}
