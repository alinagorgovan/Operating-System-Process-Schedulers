/**
 * Metoda implementeaza tipul de proces Fibonacci.
 * 
 * @author Alina Gorgovan
 *
 */
public class Fibonacci extends ProcessTypes {

	/**
	 * Fibonacci constructor.
	 */
	public Fibonacci() {
		super();
	}

	/*
	 * @return numarul de pe pozitia n din sirul lui fibonnaci
	 * 
	 * @param n numar procesat
	 * 
	 * @see ProcessTypes#process(int)
	 */
	public int process(int n) {
		if (n < 0) {
			return -1;
		}
		int aux = 0;
		int n0 = 0;
		int n1 = 1;
		if (n == 0 | n == 1)
			return n;
		else {
			for (int i = 2; i <= n; i++) {
				aux = (n0 + n1) % 9973;
				n0 = n1;
				n1 = aux;
			}
		}
		return aux % 9973;
	}

}
