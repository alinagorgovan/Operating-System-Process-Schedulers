/**
 * @author Alina Gorgovan
 *
 */
public class MainClass {

	/**
	 * Verifica tipul de scheduler si tipul de memorie folosita si apeleaza metodele
	 * corespunzatoare
	 * 
	 * @param data
	 *            setul de date din fisier
	 * @param hw
	 */
	private static void checkScheduler(ProblemData data, HomeworkWriter hw) {
		if (data.getSchedulerType().equals("RandomScheduler")) {
			RandomScheduler s = new RandomScheduler();
			if (data.getCacheType().equals("NoCache"))
				s.scheduleNC(data, hw);
			else
				s.scheduleCache(data, hw);
		}
		if (data.getSchedulerType().equals("RoundRobinScheduler")) {
			RoundRobinScheduler s = new RoundRobinScheduler();
			if (data.getCacheType().equals("NoCache"))
				s.scheduleNC(data, hw);
			else
				s.scheduleCache(data, hw);
		}
		if (data.getSchedulerType().equals("WeightedScheduler")) {
			WeightedScheduler s = new WeightedScheduler();
			if (data.getCacheType().equals("NoCache"))
				s.scheduleNC(data, hw);
			else
				s.scheduleCache(data, hw);
		}
	}

	/**
	 * @param args argumente la rulare
	 */
	public static void main(String[] args) {
		HomeworkReader reader = new HomeworkReader(args[0]);
		HomeworkWriter hw = new HomeworkWriter(args[1]);
		ProblemData data = reader.readData();
		checkScheduler(data, hw);
		hw.close();
	}

}
