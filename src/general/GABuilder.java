package general;

import crossover.CrossoverStrategy;
import crossover.MultiPointCrossover;
import crossover.OnePointCrossover;
import crossover.RandomCrossover;
import evaluation.DifferenzEvaluation;
import evaluation.EvaluationStrategy;
import mutation.BitFlipMutation;
import mutation.MutationStrategy;
import selection.EliteSelection;
import selection.RandomSelection;
import selection.RankSelection;
import selection.RouletteSelection;
import selection.SelectionStrategy;
import setup.AprioriSetup;
import setup.RandomSetup;
import setup.SetupStrategy;

public class GABuilder {

	private int _geneSize;
	private int _maxGenerations;
	private int _mutations;
	private int _populationSize;
	private int _survivers;
	private double _mMutationProbability;
	private boolean[] _target;

	// Strategies
	private CrossoverStrategy _crossoverStrategy;
	private EvaluationStrategy _evaluationStrategy;
	private MutationStrategy _mutationStrategy;
	private SelectionStrategy _selectionStrategy;
	private SetupStrategy _setupStrategy;

	public GA build() {

		// Check correctness
		refactorBuild();

		GA ga = new GA();

		ga.mMaxGenerations = _maxGenerations;
		ga.mMutations = _mutations;
		ga.mPopulationSize = _populationSize;
		ga.mMutationProbability = _mMutationProbability;
		ga.mSurvivers = _survivers;
		ga.mGeneSize = _geneSize;

		ga.mCrossoverStrategy = _crossoverStrategy;
		ga.mEvaluationStrategy = _evaluationStrategy;
		ga.mMutationStrategy = _mutationStrategy;
		ga.mSelectionStrategy = _selectionStrategy;
		ga.mSetupStrategy = _setupStrategy;

		return ga;
	}

	private void refactorBuild() {
		if (_crossoverStrategy == null)
			crossoverStrategy(CrossoverStrategy.Type.UNKNOWN);
		if (_evaluationStrategy == null)
			evaluationStrategy(EvaluationStrategy.Type.UNKNOWN);
		if (_mutationStrategy == null)
			mutationStrategy(MutationStrategy.Type.UNKNOWN);
		if (_selectionStrategy == null)
			selectionStrategy(SelectionStrategy.Type.UNKNOWN);
		if (_setupStrategy == null)
			setupStrategy(SetupStrategy.Type.UNKNOWN);
	}

	public GABuilder mutationProbability(double probabilty) {
		_mMutationProbability = probabilty;
		return this;
	}

	public GABuilder geneSize(int geneSize) {
		_geneSize = geneSize;
		return this;
	}

	public GABuilder maxGenerations(int maxGenerations) {
		_maxGenerations = maxGenerations;
		return this;
	}

	public GABuilder mutations(int mutations) {
		_mutations = mutations;
		return this;
	}

	public GABuilder populationSize(int populationSize) {
		_populationSize = populationSize;
		return this;
	}

	public GABuilder survivers(int survivers) {
		_survivers = survivers;
		return this;
	}

	public GABuilder target(boolean[] target) {
		_target = target;
		return this;
	}

	public GABuilder crossoverStrategy(CrossoverStrategy.Type type) {
		CrossoverStrategy strategy;

		switch (type) {
		case ONE_POINT:
			strategy = new OnePointCrossover();
			break;

		case MULTI_POINT:
			strategy = new MultiPointCrossover(2);
			break;

		default:
			strategy = new RandomCrossover();
			break;

		}

		return crossoverStrategy(strategy);
	}

	public GABuilder crossoverStrategy(CrossoverStrategy strategy) {
		_crossoverStrategy = strategy;
		return this;
	}

	public GABuilder evaluationStrategy(EvaluationStrategy.Type type) {
		EvaluationStrategy strategy;

		switch (type) {
		default:
			strategy = new DifferenzEvaluation(_target);
			break;

		}

		return evaluationStrategy(strategy);
	}

	public GABuilder evaluationStrategy(EvaluationStrategy strategy) {
		_evaluationStrategy = strategy;
		return this;
	}

	public GABuilder mutationStrategy(MutationStrategy.Type type) {
		switch (type) {
		default:
			_mutationStrategy = new BitFlipMutation();
			break;

		}

		return this;
	}

	public GABuilder setupStrategy(SetupStrategy.Type type) {
		SetupStrategy strategy;

		switch (type) {
		case APRIORI:
			strategy = new AprioriSetup(_target, 0.5);
			break;
		default:
			strategy = new RandomSetup();
			break;

		}

		return setupStrategy(strategy);
	}

	public GABuilder setupStrategy(SetupStrategy strategy) {
		_setupStrategy = strategy;
		return this;
	}

	public GABuilder selectionStrategy(SelectionStrategy.Type type) {
		switch (type) {
		case ELITE:
			_selectionStrategy = new EliteSelection();
			break;
		case RANK:
			_selectionStrategy = new RankSelection();
			break;
		case ROULETTE:
			_selectionStrategy = new RouletteSelection();
			break;
		default:
			_selectionStrategy = new RandomSelection();
			break;

		}

		return this;
	}

}
