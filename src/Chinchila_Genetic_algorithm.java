import java.util.concurrent.ThreadLocalRandom;

/**
 * @version 1.00a
 * @author sOm2y This program is made by yyin888
 */

public class Chinchila_Genetic_algorithm {
	final double CrossoverProbability = 0.87;
	final double MutationProbability = 0.02;

	/**
	 * create the initial random population, size is target text length
	 */
	public char[] generateStrings() {
		char[] validChars = new char[2 + 95]; // NL, CR, printable ascii
												// characters
		validChars[0] = '\n'; // NL
		validChars[1] = '\r'; // CR

		for (int i = 2; i < validChars.length; i++)
			validChars[i] = (char) (i + 30); // printable

		return validChars;
	}

	public String generateRandomMonkey(final int size, final char[] validChars) {
		StringBuilder sb = new StringBuilder(size);

		for (int j = 0; j < size; j++) {
			sb.append(validChars[ThreadLocalRandom.current().nextInt(0,
					validChars.length)]);
		}

		return sb.toString();
	}

	public int diff(String target, String currentPop) {
		if (target.length() != currentPop.length())
			throw new RuntimeException("Strings need to be of equal length");

		int diff = 0;
		
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) != currentPop.charAt(i))
				diff++;
			
		}

		return diff;
	}
	public int match(String target, String currentPop) {
		if (target.length() != currentPop.length())
			throw new RuntimeException("Strings need to be of equal length");

		int match = 0;
		
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == currentPop.charAt(i))
				match++;
			
		}

		return match;
	}
	
	
	public int randomParent(int totalFitness, int maxUnfitness,
			int[] currentScore) {
		double prob = ThreadLocalRandom.current().nextDouble(1.0);
		int val = (int) (prob * totalFitness);

		for (int i = 0; i < currentScore.length; i++) {
			int currentFitness = maxUnfitness - currentScore[i]+1;

			if (val < currentFitness)
				return i;

			val -= currentFitness;
		}

		throw new RuntimeException("Should never reach here here.");
	}
	public void breeding(String mother,String father){
		double randProb = ThreadLocalRandom.current().nextDouble(1.0);
		String daughter;
		String son;
		if(randProb<CrossoverProbability){
			daughter =mother.substring(0, (mother.length()/2)-1)+father.substring(father.length()/2, father.length()-1);
			son =father.substring(0, (mother.length()/2)-1)+mother.substring(father.length()/2, father.length()-1);
		}else{
			daughter = mother;
			son = father;
		}
		if(randProb<MutationProbability){
			String ranChar = generateRandomMonkey(1,generateStrings());
			int ranIndex = 0 + (int)(Math.random() * ((mother.length()-1 - 0) + 1));
			
			daughter = mother.replace(mother.charAt(ranIndex), ranChar.charAt(0));
		}
		if(randProb<MutationProbability){
			String ranChar = generateRandomMonkey(1,generateStrings());
			int ranIndex = 0 + (int)(Math.random() * ((father.length()-1 - 0) + 1));
			
			son = father.replace(father.charAt(ranIndex), ranChar.charAt(0));
		}
		mother = daughter;
		father = son;
	}

}
