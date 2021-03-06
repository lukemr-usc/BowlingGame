/*
 * Created by: Luke Russell
 * Date Completed: 3/6/21
 * Comments: N/A
 * Input: Bowling scores per frame
 * Output: Total score
 */

import java.util.Scanner;

public class Bowling_Game {
	
	public static final int fSize = 10;
	public static final int tSize = 23;
	public static final int[] THROWS = new int[tSize];
	public static final int[] FRAME = new int[fSize];
	public static int SCORE = 0;
	public static int throwCount = 0;
	public static int frameCount = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to bowling!");
		Scanner keyboard = new Scanner(System.in);
		String throw_1;
		String throw_2;
		String throw_3;
		
		//populates arrays
		for(int i=0; i<fSize; i++) {
				System.out.println("Frame "+(frameCount+1));	
				throw_1 = keyboard.nextLine();
				
				//checks for strike
				if(throw_1.equalsIgnoreCase("X")) {
					strikeFrame(throw_1);
					//checks for final frame
					if(i==9) {
						throw_2 = keyboard.nextLine();
						throw_3 = keyboard.nextLine();
						finalFrameStrike(throw_2,throw_3);
					}
					continue;
				}
				
				//checks for spare
				throw_2 = keyboard.nextLine();
				if(throw_2.equals("/")) {
					spareFrame(throw_1);
					//checks for final frame
					if(i==9) {
						throw_3 = keyboard.nextLine();
						finalFrameSpare(throw_3);
					}
					continue;
				}
				
				//checks for open frame
				else {
					normalFrame(throw_1, throw_2);
					continue;
				}
		}
		
		//calculates score
		for(int i=0; i<tSize-2; i++) {
			
			//score condition for strike
			if(THROWS[i] == 10) {
				SCORE+=THROWS[i]+THROWS[i+1]+THROWS[i+2];
				continue;
				
			}
			//score condition for spare
			if(THROWS[i]+THROWS[i+1]==10 && THROWS[i]==THROWS[i+2]) {
				SCORE+=10+THROWS[i+2];
				THROWS[i]=0;
				THROWS[i+1]=0;
				continue;
			}
			
			//score condition for open frame
			else{
				SCORE+= THROWS[i];
			}
		}
		
		
		System.out.println("\nFinal Score: "+SCORE);
		
	}
	
	
	public static void finalFrameStrike(String t1, String t2) {
		int num1 = 0;
		int num2 = 0;
	
		SCORE+=10;

		
		if(t1.equalsIgnoreCase("X")) {
			num1 = 10;
		}
		if(t2.equalsIgnoreCase("X")) {
			num2 = 10;
		}
		if(num1!=10) {
			num1 = Integer.parseInt(t1);
		}
		if(num2!=10) {
			num2 = Integer.parseInt(t2);
		}
		
		SCORE+=num1+num2;
		
	}
	
	public static void finalFrameSpare(String t1) {
		int num = 0;
		num = Integer.parseInt(t1);
		SCORE += num;
	}
	
	
	public static void spareFrame(String t1) {
		THROWS[throwCount] = Integer.parseInt(t1);
		THROWS[throwCount+1] = 10-THROWS[throwCount];
		throwCount+=2;
		frameCount++;

	}
	
	public static void strikeFrame(String t1) {
		THROWS[throwCount] = 10;
		throwCount++;
		frameCount++;
	}
	
	public static void normalFrame(String t1, String t2) {
		int num1 = 0;
		int num2 = 0;
		
		num1 = Integer.parseInt(t1);
		num2 = Integer.parseInt(t2);
		THROWS[throwCount] = num1;
		THROWS[throwCount+1] = num2;
		throwCount+=2;
		frameCount++;
	}
	

}
