package assignementTwo;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import assignementTwo.TaskThree.ChineseCRTMapper;

public class TaskThreeConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChineseCRTMapper calculator
			= new ChineseCRTMapper();
		Scanner scn = new Scanner(System.in);
		PrintWriter wrt = new PrintWriter(System.out, true);
		wrt.println("CRT program, enter 1 for entering A & B and 2 for entring a list and b list");
		String input = scn.nextLine().trim();
		while (!input.equals("exit")) {
			if (input.equals("1")) {
				wrt.println("Enter your k value(m1, m2, ..., mk) :");
				ArrayList<Integer> m = new ArrayList<Integer>();
				Integer k = new Integer(scn.nextLine().trim());
				for (Integer i = 0;
						i < k;
						i ++) {
					wrt.println("Enter your m" + (i + 1)
							+ " value :");
					m.add(new Integer(scn.nextLine().trim()));
				}
				wrt.println("Enter your A value :");
				Integer a = new Integer(scn.nextLine().trim());
				wrt.println("Enter your B value :");
				Integer b = new Integer(scn.nextLine().trim());
				int result
					= calculator.solveCRTMethod2(m, a, b);
				wrt.print("A + B (mod M) = ");
				wrt.println(result);
			} else if (input.equals("2")){
				wrt.println("Enter your k value(m1, m2, ..., mk) :");
				ArrayList<Integer> m = new ArrayList<Integer>();
				Integer k = new Integer(scn.nextLine().trim());
				for (Integer i = 0;
						i < k;
						i++) {
					wrt.println("Enter your m" + (i + 1)
							+ " value :");
					m.add(new Integer(scn.nextLine().trim()));
				}
				ArrayList<Integer> a = new ArrayList<Integer>();
				for (Integer i = 0;
						i < k;
						i++) {
					wrt.println("Enter your a" + (i + 1)
							+ " value :");
					a.add(new Integer(scn.nextLine().trim()));
				}
				ArrayList<Integer> b = new ArrayList<Integer>();
				for (Integer i = 0;
						i < k;
						i++) {
					wrt.println("Enter your b" + (i + 1)
							+ " value :");
					b.add(new Integer(scn.nextLine().trim()));
				}
				Integer result = calculator.solveCRTMethod2(m, a, b);
				wrt.print("A + B (mod M) = ");
				wrt.println(result);
			}
			wrt.println("Enter your operation :");
			input = scn.nextLine().trim();
		}
		scn.close();
	}

}
