/**
 * File name:Main.java
 * Package name: global
 * Proyect name: TSP
 */
package global;

import classes.BruteForce;
import classes.Greedy;
import classes.Problem;
import classes.Solution;

public class Main {	
	/**
	 * main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFile readFile = new ReadFile("src/files/tsp1.txt");
		Problem problem = new Problem(readFile.getNumberOfCities(), readFile.getDistances());
		System.out.println(problem.toS());
		
		Greedy greedy = new Greedy();
		Solution greedySolution = greedy.solve(problem);
		System.out.println(greedySolution.toS());
		
		BruteForce bruteForce = new BruteForce();
		Solution bruteForceSolution = bruteForce.solve(problem, greedySolution);
		System.out.println(bruteForceSolution.toS());
	}
}
