import java.math.BigInteger;

public class Iban {

	public static void main(String[] args) {
		String blzString = args[0];
		String ktoString = args[1];
		String bban = blzString + ktoString;
		String countryCode = "DE";
		String countryNum = "131400"; // Position number of the letter + 9: D=4+9, E=5+9 - added by two zeros
		String checkdigitStr;
		String iban;
		int checkDigit;
						  
		String checkSum = bban + countryNum;
		BigInteger checksumBig = new BigInteger(checkSum);
		BigInteger checksumMod = checksumBig.mod(new BigInteger("97"));
		checkDigit = 98 - checksumMod.intValue();
		if(checkDigit < 10)
			checkdigitStr = "0" + String.valueOf(checkDigit);  // add a left-hand zero
		else
			checkdigitStr = String.valueOf(checkDigit);
		iban = countryCode + checkdigitStr + bban;
				
		System.out.println(iban);
	}

}
