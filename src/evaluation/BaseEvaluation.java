package evaluation;

import model.DNA;
import model.Population;

public abstract class BaseEvaluation implements EvaluationStrategy {

	@Override
	public void evaluate(Population population) {
		double sum = 0;

		for (DNA gene : population) {
			double fitness = evaluate(gene);
			gene.setFitness(fitness);
			sum += fitness;
		}

		population.setFitness(sum);
	}

	@Override
	public abstract double evaluate(DNA gene);

}
