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
