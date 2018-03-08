
import java.util.ArrayList;

/**
 * Clasa implementeaza planificatorul RoundRobinScheduler si metodele abstracte din
 * clasa Scheduler.
 * @author Alina Gorgovan
 *
 */
public class RoundRobinScheduler extends Scheduler {

	/*
	 * In cazul in care nu exista memorie cache se parcurge vectorul de numere si
	 * pentru fiecare numar se aplica un proces ales conform principiului din
	 * vectorul de procese. Pentru a nu exista o diferenta mai mare ca 1 intre
	 * procese, vectorul se parcurge in ordine pana cand se termina numerele ce
	 * trebuie procesate. Se scrie in fisier rezultaul conform cerintei.
	 * 
	 * @see Scheduler#scheduleNC(ProblemData, HomeworkWriter)
	 */
	public void scheduleNC(ProblemData p, HomeworkWriter hw) {
		int result = 0;
		int n;
		int j = 0;
		CheckProcess c = new CheckProcess();

		for (int i = 0; i < p.getNumbersToBeProcessed().length; i++) {
			n = p.getNumbersToBeProcessed()[i];
			j = j % p.getProcesses().length;
			result = c.checkProcess(p.getProcesses()[j], n);
			hw.println(n + " " + p.getProcesses()[j].getType() + " " + result + " " + "Computed");
			j++;
		}

	}

	/*
	 * In cazul in care exista memorie cache se parcurge vectorul de numere si
	 * pentru fiecare numar se aplica un proces ales conform principiului din
	 * vectorul de procese. Pentru a nu exista o diferenta mai mare ca 1 intre
	 * procese, vectorul se parcurge in ordine pana cand se termina numerele ce
	 * trebuie procesate. Se verifica tipul de memorie Cache si se apeleaza metoda
	 * specifica care va returna rezultatul procesului. Se scrie in fisier rezultaul
	 * conform cerintei.
	 * 
	 * @see Scheduler#scheduleCache(ProblemData, HomeworkWriter)
	 */
	public void scheduleCache(ProblemData p, HomeworkWriter hw) {
		int n;
		int j = 0;
		ArrayList<CacheStructure> cache = new ArrayList<>(p.getCacheCapacity());
		LruCacheMemory lruMem = new LruCacheMemory();
		LfuCacheMemory lfuMem = new LfuCacheMemory();
		String aux;

		for (int i = 0; i < p.getNumbersToBeProcessed().length; i++) {
			n = p.getNumbersToBeProcessed()[i];
			j = j % p.getProcesses().length;
			if (p.getCacheType().equals("LruCache"))
				aux = lruMem.implement(cache, p.getProcesses()[j], n, p.getCacheCapacity());
			else
				aux = lfuMem.implement(cache, p.getProcesses()[j], n, p.getCacheCapacity());
			hw.println(aux);
			j++;
		}
	}

}
