
import java.util.ArrayList;

/**
 * Clasa implementeaza planificatorul WeightedScheduler si metodele abstracte
 * din clasa Scheduler.
 * 
 * @author Alina Gorgovan
 *
 */
public class WeightedScheduler extends Scheduler {

	/**
	 * @param a
	 * @param b
	 * @return cmmdc a doua numere a si b
	 */
	protected static int gcd2(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd2(b, a % b);
	}

	/**
	 * Aplica metoda gcd2 pentru numerele din vector 2 cate 2.
	 * 
	 * @param p
	 *            vector de procese
	 * @return cmmdc a unui vector de numere
	 */
	protected static int gcdOfArray(ProcessStructure[] p) {
		int result = p[0].getWeight();
		for (int i = 1; i < p.length; i++) {
			result = gcd2(result, p[i].getWeight());
		}
		return result;
	}

	/*
	 * Metoda implementeaza planificatorul in cazul in care nu exista memorie cache.
	 * Se realizeaza suma cotelor proceselor si se imparte la cmmdc obtinandu-se
	 * altfel numarul t. Pentru fiecare numar se parcurge vectorul de utilizari unde
	 * se salveaza numarul de utilizari pentru ficare proces. Daca numarul de
	 * utilizari este mai mica decat cota /cmmdc atunci se foloseste procesul
	 * respectiv iar daca nu se testeaza procesele urmatoare. In momentul in care
	 * s-au apelat t procese vectorul de utilizari se reinitializeaza la 0.
	 * 
	 * @see Scheduler#scheduleNC(ProblemData, HomeworkWriter)
	 */
	public void scheduleNC(ProblemData p, HomeworkWriter hw) {
		int sumWeights = 0;
		int result = 0;
		int j = 0;
		CheckProcess c = new CheckProcess();
		int gcd = gcdOfArray(p.getProcesses()); // cmmdc al cotelor
		int[] nr = new int[p.getProcesses().length]; // vector de utlizari

		for (int i = 0; i < p.getProcesses().length; i++) {
			sumWeights += p.getProcesses()[i].getWeight();
		}

		int t = sumWeights / gcd;
		for (int i = 0; i < p.getNumbersToBeProcessed().length; i++) {
			int n = p.getNumbersToBeProcessed()[i];

			for (int i1 = 0; i1 < p.getProcesses().length; i1++) {
				if (nr[i1] < p.getProcesses()[i1].getWeight() / gcd) {
					result = c.checkProcess(p.getProcesses()[i1], n);
					hw.println(n + " " + p.getProcesses()[i1].getType() + " " + result + " " + "Computed");
					nr[i1]++;
					j++;
					break;
				}
				if (j == t) {
					j = 0;
					for (int i2 = 0; i2 < nr.length; i2++)
						nr[i2] = 0;
				}
			}

		}
	}

	/*
	 * Metoda implementeaza planificatorul in cazul in care exista memorie cache. Se
	 * realizeaza suma cotelor proceselor si se imparte la cmmdc obtinandu-se altfel
	 * numarul t. Pentru fiecare numar se parcurge vectorul de utilizari unde se
	 * salveaza numarul de utilizari pentru ficare proces. Daca numarul de utilizari
	 * este mai mica decat cota /cmmdc atunci se foloseste procesul respectiv iar
	 * daca nu se testeaza procesele urmatoare. Pentru procesul ales se apeleaza
	 * functia specifica tipului de memorie.In momentul in care s-au apelat t
	 * procese vectorul de utilizari se reinitializeaza la 0.
	 * 
	 * @see Scheduler#scheduleCache(ProblemData, HomeworkWriter)
	 */
	public void scheduleCache(ProblemData p, HomeworkWriter hw) {
		int sumWeights = 0;
		int j = 0;
		int gcd = gcdOfArray(p.getProcesses());
		int[] nr = new int[p.getProcesses().length];

		for (int i = 0; i < p.getProcesses().length; i++) {
			sumWeights += p.getProcesses()[i].getWeight();
		}
		ArrayList<CacheStructure> cache = new ArrayList<>(p.getCacheCapacity());
		LruCacheMemory lruMem = new LruCacheMemory();
		LfuCacheMemory lfuMem = new LfuCacheMemory();
		String aux;
		int t = sumWeights / gcd;

		for (int i = 0; i < p.getNumbersToBeProcessed().length; i++) {
			int n = p.getNumbersToBeProcessed()[i];

			for (int i1 = 0; i1 < p.getProcesses().length; i1++) {

				if (nr[i1] < p.getProcesses()[i1].getWeight() / gcd) {

					if (p.getCacheType().equals("LruCache"))
						aux = lruMem.implement(cache, p.getProcesses()[i1], n, p.getCacheCapacity());
					else
						aux = lfuMem.implement(cache, p.getProcesses()[i1], n, p.getCacheCapacity());
					hw.println(aux);
					nr[i1]++;
					j++;
					if (j == t) {
						j = 0;
						for (int i2 = 0; i2 < nr.length; i2++)
							nr[i2] = 0;
					}
					break;
				}

			}
		}
	}
}
