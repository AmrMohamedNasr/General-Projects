package assignementTwo.TaskOne;

import java.math.BigInteger;

public class PowerModCalculatorImp2 implements PowerModCalculator{

	@Override
	public BigInteger calculateApowerBmodN(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger result = BigInteger.ONE;
		// Will loop and multiply then mod b times.
		for (BigInteger i = BigInteger.ZERO;
				(b.compareTo(i) == 1);
				i = i.add(BigInteger.ONE)){
			result = result.multiply(a);
			result = result.mod(n);
		}
		return result;
	}

}
