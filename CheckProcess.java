/**
 * Clasa ce contine metoda prin care se proceseaza numarul n conform procesului
 * primit.
 * 
 * @author Alina Gorgovan
 *
 */
public class CheckProcess {

	public CheckProcess() {
		super();
	}

	/**
	 * Metoda verifica tipul procesului si in functie de acesta creeaza clasa
	 * corespunzatoare si apeleaza metoda din aceasta.
	 * 
	 * @param currentProcess
	 *            procesul pentru care se face verificarea
	 * @param n
	 *            numarul care trebuie sa fie procesat
	 * @return rezultatul procesului asupra numarului n
	 * 
	 */

	protected int checkProcess(ProcessStructure currentProcess, int n) {
		int result = 0;

		if (currentProcess.getType().equals("CheckPrime")) {
			CheckPrime a = new CheckPrime();
			result = a.process(n);
		}
		if (currentProcess.getType().equals("NextPrime")) {
			NextPrime a = new NextPrime();
			result = a.process(n);
		}
		if (currentProcess.getType().equals("Fibonacci")) {
			Fibonacci a = new Fibonacci();
			result = a.process(n);
		}
		if (currentProcess.getType().equals("Sqrt")) {
			Sqrt a = new Sqrt();
			result = a.process(n);
		}
		if (currentProcess.getType().equals("Square")) {
			Square a = new Square();
			result = a.process(n);
		}
		if (currentProcess.getType().equals("Cube")) {
			Cube a = new Cube();
			result = a.process(n);
		}
		if (currentProcess.getType().equals("Factorial")) {
			Factorial a = new Factorial();
			result = a.process(n);
		}
		return result;
	}
}
