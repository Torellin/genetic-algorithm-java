package selection;

import model.Population;

public interface SelectionStrategy {

	public static enum Type {
		RANDOM, RANK, TOURNAMENT, SUS, ROULETTE, ELITE, UNKNOWN
	}

	public abstract Population select(Population population, int amount);
}
