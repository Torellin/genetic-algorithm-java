package selection;

import java.util.Collections;

import model.Population;

public class EliteSelection extends BaseSelection {

	@Override
	public Population select(Population population, int amount) {
		// Clip amount
		amount = Math.min(amount, population.size());
		Collections.sort(population, Collections.reverseOrder());

		while (population.size() > amount) {
			population.remove(population.size() - 1);
		}

		return population;
	}

}
