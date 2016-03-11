/**
 * File name:ReadInputFile.java
 * Package name: clases
 * Proyect name: daa_ramMachine
 */
package global;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	/** 
	 * Atributes
	 */
	private int numberOfCities;
	private ArrayList<ArrayList<Integer>> distances;
	
	/**
	 * Constructor: ReadInputFile
	 */
	public ReadFile(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = "";
			boolean correctFormat = true;
			parseNumberOfCities(br.readLine());
			distances = new ArrayList<>();
			for(int i = 0; i < numberOfCities; i++) {
				distances.add(new ArrayList<>());
				for(int j = 0; j < numberOfCities; j++) {
					distances.get(i).add(0);					
				}
			}
			while((line = br.readLine()) != null && correctFormat) {
				correctFormat = parseDistances(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * parseNumberOfCities
	 */
	public boolean parseNumberOfCities(String firstLine) {
		numberOfCities = Integer.parseInt(firstLine);
		return true;
	}
	/**
	 * parseDistances
	 */
	public boolean parseDistances(String line) {
		String[] distanceText = line.split(" ");
		int[] distance = new int[distanceText.length];		
		for(int i = 0; i < distance.length; i++)
			distance[i] = Integer.parseInt(distanceText[i]);
		
		if(distance.length != 3) {
			System.out.println("Error en los datos de entrada.");
			return false;
		}else {
			distances.get(distance[0] - 1).set(distance[1] - 1, distance[2]);
			return true;
		}
	}
	/**
	 * @return the numberOfCities
	 */
	public int getNumberOfCities() {
		return numberOfCities;
	}
	/**
	 * @return the distances
	 */
	public ArrayList<ArrayList<Integer>> getDistances() {
		return distances;
	}
}
