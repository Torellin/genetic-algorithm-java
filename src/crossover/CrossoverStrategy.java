package crossover;

import model.DNA;
import model.Population;

public interface CrossoverStrategy {

	public static enum Type {
		RANDOM, ONE_POINT, MULTI_POINT, UNIFORM, ARITHMETIC, DAVIS_ORDER, UNKNOWN
	}

	public abstract void crossover(Population population);

	public abstract DNA crossover(DNA dna1, DNA dna2);
}
