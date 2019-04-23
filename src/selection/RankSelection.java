package selection;

import java.util.Collections;

import model.DNA;
import model.Population;

public class RankSelection extends BaseSelection {

	@Override
	public Population select(Population population, int amount) {
		Collections.sort(population.getDNAs(), Collections.reverseOrder());
		Population newPop = new Population(population.getMaxSize());

		while (newPop.size() < amount) {
			newPop.add(select(population));
		}

		return newPop;
	}

	public DNA select(Population population) {

		double n = population.size() * (population.size() + 1) / 2;
		double value = Math.random();

		int i;
		for (i = 0; i < population.size() - 1; i++) {
			double prob = (population.size() - i) / n;

			value -= prob;

			if (value <= 0) {
				break;
			}
		}

		return population.getDNA(i);
	}
}