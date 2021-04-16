package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int towers[] = new int[3];
	
	public static void main(String[] args) {
		
		int movs = 0;
		int n = 1;
		System.out.println("Insert the number of discs");
		
		try {
			
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
		hanoiTowers(n);
	}

	private static void hanoiTowers(int n) {
		
		System.out.println(n+" "+0+" "+0);
		hanoiTowers(n,n,n,0,0);
		
	}

	 private static int[] hanoiTowers(int initN, int n, int a, int b, int c) {
		
		towers[0] = a;
		towers[1] = b;
		towers[2] = c;
		 
		if(n==1 && initN%2 != 0) {
			//System.out.println(towers[0]+":"+towers[2]);
			
			towers[0]--;
			towers[2]++;
			System.out.println(towers[0]+" "+towers[1]+" "+towers[2]+ "  BBB");
			return towers;
			
		}else if(n!=1 && initN%2 != 0) {
			
			hanoiTowers(initN,n-1,towers[0],towers[1],towers[2]);
			
			towers[0]--;
			towers[2]++;
			System.out.println(towers[0]+" "+towers[1]+" "+towers[2]);
			
			hanoiTowers(initN-1,n-1,towers[1],towers[0],towers[2]);
			
		}else if(n==1 && initN%2 == 0) {
			//System.out.println(towers[0]+":"+towers[1]);
			towers[0]--;
			towers[1]++;
			System.out.println(towers[0]+" "+towers[1]+" "+towers[2]+"  AAA");
			return towers;
			
		}else if(n!=1 && initN%2 == 0) {
			
			hanoiTowers(initN,n-1,towers[0],towers[1],towers[2]);
			
			towers[0]--;
			towers[2]++;
			System.out.println(towers[0]+" "+towers[1]+" "+towers[2]);
			
			hanoiTowers(initN-1,n-1,towers[1],towers[0],towers[2]);
			
		}
			
			return towers;
	}

}
