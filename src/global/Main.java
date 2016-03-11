/**
 * File name:Main.java
 * Package name: global
 * Proyect name: TSP
 */
package global;

import classes.Problem;

public class Main {	
	/**
	 * main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFile readFile = new ReadFile("src/files/tsp1.txt");
		Problem problem = new Problem(readFile.getNumberOfCities(), readFile.getDistances());
		System.out.println(problem.toS());
	}
}