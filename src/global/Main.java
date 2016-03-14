/**
 * File name:Main.java
 * Package name: global
 * Proyect name: TSP
 */
package global;

import java.util.Scanner;

import classes.BruteForce;
import classes.DynamicProgramming;
import classes.Greedy;
import classes.Problem;
import classes.Solution;

public class Main {	
	/**
	 * main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean stop = true;
		System.out.println("\tTravelling Salesman Problem (TSP)\n");
		System.out.println("Type the path of the file with the input data:");
		
		Scanner userInput = new Scanner(System.in);
		String inputFile = userInput.nextLine();
		ReadFile readFile = new ReadFile(inputFile);
		
		Problem problem = new Problem(readFile.getNumberOfCities(), readFile.getDistances());
		System.out.println("\nInformation:\n" + problem.toS());
		
		Greedy greedy = new Greedy();
		BruteForce bruteForce = new BruteForce();
		DynamicProgramming dp = new DynamicProgramming();
		Solution solution = new Solution();
		
		while (stop) {
			System.out.println("\nOpciones:\n1. Run greedy.\n2. Run exhaustive.\n3. Run dynamic programming.\n4. Run all.\n0. Stop program");
			switch (userInput.nextInt()) {
			case 1:
				System.out.println("\nGreedy: ");
				solution = greedy.solve(problem);
				System.out.println(solution.toS());
				break;
			case 2:
				System.out.println("\nExhaustive: ");
				solution = greedy.solve(problem);
				solution = bruteForce.solve(problem, solution);
				System.out.println(solution.toS());
				break;
			case 3:
				System.out.println("\nDynamic Programming: ");
				solution = dp.solve(problem);
				System.out.println(solution.toS());
				break;
			case 4:
				System.out.println("\nGreedy: ");
				solution = greedy.solve(problem);
				System.out.println(solution.toS());
				System.out.println("\nExhaustive: ");
				solution = bruteForce.solve(problem, solution);
				System.out.println(solution.toS());
				System.out.println("\nDynamic Programming: ");
				solution = dp.solve(problem);
				System.out.println(solution.toS());
				break;
			case 5:
				stop = false;
				break;
			default:
				System.out.println("¡Error!Choose one valid option.");
				break;
			}
		}
		userInput.close();
	}
}
