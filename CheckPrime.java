/**
 * Metoda implementeaza tipul de proces CheckPrime.

 * @author Alina Gorgovan
 *
 */
public class CheckPrime extends ProcessTypes{
	
	
	/**
	 * CheckPrime constructor fara parametri
	 */
	public CheckPrime() {
		super();
	}
	/**
	 * @return 0 daca nu este prim si 1 daca este
	 * @see ProcessTypes#process(int)
	 */
	public int process(int n) {
		if (n < 2) {
			return 0;
		} else {
			for (int i = 2; i < n / 2 + 1; i++) {
				if (n % i == 0)
					return 0;
			}
		}
		return 1;
	}
}
