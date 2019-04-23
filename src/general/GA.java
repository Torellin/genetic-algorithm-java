package general;

import crossover.CrossoverStrategy;
import evaluation.EvaluationStrategy;
import model.DNA;
import model.Population;
import mutation.MutationStrategy;
import selection.SelectionStrategy;
import setup.SetupStrategy;

public class GA {

	int mMaxGenerations;
	int mMutations;
	int mPopulationSize;
	int mSurvivers;
	int mGeneSize;
	int mElites;
	double mMutationProbability;
	DNA mCurrentBest;

	CrossoverStrategy mCrossoverStrategy;
	EvaluationStrategy mEvaluationStrategy;
	MutationStrategy mMutationStrategy;
	SelectionStrategy mSelectionStrategy;
	SetupStrategy mSetupStrategy;

	GAListener mListener;
	public Population population;
	int generation;
	boolean running;

	public void initGA() {
		generation = 0;

		this.setup();
		this.evaluation();
	}

	public void start() {
		initGA();

		running = true;

		while (running) {

			nextGeneration();

			if (mListener != null) {
				mListener.onNewGeneration(generation, population.getBest());
			}

			if (population.getBest().getFitness() >= 1) {
				running = false;
			}

			if (mMaxGenerations != -1 && generation >= mMaxGenerations) {
				running = false;
			}
		}

		if (mListener != null) {
			mListener.onFinished(generation);
		}
	}

	public void nextGeneration() {
		generation++;
		this.selection();
		this.crossover();
		this.mutation();
		this.evaluation();
	}

	private void setup() {
		// Init population
		population = mSetupStrategy.getPopulation(mPopulationSize, mGeneSize);
	}

	private void evaluation() {
		// Evaluate population
		mEvaluationStrategy.evaluate(population);
		mCurrentBest = population.getBest();
	}

	private void selection() {
		// Select some individuums
		population = mSelectionStrategy.select(population, mSurvivers);
	}

	private void crossover() {
		// Crossover population
		mCrossoverStrategy.crossover(population);
	}

	private void mutation() {
		// Mutate n individuals of population
		mMutationStrategy.mutate(population, mElites, mMutations, mMutationProbability);
	}

	public DNA getCurrentBest() {
		return mCurrentBest;
	}

	public void setListener(GAListener listener) {
		mListener = listener;
	}

	public int getMaxGenerations() {
		return mMaxGenerations;
	}

	public int getMutations() {
		return mMutations;
	}

	public int getPopulationSize() {
		return mPopulationSize;
	}

	public int getSurviver() {
		return mSurvivers;
	}
}
