import java.util.ArrayList;

/**
 * Implementeaza tipul de memorie cache LRU.
 * 
 * @author Alina Gorgovan
 *
 */
public class LruCacheMemory extends CacheMemory {

	/**
	 * LruCacheMemory constructor fara parametri
	 */
	public LruCacheMemory() {
		super();
	}

	private CheckProcess c = new CheckProcess();

	/*
	 * Metoda adauga un nou element in vectorul lru. Daca vectorul nu este plin
	 * adauga la sfarsit noul element iar daca este plin elimina elementul de pe
	 * prima pozitie care estecel mai vechi folosit si il adauga pe cel nou pe
	 * ultima pozitie.
	 * 
	 * @param lru
	 * 
	 * @see CacheMemory#add(java.util.ArrayList, int, int, int, java.lang.String)
	 */
	protected ArrayList<CacheStructure> add(ArrayList<CacheStructure> lru, int capacity, int in, int out,
			String processName) {
		LruCacheStructure l = new LruCacheStructure(processName, in, out);
		if (lru.size() < capacity) {
			lru.add(l);
		} else {
			lru.remove(0);
			lru.add(l);
		}
		return lru;

	}

	/**
	 * Metoda actualizeaza lru astfel incat elementele sunt ordonate crescator din
	 * punct de vedere al momentului folosit.
	 * 
	 * @param lru
	 *            vectorul cache
	 * @param k
	 *            pozitia din vectorul lru a elementului folosit
	 * @return vectorul lru actualizat
	 */
	private ArrayList<CacheStructure> updateLRU(ArrayList<CacheStructure> lru, int k) {
		LruCacheStructure aux = new LruCacheStructure();
		aux = (LruCacheStructure) (lru.get(k));
		int size = lru.size();
		for (int i = k; i < size - 1; i++) {
			lru.set(i, lru.get(i + 1));
		}
		lru.set(size - 1, aux);
		return lru;
	}

	/*
	 * Metoda proceseaza numarul n conform principiilor pentru LruCache.
	 * 
	 * @see CacheMemory#implement(java.util.ArrayList, ProcessStructure, int, int)
	 */
	public String implement(ArrayList<CacheStructure> lru, ProcessStructure pr, int n, int capacity) {
		int result = 0;
		boolean k = false;
		String aux = "Computed";
		String str;
		for (int j = 0; j < lru.size(); j++) {
			k = false;
			if (lru.get(j).getProcessName().equals(pr.getType()) && lru.get(j).getIn() == n) {
				result = lru.get(j).getOut();
				lru = updateLRU(lru, j);
				aux = "FromCache";
				k = true;
				break;
			}

		}

		if (k == false) {
			result = c.checkProcess(pr, n);
			add(lru, capacity, n, result, pr.getType());
		}
		str = n + " " + pr.getType() + " " + result + " " + aux;
		return str;
	}
}
