package crossover;

import java.util.Random;

import model.DNA;
import model.Population;

public abstract class BaseCrossover implements CrossoverStrategy {

	protected static final Random random = new Random();

	@Override
	public void crossover(Population population) {
		int startSize = population.size();

		while (!population.isFull()) {
			int one = random.nextInt(startSize);
			int two = random.nextInt(startSize);
			DNA child = crossover(population.getDNA(one), population.getDNA(two));

			population.add(child);
		}
	}

	@Override
	public abstract DNA crossover(DNA dna1, DNA dna2);

}
