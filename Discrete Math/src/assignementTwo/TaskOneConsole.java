package assignementTwo;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

import assignementTwo.TaskOne.PowerModCalculator;
import assignementTwo.TaskOne.PowerModCalculatorImp1;
import assignementTwo.TaskOne.PowerModCalculatorImp2;
import assignementTwo.TaskOne.PowerModCalculatorImp3;

public class TaskOneConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerModCalculator calculator = new PowerModCalculatorImp3();
		Scanner scn = new Scanner(System.in);
		PrintWriter wrt = new PrintWriter(System.out, true);
		wrt.println("This program preforms the operation (a^b)mod n.");
		wrt.println("Enter your a value :");
		String input = scn.nextLine().trim();
		while (!input.equals("exit")) {
			BigInteger a, b, n;
			a = new BigInteger(input);
			wrt.println("Enter your b value :");
			input = scn.nextLine().trim();
			b = new BigInteger(input);
			wrt.println("Enter your n value :");
			input = scn.nextLine().trim();
			n = new BigInteger(input);
			wrt.println(
			calculator.calculateApowerBmodN(a, b, n).toString());
			wrt.println("Enter your a value :");
			input = scn.nextLine().trim();
		}
		scn.close();
	}

}
