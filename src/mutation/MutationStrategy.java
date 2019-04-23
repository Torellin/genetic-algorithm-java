package mutation;

import model.DNA;
import model.Population;

public interface MutationStrategy {

	public static enum Type {
		BIT_FLIP, RANDOM, SWAP, SCRAMBLE, INVERSION, UNKNOWN
	}

	public abstract void mutate(DNA gene, double mutationProbability);

	public abstract void mutate(Population population, int elitism, int mutations, double mutationProbability);
}
