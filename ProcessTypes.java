
/**
 * @author Alina Gorgovan
 *
 */
public abstract class ProcessTypes {
	
	/**
	 * Constructor fara parametri
	 */
	public ProcessTypes() {
		super();
	}

	/**
	 * Proceseaza numarul n in functie de numele procesului.
	 * @param n numar procesat
	 * @return rezultatul procesului
	 */
	public abstract int process(int n);

}
