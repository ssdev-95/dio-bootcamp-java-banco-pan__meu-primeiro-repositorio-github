





import com.saloma.tech.DoubleLinkedListo;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedListo<Object> listo;
		listo = new DoubleLinkedListo<>();

		listo.add(3);
		listo.add(5);

		System.out.println(listo.size());
	}
}
