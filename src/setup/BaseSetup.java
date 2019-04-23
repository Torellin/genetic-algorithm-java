package setup;

import java.util.Random;

import model.DNA;
import model.Population;

public abstract class BaseSetup implements SetupStrategy {

	protected static final Random random = new Random();

	@Override
	public Population getPopulation(int size, int dnaSize) {
		Population population = new Population(size);

		for (int i = 0; i < size; i++) {
			population.add(getGene(dnaSize));
		}

		return population;
	}

	@Override
	public abstract DNA getGene(int dnaSize);

}
