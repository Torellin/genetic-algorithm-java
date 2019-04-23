package setup;

import java.util.Random;

import model.DNA;
import model.Population;

public abstract class BaseSetup implements SetupStrategy {

	protected static final Random random = new Random();

	@Override
	public Population getPopulation(int size, int dnaSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public abstract DNA getGene(int dnaSize);

}
