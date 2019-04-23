package setup;

import model.DNA;

public class AprioriSetup extends BaseSetup {

	private DNA mTarget;
	private double mKnowledge;

	public AprioriSetup(boolean[] genes, double knowledge) {
		mTarget = new DNA();
		mTarget.setGenes(genes);
		mKnowledge = knowledge;
	}

	@Override
	public DNA getGene(int dnaSize) {
		boolean[] dna = new boolean[dnaSize];

		for (int i = 0; i < dnaSize; i++) {
			boolean gene = mTarget.getGene(i);
			dna[i] = random.nextFloat() < mKnowledge ? gene : !gene;
		}

		DNA gene = new DNA();
		gene.setGenes(dna);

		return gene;
	}

}
