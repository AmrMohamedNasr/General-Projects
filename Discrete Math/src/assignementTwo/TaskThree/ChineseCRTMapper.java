package assignementTwo.TaskThree;

import java.util.ArrayList;

import assignementTwo.TaskTwo.ExtendedEuclidAlgorithm;

public class ChineseCRTMapper {
	private ArrayList<Integer> mapToList(ArrayList<Integer> m,
			int a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < m.size(); i++) {
			list.add(a % (m.get(i)));
		}
		return list;
	}
	private Integer reverseMapFromList(ArrayList<Integer> m,
			ArrayList<Integer> a) {
		Integer mBig = 1;
		ExtendedEuclidAlgorithm calculator = new ExtendedEuclidAlgorithm();
		for (int i = 0; i < m.size(); i++) {
			mBig *= (m.get(i));
		}
		Integer mI, temp;
		Integer ans = 0;
		for (int i = 0; i < m.size(); i++) {
			mI = mBig / (m.get(i));
			temp = calculator.getMultiplicativeInverse(mI, m.get(i))
					*(mI)*(a.get(i));
			ans += (temp % (mBig));
		}
		return ans % mBig;
	}
	public int solveCRTMethod1(ArrayList<Integer> m,
			ArrayList<Integer> a, ArrayList<Integer> b) {
		int aA = reverseMapFromList(m, a);
		int bB = reverseMapFromList(m, b);
		int mM = 0;
		for (int i = 0; i < m.size(); i++) {
			mM += m.get(i);
		}
		return (aA % mM + bB % mM) % mM;
	}
	public int solveCRTMethod2(ArrayList<Integer> m,
			ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> x = new ArrayList<Integer>(); 
		for (int i = 0; i < m.size(); i++) {
			x.add(((a.get(i) + b.get(i)) % m.get(i)));
		}
		Integer result = reverseMapFromList(m, x);
		return result;
	}
	public int solveCRTMethod1(ArrayList<Integer> m,
			Integer a, Integer b) {
		Integer mBig = 1;
		for (int i = 0; i < m.size(); i++) {
			mBig *= (m.get(i));
		}
		ArrayList<Integer> aA = mapToList(m, a);
		ArrayList<Integer> bB = mapToList(m, b);
		long startTime = System.nanoTime();
		reverseMapFromList(m, aA);
		reverseMapFromList(m, bB);
		int result = (a % mBig + b % mBig) % mBig;
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
		return result;
	}
	public int solveCRTMethod2(ArrayList<Integer> m,
			Integer a, Integer b) {
		ArrayList<Integer> x = new ArrayList<Integer>(); 
		ArrayList<Integer> aA = mapToList(m, a);
		ArrayList<Integer> bB = mapToList(m, b);
		long startTime = System.nanoTime();
		for (int i = 0; i < m.size(); i++) {
			x.add(((aA.get(i) + bB.get(i)) % m.get(i)));
		}
		Integer result = reverseMapFromList(m, x);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
		return result;
	}
	
}
