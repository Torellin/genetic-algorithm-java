package evaluation;

import model.DNA;

public class DifferenzEvaluation extends BaseEvaluation {

	boolean[] mTargetGenes;

	public DifferenzEvaluation(boolean[] genes) {
		mTargetGenes = genes;
	}

	@Override
	public double evaluate(DNA gene) {
		double sum = 0;

		for (int i = 0; i < gene.size(); i++) {
			if (gene.getGene(i) == mTargetGenes[i]) {
				sum++;
			}
		}

		double fitness = sum / gene.size();

		return fitness;
	}
}
