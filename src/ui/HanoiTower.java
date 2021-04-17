package ui;

import java.io.FileNotFoundException;

public class HanoiTower {
	
	private int[] towers;
	private int disks;
	public static final int TOWER_AMOUNT = 3;
	public static final int TOWER_1 = 0;
	public static final int TOWER_2 = 1;
	public static final int TOWER_3 = 2;
	private String solution;
	
	public HanoiTower(int n) {
		
		towers = new int[TOWER_AMOUNT];
		disks = n;
		towers[TOWER_1] = n;
	}
	
	public void hanoiTowerS() throws FileNotFoundException {
		
		//System.out.println(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
		addSol(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
		hanoiTowerS(disks, TOWER_1, TOWER_3, TOWER_2);
		//System.out.print("\n");
		addSol("");
		//System.out.println(solution);
	}

	private void hanoiTowerS(int k, int origin, int target, int aux) {
		
		
		if(k>0) {
			
			hanoiTowerS(k-1, origin, aux, target);
			
			towers[origin]--;
			towers[target]++;
			
			//System.out.println(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
			addSol(towers[TOWER_1]+" "+towers[TOWER_2]+" "+towers[TOWER_3]);
			
			hanoiTowerS(k-1, aux, target, origin);
		}
	}
	
	public void addSol(String x) {
		solution += x+"\n";
	}

	public String getSolution() {
		return solution;
	}	
}
