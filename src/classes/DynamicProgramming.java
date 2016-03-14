/**
 * File name:DynamicProgramming.java
 * Package name: classes
 * Proyect name: TSP
 */
package classes;

import javax.tools.Diagnostic;

import global.Globals;

public class DynamicProgramming {
	/** 
	 * Atributes
	 */
	private int numberOfCities;
	private int numberOfCitiesPow;
	/**
	 * Constructor: DynamicProgramming
	 */
	public DynamicProgramming() {
		
	}
	/**
	 * solve
	 */
	public Solution solve(Problem problem) {
		Solution solution = new Solution();
		setNumberOfCities(problem.getNumberOfCities());
		setNumberOfCitiesPow((int)Math.pow(2, getNumberOfCities()));
		int DPTable[][] = new int [getNumberOfCities()][getNumberOfCitiesPow()]; 
		int pathTable[][] = new int [getNumberOfCities()][getNumberOfCitiesPow()];
		
		for (int i = 0; i < getNumberOfCities(); i++) {
			for (int j = 0; j < getNumberOfCitiesPow(); j++) {
				DPTable[i][j] = -1;
				pathTable[i][j] = -1;
			}
		}
		
		for (int i = 0; i < getNumberOfCities(); i++) {
			DPTable[i][0] = problem.getDistance(i, 0);
		}
		
		solution.addCityToPath(Globals.START_CITY);
		solution.setMinimumDistance(dynamicProgrammingAlgorithm(0, getNumberOfCitiesPow() - 2, DPTable, pathTable, problem));
		getPath(0, getNumberOfCitiesPow() - 2, pathTable, solution);
		solution.addCityToPath(Globals.START_CITY);
		return solution;
	}
	/**
	 * dynamicProgrammingAlgorithm
	 */
	public int dynamicProgrammingAlgorithm(int start, int set, int[][]DPTable, int[][]pathTable, Problem problem) {
		int mask, masked, result = -1, temp;
		if(DPTable[start][set] != -1)
			return DPTable[start][set];
		else {
			for (int i = 0; i < getNumberOfCities(); i++) {
				mask = getNumberOfCitiesPow() - 1 - (int) Math.pow(2, i);
				masked = set & mask;
				if(masked != set) {
					temp = problem.getDistance(start, i) + dynamicProgrammingAlgorithm(i, masked, DPTable, pathTable, problem);
					if(result == -1 || result > temp) {
						result = temp;
						pathTable[start][set] = i;
					}
				}
			}
			DPTable[start][set] = result;
			return result;
		}
	}
	/**
	 * getPath
	 */
	public void getPath(int start, int set, int[][]pathTable, Solution solution) {
		if(pathTable[start][set] == -1)
			return;
		int x = pathTable[start][set];
		int mask = getNumberOfCitiesPow() -1 - (int)Math.pow(2, x);
		int masked = set & mask;
		
		solution.addCityToPath(x);
		getPath(x, masked, pathTable, solution);
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
	 * @return the numberOfCities
	 */
	public int getNumberOfCitiesPow() {
		int aux = numberOfCitiesPow;
		return aux;
	}
	/**
	 * @param numberOfCities the numberOfCities to set
	 */
	public void setNumberOfCitiesPow(int numberOfCitiesPow) {
		this.numberOfCitiesPow = numberOfCitiesPow;
	}
}
