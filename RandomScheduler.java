
import java.util.ArrayList;
import java.util.Random;

/**
 * Clasa implementeaza planificatorul RandomScheduler si metodele abstracte din
 * clasa Scheduler.
 * 
 * @author Alina Gorgovan
 *
 */
public class RandomScheduler extends Scheduler {

	/**
	 * Constructor fara parametri
	 */
	public RandomScheduler() {
		super();
	}
	/*
	 * In cazul in care nu exista memorie cache se parcurge vectorul de numere si
	 * pentru fiecare numar se aplica un proces ales la intamplare din vectorul de
	 * procese cu ajutorul metodei getRandom. Se scrie in fisier rezultaul conform
	 * cerintei.
	 * 
	 * @see Scheduler#scheduleNC(ProblemData, HomeworkWriter)
	 */
	public void scheduleNC(ProblemData p, HomeworkWriter hw) {
		int rand = 0;
		int result = 0;
		CheckProcess c = new CheckProcess();
		for (int i = 0; i < p.getNumbersToBeProcessed().length; i++) {
			int n = p.getNumbersToBeProcessed()[i];
			rand = getRandom(p.getProcesses().length);
			result = c.checkProcess(p.getProcesses()[rand], n);
			hw.println(n + " " + p.getProcesses()[rand].getType() + " " + result + " " + "Computed");

		}
	}

	/*
	 * In cazul in care exista memorie Cache aceasta poate fi de tipul Lfu sau Lru.
	 * In metoda se aloca vectorul cache iar in functie de tipul de memorie se
	 * apeleaza o anume functie din clasa specifica. Procesul este ales mai intai
	 * tot cu ajutorul functiei getRandom. Se scrie in fisier rezultatul functiei
	 * apelate.
	 * 
	 * @see Scheduler#scheduleCache(ProblemData, HomeworkWriter)
	 */
	public void scheduleCache(ProblemData p, HomeworkWriter hw) {
		ArrayList<CacheStructure> cache = new ArrayList<>(p.getCacheCapacity());
		LruCacheMemory lruMem = new LruCacheMemory();
		LfuCacheMemory lfuMem = new LfuCacheMemory();
		int rand = 0;
		String aux;
		for (int i = 0; i < p.getNumbersToBeProcessed().length; i++) {
			int n = p.getNumbersToBeProcessed()[i];
			rand = getRandom(p.getProcesses().length);
			if (p.getCacheType().equals("LruCache"))
				aux = lruMem.implement(cache, p.getProcesses()[rand], n, p.getCacheCapacity());
			else
				aux = lfuMem.implement(cache, p.getProcesses()[rand], n, p.getCacheCapacity());
			hw.println(aux);

		}
	}

	/**
	 * Metoda alege un numar random.
	 * @param length lungimea vectorului de procese
	 * @return un indice random
	 */
	public static int getRandom(int length) {
		int rnd = new Random().nextInt(length);
		return rnd;
	}
}
