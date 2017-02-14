import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Game
{
	
	private static void Mutate(Matrix population)
	{
		Random r = new Random();
		for(int i = 0; i < 100; i++)
		{
			if(r.nextDouble() < population.row(i)[291])
			{
				population.row(i)[Math.abs(r.nextInt()) % 100] += r.nextGaussian() * population.row(i)[292];
			}
		}
	}
	
	private static int[] NaturalSelection(Matrix population)
	{
		int[] dead = new int[(int)population.row(0)[294]];
		Random r = new Random();
		for(int i = 0; i < dead.length; i++)
		{
			int agent1Choice = Math.abs(r.nextInt()) % population.rows();
			int agent2Choice = Math.abs(r.nextInt()) % population.rows();
			int winner = 0;
			//System.out.println(population.rows());
			double[] agent1weights = new double[291];
			double[] agent2weights = new double[291];
			for(int temp = 0; temp < 291; temp++)
			{
				agent1weights[temp] = population.row(agent1Choice)[temp];
				agent2weights[temp] = population.row(agent2Choice)[temp];
			}
			NeuralAgent agent1 = new NeuralAgent(agent1weights);
			NeuralAgent agent2 = new NeuralAgent(agent2weights);
			try{
				winner = Controller.doBattleNoGui(agent1, agent2);					
			}catch(Exception e)
			{
				System.out.println("Exception Thrown:\n" + e.getMessage());
			}
			
			double survive = r.nextDouble();
			if(winner == 1)
			{
				if(survive < population.row(i)[293])
					dead[i] = agent2Choice;
				else
					dead[i] = agent1Choice;	
			}
			else if(winner == -1)
			{
				if(survive < population.row(i)[293])
					dead[i] = agent1Choice;
				else
					dead[i] = agent2Choice;
			}
				
		}
		return dead;
	}
	
	public static void Replenish(Matrix population, int[] dead)
	{
		for(int i = 0; i < dead.length; i++)
		{
			Random r = new Random();
			//Find parent1 and several parent2
			boolean isSame = true;
			int parent1 = Math.abs(r.nextInt()) % population.rows();
			while(isSame)
			{
				parent1 = Math.abs(r.nextInt()) % population.rows();
				isSame = false;
				for(int j = 0; j < dead.length; j++)
				{
					if(dead[j] == parent1)
						isSame = true;
				}
			}
			int[] parent2 = new int[(int)population.row(i)[295]];
			for(int j = 0; j < parent2.length; j++)
			{	
				boolean anySame = true;
				while(anySame) //Keepgoing until all are unique
				{
					int newIndex =  Math.abs(r.nextInt()) % population.rows();
					anySame = false;
					for(int k = 0; k < j; k++)
					{
						for(int l = 0; l < dead.length; l++)
						{
							if(newIndex == parent2[k] || newIndex == dead[l])
								anySame = true;
						}
					}
					parent2[j] = newIndex;
				}
				//System.out.println("Indexes: " + parent2[j]);
			}
			//System.out.println("");
			
			
			//Find Best Match
			double bestMatch = Double.MAX_VALUE;
			int bestIndex = 0;
			for(int j = 0; j < parent2.length; j++)
			{
				double betterMatch = 0;
				for(int k = 0; k < population.cols(); k++)
				{
					betterMatch += Math.pow(Math.abs(Math.pow(population.row(parent1)[k], population.row(parent1)[296]) - Math.pow(population.row(parent2[j])[k], population.row(parent1)[296])), 1/population.row(parent1)[296]);
				}
				if(betterMatch < bestMatch)
				{
					bestMatch = betterMatch;
					bestIndex = j;
				}
			}
			
			//Mate
			for(int j = 0; j < population.cols(); j++)
			{
				double pickOne = r.nextDouble();
				if(pickOne < 0.5)
					population.row(dead[i])[j] = population.row(parent1)[j];
				else
					population.row(dead[i])[j] = population.row(parent2[bestIndex])[j];
			}
		}
	}

	static double[] evolveWeights()
	{
		// Create a random initial population
		Random r = new Random();
		Matrix population = new Matrix(100, 297);
		for(int i = 0; i < 100; i++)
		{
			double[] chromosome = population.row(i);
			for(int j = 0; j < chromosome.length; j++)
				chromosome[j] = 0.03 * r.nextGaussian();
		}
		//System.out.println(population.toString());

		// Evolve the population
		// todo: YOUR CODE WILL START HERE.
		//       Please write some code to evolve this population.
		//       (For tournament selection, you will need to call Controller.doBattleNoGui(agent1, agent2).)
		
		//META Parameters
		
		double p = 0.7; //Probability of mutation
		double d = 10; //Std Deviation for mutation
		double survival = 0.8; //Probability winner survives (Natural Selection)
		int numberDead = 20; //Number that die from battle
		int numberOfSecondParents = 20; //Number of second parents for replinishment
		int powerDifference = 2; //Power difference when finding distance between parents
		
		for(int i = 0; i < 100; i++)
		{
			population.row(i)[291] = p; //Probability of mutation
			population.row(i)[292] = d;
			population.row(i)[293] = survival;
			population.row(i)[294] = numberDead;
			population.row(i)[295] = numberOfSecondParents;
			population.row(i)[296] = powerDifference;
		}
		
		//Evolve for a long time
		for(int repeat = 0; repeat < 1000; repeat++)
		{
			for(int i = 0; i < population.rows(); i++)
			{
				if(population.row(i)[291] > 0.1)
				{
					population.row(i)[291] -= 0.6/100;
				}
			}
			if((double)repeat / 10 % 5 == 0)
			{
				System.out.println("Percent Complete: " + (double)repeat / 10);
			}
			
			//Mutate
			//System.out.println("Before Mutate: " + Arrays.toString(population.row(0)));
			Mutate(population);
			//System.out.println("After Mutate:  " + Arrays.toString(population.row(0)));
			
			//Natural Selection
			int[] dead = NaturalSelection(population);
			//for(int i = 0; i < dead.length; i++)
			//{
			//	if (dead[i] == 0)
			//			System.out.println("Population 0 Died");
			//}

			//Replinish
			System.out.println("Dead: " + Arrays.toString(dead));
			System.out.println("Before Replenish: " + Arrays.toString(population.row(dead[0])));
			Replenish(population, dead);
			System.out.println("After Replenish:  " + Arrays.toString(population.row(dead[0])));
			//System.out.println("After Replenish:  " + Arrays.toString(population.row(0)));

		}
		//System.out.println("");
		//System.out.println(population.toString());

		// Return an arbitrary member from the population
		double[][] returnDoubles = new double[100][291];
		for(int j = 0; j < 100; j++)
		{
			for(int i = 0; i < 291; i++)
			{
				returnDoubles[j][i] = population.row(j)[i];
			}
		}
		int whichWon = 0;
		int thisoneWon = 0;
		for(int i = 0; i < 100; i++)
		{
			try {
			whichWon = Controller.doBattleNoGui(new ReflexAgent(), new NeuralAgent(returnDoubles[i]));
			} catch (Exception e)
			{
				System.out.println("Exception: " + e.getMessage());
			}
			if (whichWon == -1)
			{
				System.out.println("Red Won!!");
				thisoneWon = i;
			}
				
		}
		return returnDoubles[thisoneWon];
	}


	public static void main(String[] args) throws Exception
	{
		double[] w = evolveWeights();
		Controller.doBattle(new ReflexAgent(), new NeuralAgent(w));
		System.out.println("Done");
	}
}
