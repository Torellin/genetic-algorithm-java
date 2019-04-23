package evaluation;

import model.DNA;
import model.Population;

public interface EvaluationStrategy {

	public static enum Type {
		DIFFERENZ, UNKNOWN
	}

	public abstract void evaluate(Population population);

	public abstract double evaluate(DNA gene);

}
