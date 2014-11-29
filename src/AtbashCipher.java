
/**
 * @author Ashley Li
 * 
 * The Atbash cipher is a very specific case of a substitution cipher
 *  where the letters of the alphabet are reversed
 *
 */
public class AtbashCipher implements BaseCipher {

	@Override
	public String decrypt(String code) {
		// convert String to array of chars
		char[] buffer = code.toCharArray();
		// Loop over characters.
		for (int i = 0; i < buffer.length; i++) {
			// Shift letter 25 chars, moving back or forward 26 places as needed
			char letter = buffer[i];
			letter = (char) (letter - 25);
			if (letter > 'z') {
				letter = (char) (letter - 26);
			} else if (letter < 'a') {
				letter = (char) (letter + 26);
			}
			buffer[i] = letter;
		}
		// Return final string.
		return new String(buffer);
	}

	@Override
	public String encrypt(String plainWords) {
		// convert String to array of chars
		char[] buffer = plainWords.toCharArray();
		// Loop over characters
		for (int i = 0; i < buffer.length; i++) {
			// Shift letter 25 chars, moving back or forward 26 places as needed
			char letter = buffer[i];
			letter = (char) (letter + 25);
			if (letter > 'z') {
				letter = (char) (letter - 26);
			} else if (letter < 'a') {
				letter = (char) (letter + 26);
			}
			buffer[i] = letter;
		}
		// Return final string.
		return new String(buffer);
	}
	}


