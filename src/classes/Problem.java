/**
 * File name:Problem.java
 * Package name: classes
 * Proyect name: TSP
 */
package classes;

import java.util.ArrayList;

public class Problem {
	/** 
	 * Atributes
	 */
	private int numberOfCities;
	private ArrayList<ArrayList<Integer>> distances;
	/**
	 * Constructor: Problem
	 */
	public Problem(int nCities, ArrayList<ArrayList<Integer>> distances) {
		setNumberOfCities(nCities);
		setDistances(distances);
	}
	/**
	 * showInfoProblem
	 */
	public String toS() {
		String toS = "";
		toS += "Number of cities: " + numberOfCities + "\nDistances: ";
		for(int i = 0; i < distances.size(); i++) {
			toS += "\n" + (i+1) + ": ";
			for (int j = 0; j < distances.get(i).size(); j++) {
				toS += (j+1) + "(" + distances.get(i).get(j) + ") ";
			}
		}
		return toS;
	}
	/**
	 * @return the numberOfCities
	 */
	public int getNumberOfCities() {
		int aux = numberOfCities;
		return aux;
	}
	/**
	 * @param numberOfCities the numberOfCities to set
	 */
	public void setNumberOfCities(int numberOfCities) {
		this.numberOfCities = numberOfCities;
	}
	/**
	 * @return the distances
	 */
	public int getDistance(int from, int to) {
		return distances.get(from).get(to);
	}
	/**
	 * @param distances the distances to set
	 */
	public void setDistances(ArrayList<ArrayList<Integer>> distances) {
		this.distances = distances;
	}
}
