package general;

import model.DNA;

public interface GAListener {

	public void onNewGeneration(int generation, DNA best);

	public void onFinished(int generation);
}
