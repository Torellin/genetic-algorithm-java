package selection;

import model.Population;

public abstract class BaseSelection implements SelectionStrategy {

	@Override
	public abstract Population select(Population population, int amount);

}
