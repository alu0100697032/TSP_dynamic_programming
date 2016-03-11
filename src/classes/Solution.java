/**
 * File name:Solution.java
 * Package name: classes
 * Proyect name: TSP
 */
package classes;

import java.util.ArrayList;

public class Solution {
	/** 
	 * Atributes
	 */
	private int minimumDistance;
	private ArrayList<Integer> path;
	
	/**
	 * Constructor: Solution
	 */
	public Solution() {
		setMinimumDistance(0);
		setPath(new ArrayList<>());
	}
	/**
	 * toS
	 */
	public String toS() {
		String toS = "";
		toS += "Minimum distance: " + minimumDistance;
		toS += "\nPath: ";
		for(int i = 0; i < path.size(); i++)
			toS += path.get(i) + " -> "; 
		return toS;
	}
	/**
	 * @param minimumDistance the minimumDistance to set
	 */
	public void setMinimumDistance(int minimumDistance) {
		this.minimumDistance = minimumDistance;
	}
	/**
	 * incrementDistance
	 */
	public void incrementDistance(int distance) {
		minimumDistance += distance;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(ArrayList<Integer> path) {
		this.path = path;
	}
	/**
	 * addCityToPath
	 */
	public void addCityToPath(int city) {
		path.add(city);
	}
}
