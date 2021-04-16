package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
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

	 private static void hanoiTowers(int initN, int n, int a, int b, int c) {
		
		if(n==1 && initN%2 != 0) {
			a--;
			c++;
			System.out.println(a+" "+b+" "+c);
			return;
		
			
			
		}else if(n==1 && initN%2 != 0) {
			a--;
			c++;
			System.out.println(a+" "+b+" "+c);
			return;
		}else {
			hanoiTowers(initN,n-1,a,c,b);
			
			System.out.println(a+" "+b+" "+c);
			
			hanoiTowers(initN,n-1,b,a,c);
		}
	}

}
