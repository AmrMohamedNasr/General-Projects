package assignementTwo.TaskOne;

import java.math.BigInteger;

public class PowerModCalculatorImp1 implements PowerModCalculator{

	@Override
	public BigInteger calculateApowerBmodN(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger result = BigInteger.ONE;
		// The will loop and multiply b times.
		for (BigInteger i = BigInteger.ZERO;
				(b.compareTo(i) == 1);
				i = i.add(BigInteger.ONE)){
			result = result.multiply(a);
		}
		// Then mod one time only.
		result = result.mod(n);
		return result;
	}
}
