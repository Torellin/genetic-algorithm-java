package setup;

import model.DNA;

public class RandomSetup extends BaseSetup {

	@Override
	public DNA getGene(int dnaSize) {
		boolean[] dna = new boolean[dnaSize];

		for (int i = 0; i < dnaSize; i++) {
			dna[i] = random.nextBoolean();
		}

		DNA gene = new DNA();
		gene.setGenes(dna);

		return gene;
	}

}
