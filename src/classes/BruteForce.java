/**
 * File name:BruteForce.java
 * Package name: classes
 * Proyect name: TSP
 */
package classes;

import java.util.ArrayList;

import global.Globals;

public class BruteForce {
	/** 
	 * Atributes
	 */
	private Solution currentSolution;
	/**
	 * Constructor: BruteForce
	 */
	public BruteForce() {
		
	}
	/**
	 * solve
	 */
	public Solution solve(Problem problem, Solution initialSolution) {
		setCurrentSolution(initialSolution);
		ArrayList<Integer> initialPath = new ArrayList<>();
		initialPath.add(Globals.START_CITY);
		Solution subSolution = new Solution(initialPath, 0);
		bruteForceAlgorithm(problem, subSolution);
		return currentSolution;
	}
	/**
	 * bruteForceAlgorithm
	 */
	public void bruteForceAlgorithm(Problem problem, Solution subSolution) {
		if(subSolution.getPathSize() == problem.getNumberOfCities()) {
			subSolution.incrementDistance(problem.getDistance(subSolution.getLastCity(), 0));
			if(subSolution.getMinimumDistance() < currentSolution.getMinimumDistance()) {
				subSolution.addCityToPath(0);
				setCurrentSolution(subSolution);
			}
		}else {
			for(int i = 0; i < problem.getNumberOfCities(); i++) {
				if(!subSolution.getPath().contains(i)) {
					int increasedDistance = subSolution.getMinimumDistance() + problem.getDistance(subSolution.getLastCity(), i);
					ArrayList<Integer> increasedPath = (ArrayList<Integer>) subSolution.getPath().clone();
					increasedPath.add(i);
					Solution increasedSolution = new Solution(increasedPath, increasedDistance);
					bruteForceAlgorithm(problem, increasedSolution);
				}
			}
		}
	}
	/**
	 * @param currentSolution the currentSolution to set
	 */
	public void setCurrentSolution(Solution currentSolution) {
		this.currentSolution = currentSolution;
	}
	
}
