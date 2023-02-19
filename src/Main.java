



public class Main {
	public static void main(String[] args) {
		LinkedListo<Object> listo = new LinkedListo<>();

		for(int i=0; i<6; i++) { listo.add(i); }
		System.out.println(listo);

		listo.remove(2);
		System.out.println(listo);

		listo.remove(3);
		System.out.println(listo);

		listo.remove(0);

		System.out.println(listo);
	}
}
