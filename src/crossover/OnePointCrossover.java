package crossover;

import java.util.Arrays;

import model.DNA;

public class OnePointCrossover extends BaseCrossover {

	@Override
	public DNA crossover(DNA dna1, DNA dna2) {
		int point = random.nextInt(dna1.size());

		boolean[] first = Arrays.copyOfRange(dna1.getGenes(), 0, point);
		boolean[] second = Arrays.copyOfRange(dna2.getGenes(), point, dna2.size());

		boolean[] both = Arrays.copyOf(first, dna1.size());
		System.arraycopy(second, 0, both, first.length, second.length);

		DNA child = new DNA();
		child.setGenes(both);

		return child;
	}

}
