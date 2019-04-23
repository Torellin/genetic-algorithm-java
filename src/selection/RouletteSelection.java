package selection;

import java.util.Collections;

import model.DNA;
import model.Population;

public class RouletteSelection extends BaseSelection {

	@Override
	public Population select(Population population, int amount) {
		Population newPop = new Population(population.getMaxSize());
		Collections.sort(population, Collections.reverseOrder());

		while (newPop.size() < amount) {
			newPop.add(select(population));
		}

		return newPop;
	}

	public DNA select(Population population) {

		double weight_sum = population.getFitness();
		double value = Math.random() * weight_sum;

		for (DNA dna : population) {
			value -= dna.getFitness();

			if (value < 0) {
				return dna;
			}
		}

		return population.get(population.size() - 1);
	}

}
