
/**
 * implementeaza un element din memoria de tipul Lfu Cache
 * 
 * @author Alina Gorgovan
 *
 */
public class LfuCacheStructure extends CacheStructure {
	/**
	 * variabila ce retine numarul de utilizari a procesului respectiv
	 */
	int freq = 0;

	/**
	 * LfuCacheStructure constructor fara parametri
	 */
	public LfuCacheStructure() {
		super();
	}

	/**
	 * LfuCacheStructure constructor cu parametri
	 * 
	 * @param processName
	 *            numele procesului folosit
	 * @param in
	 *            numarul procesat
	 * @param out
	 *            rezultatul
	 */
	public LfuCacheStructure(String processName, int in, int out) {
		super(processName, in, out);
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

}
