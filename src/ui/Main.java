package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	private static HanoiTower hanoiT;
	public final static String INPUTPATH = "data/input.txt";
	
	public static void main(String[] args) {
		
		
		File inputFile = new File(INPUTPATH);
		BufferedReader br = null;
		int[] allCases;
		
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
				allCases[i] = Integer.parseInt(br.readLine());;
			}
			
			for (int i = 0; i < allCases.length; i++) {
				solveCases(allCases[i]);
			}
			br.close();
		} catch (NumberFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void solveCases(int caseX) {		
		hanoiT = new HanoiTower(caseX);
		hanoiT.hanoiTowerS();
	}
}