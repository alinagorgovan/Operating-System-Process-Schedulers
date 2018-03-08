/**
 * Metoda implementeaza tipul de proces Cube.
 * 
 * @author Alina Gorgovan
 * 
 */
public class Cube extends ProcessTypes {

	/**
	 * Cube constructor.
	 */
	public Cube() {
		super();
	}

	/*
	 * @return cubul numarului n
	 * 
	 * @see ProcessTypes#process(int)
	 */
	public int process(int n) {
		return n * n * n;
	}

}
