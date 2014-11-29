
/**
 * @author Ashley
 *
 */
public class RailFenceCipher implements BaseCipher {
	//depths of rail fence set as instance vars
	int depthNum =2;
	String depth1;
	String depth2;

	@Override
	public String decrypt(String code) {
		clearAllDepths();

		int lengthDivision = 0;
		String decrypted = "";

		//determine based on input length
		if (code.length() % 2 != 0)
			lengthDivision = (code.length() / depthNum) + 1;
		else
			lengthDivision = (code.length() / depthNum);

		depth1 = code.substring(0, lengthDivision);
		depth2 = code.substring(lengthDivision, code.length());

		//iterate rows, add valid chars to depypted string
		for (int counter = 0; counter < lengthDivision; counter++) {
			if (depth1.length() > counter) {
				decrypted += depth1.charAt(counter);
			}

			if (depth2.length() > counter) {
				decrypted += depth2.charAt(counter);
			}
		}
		clearAllDepths();
		return decrypted;
	}

	@Override
	public String encrypt(String plainWords) { 
		clearAllDepths();
		
		String encrypted;

		//use to alternate rails
		boolean boolAlt = true;

		//iterate over rails, adding letters from input words to the rails alternately
		for (int counter = 0; counter < plainWords.length(); counter++) {
			if (boolAlt) {
				depth1 += plainWords.charAt(counter);
				boolAlt = false;
			} else {
				depth2 += plainWords.charAt(counter);
				boolAlt = true;
			}
		}
		//consolidate rails to a single string
		 encrypted = depth1 + depth2;

		clearAllDepths();

		return encrypted;
	}

	//reset first 2 depths
	private void clearAllDepths() {
		depth1 = "";
		depth2 = "";
	}
}
