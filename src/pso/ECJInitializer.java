package pso;

import ec.EvolutionState;
import ec.simple.SimpleInitializer;
import ec.util.Parameter;

public class ECJInitializer extends SimpleInitializer {

	public double genome_x_low;
	public double genome_x_high;
	public double genome_y_low;
	public double genome_y_high;

	@Override
	public void setup(EvolutionState state, Parameter base) {

		Parameter loc_x_low = new Parameter("loc_x_low");
		Parameter loc_x_high = new Parameter("loc_x_high");
		Parameter loc_y_low = new Parameter("loc_y_low");
		Parameter loc_y_high = new Parameter("loc_y_high");

		Parameter genomeSizeParam = new Parameter("pop.subpop.0.species.genome-size");


		//set range of X and Y
		genome_x_low = state.parameters.getDouble(loc_x_low, null);
		genome_x_high = state.parameters.getDouble(loc_x_high, null);
		genome_y_low = state.parameters.getDouble(loc_y_low, null);
		genome_y_high = state.parameters.getDouble(loc_y_high, null);


		// set genomeSize
		int size = state.parameters.getInt(genomeSizeParam, null);
		state.parameters.set(genomeSizeParam, "" + size);
	}

}
