/**
 * Metoda implementeaza tipul de proces NextPrime.
 * 
 * @author Alina Gorgovan
 *
 */
public class NextPrime extends ProcessTypes {

	/**
	 * Constructor fara parametri
	 */
	public NextPrime() {
		super();
	}

	/*
	 * Returneaza urmatorul numar prim dupa n
	 * 
	 * @see ProcessTypes#process(int)
	 */
	public int process(int n) {
		if (n < 2) {
			return 2;
		}
		n++;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				n++;
				i = 2;
			} else
				continue;
		}
		return n;
	}
}
