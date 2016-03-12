/**
 * File name:Greedy.java
 * Package name: classes
 * Proyect name: TSP
 */
package classes;

import java.util.ArrayList;

public class Greedy {
	/**
	 * Constructor: Greedy
	 */
	public Greedy() {
		
	}
	/**
	 * solve
	 */
	public Solution solve(Problem problem) {
		Solution solution = new Solution();
		ArrayList<Integer> path = new ArrayList<>();
		int totalDistance = 0;
		int currentCity = 0;
		path.add(currentCity);//put in the path the first city
		int closestCity = currentCity;
		int minimumDistance = Integer.MAX_VALUE;
		//build the final path
		while(path.size() < problem.getNumberOfCities()) {
			for(int i = 0; i < problem.getNumberOfCities(); i++) {
				if(i != currentCity && !path.contains(i)) {//if not the current city and not added to path...
					if(problem.getDistance(currentCity, i) < minimumDistance) {//get the closest city
						minimumDistance = problem.getDistance(currentCity, i);
						closestCity = i;
					}
				}
			}
			//update values
			path.add(closestCity);
			totalDistance += minimumDistance;
			currentCity = closestCity;
			minimumDistance = Integer.MAX_VALUE;
		}
		//close the path
		totalDistance += problem.getDistance(path.get(path.size() - 1), 0);
		path.add(path.get(0));
		//build the solution
		solution.setPath(path);
		solution.setMinimumDistance(totalDistance);
		return solution;
	}
}
