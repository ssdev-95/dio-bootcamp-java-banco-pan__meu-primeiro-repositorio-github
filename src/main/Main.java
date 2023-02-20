import com.saloma.tech.DoubleLinkedListo;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedListo<Integer> listo;
		listo = new DoubleLinkedListo<>();

		try {
			for(int i = 0; i < 4; i++) {
				listo.add(i);
			}

  		System.out.println(listo);

			listo.add(2, 1024);
			System.out.println(listo);

			listo.remove(1);
			System.out.println(listo);
		} catch(Exception exception) {
			System.out.println(exception);
		}
	}
}
