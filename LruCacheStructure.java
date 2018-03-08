
/**
 * Implementeaza structura unui element din memoria cache de tipul Lru.
 * 
 * @author Alina Gorgovan
 *
 */
public class LruCacheStructure extends CacheStructure {

	/**
	 * LruCacheStructure constructor fara parametri
	 */
	public LruCacheStructure() {
		super();
	}

	/**
	 * LruCacheStructure constructor cu parametri
	 * 
	 * @param processName tip proces
	 * @param in	numar procesat
	 * @param out	rezultatul procesului
	 */
	public LruCacheStructure(String processName, int in, int out) {
		super(processName, in, out);
	}

}
