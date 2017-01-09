package assignementTwo.TaskTwo;

import java.math.BigInteger;
import java.util.ArrayList;


public class ExtendedEuclidAlgorithm {
	public int getMultiplicativeInverse(int a,
			int n) {
		int r, x, y, ans, exp;
		int step = 0;
		ArrayList<Integer> p = new ArrayList<Integer>();
		ArrayList<Integer> q = new ArrayList<Integer>();
		p.add(0);
		p.add(1);
		r = 1;
		x = n;
		y = a;
		// Loop to get to the point where the rest is equal one.
		do {
			r = x % y;
			q.add((x - r) / y);
			x = y;
			y = r;
			if (step > 1) {
				exp = p.get(step - 2) - ((p.get(step - 1) * (q.get(step - 2))));
				p.add(exp % n);
			}
			step++;
		} while (r != 0);
		// Calculate the last expression step.
		// p(i) = p(i-2) - p(i-1) * q(i-2)
		exp = p.get(step - 2) - ((p.get(step - 1) * (q.get(step - 2))));
		// Then calculate its mod.
		ans = exp % n;
		while (ans < 0) {
			ans += n;
		}
		return ans;
	}

}
