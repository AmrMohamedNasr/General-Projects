package assignementTwo;

import java.math.BigInteger;
import java.util.Random;

import assignementTwo.TaskOne.PowerModCalculator;
import assignementTwo.TaskOne.PowerModCalculatorImp1;
import assignementTwo.TaskOne.PowerModCalculatorImp2;
import assignementTwo.TaskOne.PowerModCalculatorImp3;

public class TaskOneTime {
	
	private static Random rnd = new Random();

	public static String getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    for(int i=0; i < digCount; i++)
	        sb.append((char)('0' + rnd.nextInt(10)));
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		PowerModCalculator calculator1 = new PowerModCalculatorImp1();
		PowerModCalculator calculator2 = new PowerModCalculatorImp2();
		PowerModCalculator calculator3 = new PowerModCalculatorImp3();
		BigInteger a = new BigInteger(getRandomNumber(1));
		BigInteger b = new BigInteger(getRandomNumber(4));
		BigInteger n = new BigInteger(getRandomNumber(2));
		long startTime = System.currentTimeMillis();
		calculator1.calculateApowerBmodN(a, b, n);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
		startTime = System.currentTimeMillis();
		calculator2.calculateApowerBmodN(a, b, n);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
		startTime = System.currentTimeMillis();
		calculator3.calculateApowerBmodN(a, b, n);
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}
}
