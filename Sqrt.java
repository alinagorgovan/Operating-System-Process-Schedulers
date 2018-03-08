
/**
 * Clasa implementeaza tipul de proces Sqrt.
 * 
 * @author Alina Gorgovan
 *
 */
public class Sqrt extends ProcessTypes {

	/**
	 * Constructor fara parametri
	 */
	public Sqrt() {
		super();
	}

	/*
	 * @return radical din n
	 * 
	 * @see ProcessTypes#process(int)
	 */
	public int process(int n) {
		double a = Math.sqrt(Math.abs(n));
		double parteFract = a % 1;
		double parteIntreaga = a - parteFract;
		return (int) parteIntreaga;
	}

}
