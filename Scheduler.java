
/**
 * Implementeaza conceptul de planificator si defineste metodele principale
 * folosite.
 * 
 * @author Alina Gorgovan
 *
 */
public abstract class Scheduler {
	/**
	 * Metoda planifica procesele in cazul in care nu exista memorie cache.
	 * @param p setul de date
	 * @param hw PrinWriter pentru scriere
	 */
	protected abstract void scheduleNC(ProblemData p, HomeworkWriter hw);

	/**
	 * Metoda planifica procesele in cazul in care exista memorie cache.
	 * @param p setul de date
	 * @param hw PrinWriter pentru scriere
	 */
	protected abstract void scheduleCache(ProblemData p, HomeworkWriter hw);

}
