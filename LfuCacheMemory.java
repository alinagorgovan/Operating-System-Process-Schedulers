import java.util.ArrayList;

/**
 * Implementeaza tipul de memorie cache LFU.
 * @author Alina Gorgovan
 *
 */
public class LfuCacheMemory extends CacheMemory {

	public LfuCacheMemory() {
		super();
	}

	private CheckProcess c = new CheckProcess();

	/**
	 * Metoda cauta in vectorul lfu elementul cu numarul de utilizari cel mai mic.
	 * 
	 * @param lfu
	 *            vectorul cache
	 * @return indicele elementului dinn vector
	 */
	private int minim(ArrayList<CacheStructure> lfu) {
		int min = ((LfuCacheStructure) lfu.get(0)).freq;
		int j = 0;
		for (int i = 0; i < lfu.size(); i++) {
			if (min > ((LfuCacheStructure) lfu.get(i)).freq) {
				min = ((LfuCacheStructure) lfu.get(i)).freq;
				j = i;
			}
		}
		return j;
	}

	/*
	 * Adauga in vevtorul lfu noul element. Daca lfu nu este plin adauga noul
	 * element la sfarsitul vectorului. Daca este plin elimina cel mai putin folosit
	 * element stabilit cu ajutorul metodei minim si adauga la sfarsit noul element.
	 * 
	 * @param lfu
	 * 
	 * @see CacheMemory#add(java.util.ArrayList, int, int, int, java.lang.String)
	 */
	protected ArrayList<CacheStructure> add(ArrayList<CacheStructure> lfu, int capacity, int in, int out,
			String processName) {
		LfuCacheStructure l = new LfuCacheStructure(processName, in, out);
		l.freq = 1;
		if (lfu.size() < capacity) {
			lfu.add(l);
		} else {
			lfu.remove(minim(lfu));
			lfu.add(l);
		}
		return lfu;
	}

	/*
	 * Metoda proceseaza numarul n conform principiilor pentru LfuCache.
	 * 
	 * @see CacheMemory#implement(java.util.ArrayList, ProcessStructure, int, int)
	 */
	public String implement(ArrayList<CacheStructure> lfu, ProcessStructure pr, int n, int capacity) {
		int result = 0;
		boolean k = false;
		String aux = "Computed";
		String str;
		for (int j = 0; j < lfu.size(); j++) {
			k = false;
			if (lfu.get(j).getProcessName().equals(pr.getType()) && lfu.get(j).getIn() == n) {
				result = lfu.get(j).getOut();
				((LfuCacheStructure) lfu.get(j)).freq += 1;
				aux = "FromCache";
				k = true;
				break;
			}
		}
		if (k == false) {
			result = c.checkProcess(pr, n);
			add(lfu, capacity, n, result, pr.getType());
		}

		str = n + " " + pr.getType() + " " + result + " " + aux;
		return str;
	}
}
