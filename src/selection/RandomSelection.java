package selection;

import model.Population;

public class RandomSelection extends BaseSelection {

	@Override
	public Population select(Population population, int amount) {
		// Clip amount
		amount = Math.min(amount, population.size());

		Population newPop = new Population(population.getMaxSize());

		while (newPop.size() < amount) {
			int r = (int) (Math.random() * population.size());
			newPop.add(population.get(r));
		}

		return newPop;
	}

}
