package model;

import java.util.ArrayList;

public class Population extends ArrayList<DNA> {

	private static final long serialVersionUID = 8994659318395544380L;

	private double mFitnessSum;
	private int mMaxSize;

	public Population(int maxSize) {
		mMaxSize = maxSize;
	}

	@Override
	public boolean add(DNA dna) {
		if (isFull())
			return false;

		return super.add(dna);
	}

	public boolean isFull() {
		return size() >= mMaxSize;
	}

	public int getMaxSize() {
		return mMaxSize;
	}

	public double getFitness() {
		return mFitnessSum;
	}

	public DNA getBest() {
		DNA best = null;
		double bestFitness = -Double.MAX_VALUE;

		for (DNA dna : this) {
			if (dna.getFitness() > bestFitness) {
				best = dna;
				bestFitness = dna.getFitness();
			}
		}

		return best;
	}

	public void setFitness(double fitness) {
		mFitnessSum = fitness;
	}
}
