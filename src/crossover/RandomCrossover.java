package crossover;

import model.DNA;

public class RandomCrossover extends BaseCrossover {

	@Override
	public DNA crossover(DNA dna1, DNA dna2) {
		boolean[] genes = new boolean[dna1.size()];

		for (int i = 0; i < genes.length; i++) {
			genes[i] = random.nextFloat() < 0.5 ? dna1.getGene(i) : dna2.getGene(i);
		}

		DNA child = new DNA();
		child.setGenes(genes);

		return child;
	}

}
