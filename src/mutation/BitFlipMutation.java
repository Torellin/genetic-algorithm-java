package mutation;

import model.DNA;

public class BitFlipMutation extends BaseMutation {

	@Override
	public void mutate(DNA gene, double prob) {
		int n = (int) Math.min(gene.size(), prob * gene.size());
		for (int i = 0; i < n; i++) {
			int p = random.nextInt(gene.size());
			gene.setGene(p, !gene.getGene(p));
		}
	}

}
