import com.saloma.tech.RoundedListo;

public class Main {
	public static void main(String[] args) {
		RoundedListo<Integer> listo = new RoundedListo<>();

		for(int i = 0; i < 10; i++) {
			listo.add(i+1);
		}

		System.out.println(listo);

		try {
			listo.remove(3);
			System.out.println(listo);

			listo.remove(listo.size() - 1);
			System.out.println(listo);
			System.out.println(listo.size());
		} catch(Exception exception) {
			System.out.println(exception);
		}
	}
}
