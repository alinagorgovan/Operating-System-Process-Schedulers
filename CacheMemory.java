import java.util.ArrayList;

/**
 * Clasa structureaza modelul memoriei Cache si defineste metodele folosite.
 * 
 * @author Alina Gorgovan
 *
 */
public abstract class CacheMemory {
	/**
	 * Metoda aceasta va procesa numarul n. Verifica mai intai daca se afla in
	 * vecorul de elemente de tip CacheStructure. Daca se afla va returna rezultatul
	 * din structura corespunzatoare iar daca nu il va introduce in vector folosind
	 * metoda add definita.
	 * 
	 * @param cache
	 *            vectorul de dimensiune CacheCapacity si de tip Cache STructure in
	 *            care se salveaza numerele procesate
	 * @param pr
	 *            procesul care trebuie aplicat asupra numarului n
	 * @param n
	 *            numarul procesat
	 * @param capacity
	 *            capacitatea vectorului cache
	 * @return numarul n, numele procesului pr, rezultatul si cum s-a obtinut
	 *         rezultaul
	 */
	public abstract String implement(ArrayList<CacheStructure> cache, ProcessStructure pr, int n, int capacity);

	/**
	 * @param cache
	 *            vectorul in care se adauga noul element
	 * @param capacity
	 *            capacitatea vectorului cache
	 * @param in
	 *            numarul care trebuie adaugat
	 * @param out
	 *            rezultatul procesului
	 * @param processName
	 *            numele procesului
	 * @return vectorul cache actualizat
	 */
	protected abstract ArrayList<CacheStructure> add(ArrayList<CacheStructure> cache, int capacity, int in, int out,
			String processName);
}
