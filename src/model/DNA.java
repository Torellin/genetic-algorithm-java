package model;

public class DNA implements Comparable<DNA> {

	private double mFitness;
	private boolean[] mGenes;

	public void setGenes(boolean[] genes) {
		mGenes = genes;
	}

	public boolean[] getGenes() {
		return mGenes;
	}

	public boolean getGene(int idx) {
		return mGenes[idx];
	}

	public void setGene(int idx, boolean gene) {
		mGenes[idx] = gene;
	}

	public void setFitness(double fitness) {
		mFitness = fitness;
	}

	public double getFitness() {
		return mFitness;
	}

	public int size() {
		return mGenes.length;
	}

	@Override
	public int compareTo(DNA o) {
		return Double.compare(mFitness, o.mFitness);
	}
}
