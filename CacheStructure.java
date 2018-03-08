
/**
 * Clasa implementeaza structura unui element din memoria Cache.
 * 
 * @author Alina Gorgovan
 *
 */
public class CacheStructure {
	protected String processName;
	protected int in;
	protected int out;

	/**
	 * Cache constructor fara parametri.
	 */
	public CacheStructure() {
		super();
	}

	/**
	 * Construieste obiectul Cache cu parametrii processName, in si out.
	 * 
	 * @param processName 	numele procesului folosit
	 * @param in	numarul procesat
	 * @param out 	rezultatul
	 */
	public CacheStructure(String processName, int in, int out) {

		this.processName = processName;
		this.in = in;
		this.out = out;
	}

	/**
	 * @return tipul procesului folosit
	 */
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	/**
	 * @return numarul in din structura
	 */
	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	/**
	 * @return rezultatul procesului din structura
	 */
	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

}
