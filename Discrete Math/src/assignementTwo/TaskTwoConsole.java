package assignementTwo;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

import assignementTwo.TaskTwo.ExtendedEuclidAlgorithm;

public class TaskTwoConsole {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtendedEuclidAlgorithm calculator
			= new ExtendedEuclidAlgorithm();
		Scanner scn = new Scanner(System.in);
		PrintWriter wrt = new PrintWriter(System.out, true);
		wrt.println("This program get the multipicative inverse of a % n.");
		wrt.println("Enter your a value :");
		String input = scn.nextLine().trim();
		while (!input.equals("exit")) {
			Integer a, n;
			a = new Integer(input);
			wrt.println("Enter your n value :");
			input = scn.nextLine().trim();
			n = new Integer(input);
			wrt.println(
			calculator.getMultiplicativeInverse(a, n));
			wrt.println("Enter your a value :");
			input = scn.nextLine().trim();
		}
		scn.close();
	}
}
