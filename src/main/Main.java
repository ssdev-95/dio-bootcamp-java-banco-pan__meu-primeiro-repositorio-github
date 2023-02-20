





import com.saloma.tech.DoubleLinkedListo;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedListo<Object> listo;
		listo = new DoubleLinkedListo<>();

		try {
			listo.add(3);
  		listo.add(5);
			listo.add(999);
  		System.out.println(listo);

			listo.remove(1);
			System.out.println(listo);
		} catch(Exception exception) {
			System.out.println(exception);
		}
	}
}
