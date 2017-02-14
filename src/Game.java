import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Game
{
	
	private static double[] finalGame = {0.21112732349160243, -1.3284286154538962, -0.5477090868688381, 0.8362676057663732, 1.6178594410191631, 0.09883730060853195, 0.10612072232413444, -0.4952776967986526, 0.29762938907675124, -0.3829582880859058, 0.48441133804688674, 0.22935434191744627, 0.5507866634091275, 0.6514415422603119, 0.9168547666057252, 0.08575736642975756, -1.4029022265050661, 0.19304220377143255, -0.023626603076140066, -2.145144715773424, 1.2551006540262637, -0.38370871859309613, 0.8963331096474713, -0.4048098780745281, 1.197403424546195, -0.907827879369115, 2.2732040633549992, 0.02077670321363306, 1.0244578266076074, -0.42056670008849606, 0.45543866482101375, -2.0311815298932108, -1.625613802990942, -0.8842981833441458, 1.2480321927945583, -0.15952617075720013, -1.1431351484266457, -1.2704313130988962, -0.49530974609634515, 0.1620353058631801, -0.15848534622130522, -0.6207006925170612, -0.115439738457424, -1.4591108541724098, 0.46559973106718505, -0.8066199153257931, -0.12267354175955487, 0.3065223023697042, -0.15784855677859544, -1.3921227541853445, -0.7574309879284145, 0.5165480927339023, 0.41219367887355757, -0.11508290918914793, -0.9840893304299225, -2.345129044699004, -0.17162842931121167, -1.352795648955529, 0.14250280051822437, 0.45375031978694896, -0.06947134604837545, 0.3616841209742882, 1.8692538615170224, 0.03281612527338388, -0.7981391645227384, 0.1379640244813684, -1.2452054255917553, -0.5294719501984457, -0.8007103735554741, 0.1553367055556964, -0.30138411312595975, -0.19658901368127296, 1.4213075290785573, 0.3298542202849766, -0.9454066422388864, -0.5077788439460371, -0.1649593028641593, 0.03859015014332201, -0.06338992911867596, 0.9336412952298779, -1.3592892946460131, -0.21841348552167625, -0.17008526136281918, 0.17495392853500824, 0.44802909316271644, 0.46701045943726266, -0.016328781933428932, -1.1018558564857313, 0.2126829739474869, -1.005855889955682, 1.142263296842644, 0.89027212739276, -1.6185625149157228, 0.31524068784500636, 1.2024774211034885, -0.14936063540186892, 0.11939229737467817, -1.806515612606433, -0.5794211722708863, -0.20215021369862934, -0.6448404025098142, -0.6130188643687791, 0.19064962502346824, -0.5477670722732061, -1.1522466333805201, -1.4087976439493983, -0.13506537720854128, 1.2475873319687658, 0.17979980535716167, -1.9846147545865835, 0.299507255454186, -0.6980381512194145, -2.2097940960778053, 0.025324607437965684, 1.6596437457781759, -1.3186315590370072, 0.1762574794161522, -1.5551532073324423, 0.6676930601875634, 0.9454816256556868, -0.23501841256421596, -1.4233951539782472, 0.4897232804519044, -1.8091657156730196, 1.763024714488278, 3.0874756115365653E-4, -2.0811858303610045, -0.3918366860225748, -1.3251802572502163, -0.5459969154012323, 0.32301754912240693, -1.032135992124288, 0.6284684139892894, 0.36531748605339787, -1.35859960778247, -1.0748408793048014, -2.1728918517422597, 1.001222665750878, 0.35566385049233973, -1.5156395358111725, 2.1268235207548174, -0.4370672779112322, 0.8925213653707742, -0.45759679247313995, -0.49349650000925377, 0.36427652802644594, -0.6588271995772423, 0.2605559641583875, -0.22883141131691886, 0.2539547754220576, -1.5711503097181188, 1.3522393946595503, -0.9356222612114199, -0.9855619645024135, -1.1451558734667617, 0.7807244165801822, -0.22395266324319263, 0.8854687919573919, 0.7930834373427578, -1.05189493087308, -1.5007639757915567, -0.22874198156794434, 1.3739727961916914, 0.8266862762180158, 0.0902414090449021, -1.3515702787586414, 0.39684789283805116, -1.1854216770999444, 1.5509284272908983, 1.7499562989611543, 0.42469847147060813, -0.34026923070332327, -2.798885531700293, -0.45928126950763437, -1.3452496163270622, 3.2242710646992205, 0.022458500192526463, -0.8789033569840394, 0.09708379795283577, -0.5459443388171975, -0.4579471792594911, -1.0289195467748875, 0.17822140692997895, 1.6114257456788166, -0.038369406469679734, -1.2442857049895073, -0.1338688004903728, -0.13897137034103327, 0.7106738888699428, -1.4150824055668356, 1.5363382123692142, 0.34861286568115646, -0.4672110997349924, 0.5321660436396598, -2.1150199222688797, -1.7893427646112479, 0.74712758232522, 2.463027928012655, -0.6569237117670063, 0.6521988505503274, 1.57141675671424, 0.5145983187379328, 0.6675401912382697, 0.0382558454734811, -1.376417557164395, -1.7853292558993588, -0.03537756937153658, 0.3485201830347864, -0.6433733126296574, -0.381981387782906, 0.9884667404524718, 1.7960770402496586, 0.6293388197777837, -0.9307977239777632, 1.7390443071570245, 0.4203242648270653, -0.21974087843993592, 1.6882833037760479, -0.2985147904656494, -1.008752375588371, -1.7707629813199297, -0.17073120361473323, -0.1943328577635861, -0.3992599376254279, 1.735505921551561, 0.1082493954861698, 0.7817167991033996, 0.1940729420365212, 1.993232627349531, -1.6696397659746642, 0.2597054783551031, -1.629832142528843, 0.1301564558845534, 0.6026882760454452, -0.45883360576795207, 0.13247100536874357, -1.5466837050853661, 0.5299090966232399, 0.5044182136790847, -1.366770578591991, 1.8751097702999344, 0.6607005472956359, -0.24307920333245678, 1.4464091466788047, 0.39980525241032105, 3.3142298219453608, -0.05282977757289053, 0.4092534864536279, 1.7420120466735614, -1.1651625164111068, -0.1299365952376272, -1.2310741018748002, 1.2195494944996301, -0.3968505033217308, -1.1754544760350925, 0.47202333596098534, 1.784243461333044, -1.5795735226963823, 1.215007970997528, -0.9266452128139055, 1.0687385872012922, -2.888979164053574, 0.8034527336036166, -1.3511946348775992, -1.897573373423779, 0.8143261409694597, 0.5286261347849008, -0.44718894487518585, 0.17015679590418983, -0.6472075596560066, -2.259247612936252, -0.95695047251063, -0.4059503563959095, -1.431194657887998, -0.2166407085852435, -0.4303915891482964, -0.8832471381651369, -2.018215775963517, 0.7631648072039497, -1.0650401056104295, -1.2288893184463108, -1.0943492468572953, -1.9108653674113525, -1.0759328152572207, -1.5025575630354893, -1.4891420871332803, -0.47722295663896613, -3.47994576067425, 0.6274393912015482, 1.7879457883897458, 0.30699198141424927};
	
	private static void Mutate(Matrix population)
	{
		Random r = new Random();
		for(int i = 0; i < 100; i++)
		{
			if(r.nextDouble() < population.row(i)[291])
			{
				int index = Math.abs(r.nextInt() % population.row(i).length);
				//System.out.println("Before" + population.row(i)[index]);
				population.row(i)[index] += r.nextGaussian() * population.row(i)[292];
				//System.out.println("After" + population.row(i)[index]);
				//System.out.println("stddev" + population.row(i)[292]);
				

			}
		}
		for(int i = 0; i < 100; i++)
		{
			
			if(population.row(i)[291] > 0.9)
				population.row(i)[291] = 0.9;
			if(population.row(i)[291] < 0.1)
				population.row(i)[291] = 0.1;
			if(population.row(i)[292] > 10)
				population.row(i)[292] = 10;
			if(population.row(i)[292] < 0.1)
				population.row(i)[292] = 0.1;
			if(population.row(i)[293] > 0.9)
				population.row(i)[293] = 0.9;
			if(population.row(i)[293] < 0.1)
				population.row(i)[293] = 0.1;
			if(population.row(i)[294] > 10)
				population.row(i)[294] = 10;
			if(population.row(i)[294] < 1)
				population.row(i)[294] = 1;
			if(population.row(i)[295] > 20)
				population.row(i)[295] = 20;
			if(population.row(i)[295] < 1)
				population.row(i)[295] = 1;
			if(population.row(i)[296] > 5)
				population.row(i)[296] = 5;
			if(population.row(i)[296] < 1)
				population.row(i)[296] = 1;
		}
	}
	
	private static int[] NaturalSelection(Matrix population) throws Exception
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
	
	public static void BattleReflex(Matrix population) throws Exception
	{
		Random r = new Random();
		if(r.nextDouble() < 0.5)
		{
			int chooseRow = r.nextInt(population.rows());
			int winner = Controller.doBattleNoGui(new ReflexAgent(), new NeuralAgent(population.row(chooseRow)));
			if(winner < 0)
			{
				System.out.println("NeuralAgent Won!");
				for(int i = 0; i < population.cols(); i++)
				{
					int parent1 = r.nextInt(population.rows());
					int parent2 = r.nextInt(population.rows());
					population.row(chooseRow)[i] = (r.nextDouble() < 0.5) ? population.row(parent1)[i] : population.row(parent2)[i];
				}
			}
		}
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

	static double[] evolveWeights() throws Exception
	{
		// Create a random initial population
		Random r = new Random();
		Matrix population = new Matrix(100, 297);
		for(int i = 0; i < 100; i++)
		{
			double[] chromosome = population.row(i);
			for(int j = 0; j < chromosome.length; j++)
				chromosome[j] = r.nextGaussian();
		}
		System.out.println(Arrays.toString(population.row(0)));
		// Evolve the population
		
		//META Parameters
		double p = 0.9; //Probability of mutation
		double d = 0.08; //Std Deviation for mutation
		double survival = 0.8; //Probability winner survives (Natural Selection)
		int numberDead = 5; //Number that die from battle
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
		for(int repeat = 0; repeat < 100; repeat++)
		{
			//Reduce probability of mutation slowly
			for(int i = 0; i < population.rows(); i++)
			{
				if(population.row(i)[291] > 0.1 && population.row(i)[292] > 0.1)
				{
					population.row(i)[291] -= 0.6/100;
					population.row(i)[292] -= 0.9/100;
				}
			}
			if((double)repeat / 1 % 5 == 0)
			{
				System.out.println("Percent Complete: " + (double)repeat / 1);
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
			//System.out.println("Dead: " + Arrays.toString(dead));
			//System.out.println("Before Replenish: " + Arrays.toString(population.row(dead[0])));
			Replenish(population, dead);
			//System.out.println("After Replenish:  " + Arrays.toString(population.row(dead[0])));
			//System.out.println("After Replenish:  " + Arrays.toString(population.row(0)));
			Matrix tmpPop = new Matrix(100,291);
			for(int j = 0; j < 100; j++)
			{
				for(int i = 0; i < 291; i++)
				{
					tmpPop.row(j)[i] = population.row(j)[i];
				}
			}
			BattleReflex(tmpPop);

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
		//double[] w = evolveWeights();
		double[] w = finalGame;
		System.out.println(Arrays.toString(w));
		Controller.doBattle(new ReflexAgent(), new NeuralAgent(w));
		System.out.println("Done");
	}
}
