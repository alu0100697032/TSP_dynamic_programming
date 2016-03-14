/**
 * File name:Solution.java
 * Package name: classes
 * Proyect name: TSP
 */
package classes;

import java.util.ArrayList;

public class Solution{
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
	 * Constructor: Solution
	 */
	public Solution(ArrayList<Integer> path, int minimumDistance) {
		setMinimumDistance(minimumDistance);
		setPath(path);
	}
	/**
	 * toS
	 */
	public String toS() {
		String toS = "";
		toS += "Minimum distance: " + minimumDistance;
		toS += "\nPath: ";
		for(int i = 0; i < path.size(); i++) {
			if(i < path.size()-1)
				toS += (path.get(i) + 1) + " -> "; 
			else
				toS += (path.get(i) + 1);
		}
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
	 * getPathSize
	 */
	public int getPathSize() {
		return path.size();
	}
	/**
	 * getLastCity
	 */
	public int getLastCity() {
		return path.get(path.size()-1);
	}
	/**
	 * addCityToPath
	 */
	public void addCityToPath(int city) {
		path.add(city);
	}
	/**
	 * getPath
	 */
	public ArrayList<Integer> getPath(){
		return (ArrayList<Integer>) path.clone();
	}
	/**
	 * getMinimumDistance
	 */
	public int getMinimumDistance() {
		int aux = minimumDistance;
		return aux;
	}
}
