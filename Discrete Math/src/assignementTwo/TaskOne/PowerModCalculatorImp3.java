package assignementTwo.TaskOne;

import java.math.BigInteger;

public class PowerModCalculatorImp3 implements PowerModCalculator {

	@Override
	public BigInteger calculateApowerBmodN(BigInteger a, BigInteger b, BigInteger n) {
		// Transforms the the power to binary
		String power = b.toString(2);
		BigInteger result = BigInteger.ONE;
		// Loop on each of the binary bit of the power
		// from the biggest bit and then checks if the bit
		// is one it multiplies by a one time
		for(int i = 0; i < power.length(); i++) {
			result = (result.multiply(result)).mod(n);
			if (power.charAt(i) == '1') {
				result = (result.multiply(a)).mod(n);
			}
		}
		return result;
	}

}
