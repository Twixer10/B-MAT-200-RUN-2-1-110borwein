package re.fazan.borwein;

import static re.fazan.borwein.Maths.*;
import java.util.Scanner;  


public class Main {

	public static void main(String[] args) {
		
		int n = 0;
		
		if (args.length == 1 && args[0].equals("-h")) {
			printHelp();
			System.exit(0);
		}
		if (args.length != 1) {
			printErr();
			System.exit(84);
		}
		
		try {
			n = Integer.parseInt(args[0]);
		} catch(Exception err) {
			exit_err(err.toString());
		}
		
		if (n >= 0) {
			midpoint(n);
			trapezoidal(n);
			simpson(n);
		} else
			exit_err("Error: n cannot be negative.");
	}
	
	public static void exit_err(String msg) {
		System.out.println(msg);
		System.exit(84);
	}
	
	public static void printHelp() {
	    System.out.printf("USAGE\n    ./110borwein n\n\nDESCRIPTION\n    n    constant defining the integral to be computed\n");
	}
	
	public static void printErr() {
		System.out.println("Wrong arguments.");
		System.out.println("Try './110borwein -h' to have more information.");
	}
}
