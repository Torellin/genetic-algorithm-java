package crossover;

import java.util.ArrayList;
import java.util.Collections;

import model.DNA;

public class MultiPointCrossover extends BaseCrossover {

	public int k;

	public MultiPointCrossover(int k) {
		this.k = k;
	}

	@Override
	public DNA crossover(DNA dna1, DNA dna2) {
		// Init crossover points
		ArrayList<Integer> points = new ArrayList<>();
		points.add(0);
		points.add(dna1.size());

		for (int i = 0; i < k; i++) {
			points.add(random.nextInt(dna1.size()));
		}

		Collections.sort(points);

		boolean[] both = new boolean[dna1.size()];

		for (int i = 0; i < points.size() - 1; i++) {
			DNA choice = i % 2 == 0 ? dna1 : dna2;
			System.arraycopy(choice.getGenes(), points.get(i), both, points.get(i), points.get(i + 1) - points.get(i));
		}

		DNA child = new DNA();
		child.setGenes(both);

		return child;
	}
}
