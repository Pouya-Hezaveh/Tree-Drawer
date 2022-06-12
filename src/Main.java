import java.util.Scanner;

/**
 * @author Pouya Hezaveh
 */

public class Main {
	
	//Golden Ratio :D
	final static double GR = (1+Math.sqrt(5))/2;
	//one Radian In Degree
	final static double RAD = 57.2958;

	static double degInRad(double degree) {
		return (degree%360)/RAD;
	}
	
	static void develop(int n, double x, double y, double lenght, double angle) {
		if(n<0) return;
		
		StdDraw.line(x, y, x+lenght*Math.cos(angle), y+lenght*Math.sin(angle));
		StdDraw.setPenRadius(StdDraw.getPenRadius()/GR);
		
		develop(n-1,x+lenght*Math.cos(angle), y+lenght*Math.sin(angle), lenght/GR, angle-degInRad(90/GR/GR));
		develop(n-1,x+lenght*Math.cos(angle), y+lenght*Math.sin(angle), lenght/GR, angle+degInRad(90/GR/GR/GR));
		develop(n-1,x+lenght*Math.cos(angle), y+lenght*Math.sin(angle), lenght/GR, angle+degInRad(90/GR));
		
		StdDraw.setPenRadius(StdDraw.getPenRadius()*GR);
	}
	
	public static void main(String[] args) {
		
		// initializing the canvas and the pen
	    StdDraw.setCanvasSize((int)(600*GR), 600);
	    StdDraw.setPenColor(200,200,200);
	    StdDraw.filledRectangle(0.5, 0.5, 0.5, 0.5);
	    StdDraw.setPenColor(25,(int)(25*GR),(int)(25*GR*GR));
	    StdDraw.filledRectangle(0.5, 0.5, 0.475, 0.475);
	    StdDraw.setXscale(0-(GR-1)/GR/2, 1+(GR-1)/GR/2);
	    StdDraw.setPenColor((int)(80*GR*GR),(int)(80*GR),80);
	    StdDraw.setPenRadius(0.05);
	    
		//input the number of branches
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		
		//draws and developes the branches
		develop(number,1/GR,0,1/GR/GR,degInRad(90));
		
	}
}
