package pso;

import java.util.Random;

import ec.EvolutionState;
import ec.Individual;
import ec.Problem;
import ec.pso.Particle;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;

public class ECJPSO extends Problem implements SimpleProblemForm {

	@Override
	public void evaluate(EvolutionState state, Individual ind, int subpopulation, int threadnum) {

		ECJInitializer initial = (ECJInitializer) state.initializer;
		if (ind.evaluated)
			return;

		if (!(ind instanceof Particle))
			state.output.fatal("Whoa!  It's not a Particle!!!", null);
		Particle ind1 = (Particle) ind;

		double fitness = calculateFitness(ind1,initial);
		//declare it is not ideal-false
		((SimpleFitness) ind1.fitness).setFitness(state, fitness, false);
		ind1.evaluated = true;


	}

	// Fitness function
	private double calculateFitness(Particle ind1, ECJInitializer initial) {

		ind1.genome[0] = initial.genome_x_low + new Random().nextDouble() * (initial.genome_x_high - initial.genome_x_low);
		ind1.genome[1] = initial.genome_y_low + new Random().nextDouble() * (initial.genome_y_high - initial.genome_y_low);

		double x = ind1.genome[0];
		double y = ind1.genome[1];

		double fitness = 0;

		fitness = Math.pow(2.8125 - x + x * Math.pow(y, 4), 2) + Math.pow(2.25 - x + x * Math.pow(y, 2), 2)
				+ Math.pow(1.5 - x + x * y, 2);

		return fitness;
	}

}
