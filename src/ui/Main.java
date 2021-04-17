package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	private static HanoiTower hanoiT;
	public final static String INPUTPATH = "data/input.txt";
	public final static String OUTPUTPATH = "data/output.txt";
	
	public static void main(String[] args) {
		
		File inputFile = new File(INPUTPATH);
		BufferedReader br = null;
		int[] allCases;
		String solution="";
		
		try {
			br = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		int cases = 0;
		
		try {
			cases = Integer.parseInt(br.readLine());
			allCases = new int [cases];
			
			for (int i = 0; i < allCases.length; i++) {
				allCases[i] = Integer.parseInt(br.readLine());
			}
			
			for (int i = 0; i < allCases.length; i++) {
				solution += solveCases(allCases[i]);
			}
			saveSolution(solution);
			
			br.close();
		} catch (NumberFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static String solveCases(int caseX) throws FileNotFoundException {		
		hanoiT = new HanoiTower(caseX);
		String solution="";
		
		hanoiT.hanoiTowerS();
		solution = hanoiT.getSolution();
		return solution;
	}
	
	public static void saveSolution(String solution) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(OUTPUTPATH);
		pw.print(solution.replace("null", ""));
		pw.close();
	}
}