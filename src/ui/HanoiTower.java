package ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HanoiTower {
	
	private int[] towers;
	private int disks;
	public final static String OUTPUTPATH = "data/output.txt";
	public static final int TOWER_AMOUNT = 3;
	public static final int TOWER_1 = 0;
	public static final int TOWER_2 = 1;
	public static final int TOWER_3 = 2;
	private BufferedWriter bw;
	
	public HanoiTower(int n) {
		File outputFile = new File(OUTPUTPATH);
		
		try {
			bw = new BufferedWriter(new FileWriter(outputFile));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		towers = new int[TOWER_AMOUNT];
		disks = n;
		towers[TOWER_1] = n;
	}
	
	public void hanoiTowerS() {
		try {
			bw.write(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
			bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
		hanoiTowerS(disks, TOWER_1, TOWER_3, TOWER_2);
		System.out.print("\n");
	}

	private void hanoiTowerS(int k, int origin, int target, int aux) {
		
		
		if(k>0) {
			
			hanoiTowerS(k-1, origin, aux, target);
			
			towers[origin]--;
			towers[target]++;
			
			System.out.println(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
			try {
				bw.write(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
				bw.newLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			hanoiTowerS(k-1, aux, target, origin);
		}
	}
}
