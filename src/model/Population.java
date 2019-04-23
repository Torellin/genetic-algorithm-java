package model;

import java.util.ArrayList;

public class Population {

	private ArrayList<DNA> mDNAs;
	private double mFitnessSum;
	private int mMaxSize;

	public Population(int maxSize) {
		mDNAs = new ArrayList<>();
		mMaxSize = maxSize;
	}

	public void add(DNA dna) {
		if (mDNAs.size() < mMaxSize) {
			mDNAs.add(dna);
		}
	}

	public void remove(int idx) {
		mDNAs.remove(idx);
	}

	public ArrayList<DNA> getDNAs() {
		return mDNAs;
	}

	public boolean isFull() {
		return mDNAs.size() == mMaxSize;
	}

	public int size() {
		return mDNAs.size();
	}

	public int getMaxSize() {
		return mMaxSize;
	}

	public double getFitness() {
		return mFitnessSum;
	}

	public DNA getDNA(int idx) {
		return mDNAs.get(idx);
	}

	public DNA getBest() {
		DNA best = null;
		double bestFitness = -Double.MAX_VALUE;

		for (DNA dna : mDNAs) {
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
