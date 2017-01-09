package assignementTwo;

import java.util.ArrayList;
import java.util.Random;

import assignementTwo.TaskThree.ChineseCRTMapper;

public class TaskThreeTime {

	private static Random rnd = new Random();

	public static Integer getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    for(int i=0; i < digCount; i++)
	        sb.append((char)('0' + rnd.nextInt(10)));
	    return Integer.valueOf(sb.toString());
	}

	public static void main(String[] args) {

		ChineseCRTMapper crt = new ChineseCRTMapper();
		ArrayList<Integer> m = new ArrayList<Integer>();
		m.add(3);
		m.add(5);
		m.add(8);
		int d = 6;
		crt.solveCRTMethod1(m, getRandomNumber(d), getRandomNumber(d));
		crt.solveCRTMethod2(m, getRandomNumber(d), getRandomNumber(d));
	}

}
