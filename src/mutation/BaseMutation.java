package mutation;

import java.util.Random;

import model.DNA;
import model.Population;

public abstract class BaseMutation implements MutationStrategy {

	protected static final Random random = new Random();

	@Override
	public void mutate(Population population, int elites, int mutations, double prob) {
		// Clip amount of mutations
		mutations = Math.min(population.size(), mutations);

		for (int i = 0; i < mutations; i++) {
			int r = elites + random.nextInt(population.size() - elites);
			mutate(population.getDNA(r), prob);
		}
	}

	@Override
	public abstract void mutate(DNA gene, double prob);

}
