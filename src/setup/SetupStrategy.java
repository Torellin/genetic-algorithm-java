package setup;

import model.DNA;
import model.Population;

public interface SetupStrategy {
	
	public static enum Type { 
		RANDOM, APRIORI, NEGATIVE, UNKNOWN
	}
	
	public abstract DNA getGene(int dnaSize);

	public abstract Population getPopulation(int size, int dnaSize);

}
