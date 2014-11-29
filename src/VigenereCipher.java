/**
 * @author Ashley Li
 * The Vigenère cipher is a polyalphabetic substitution cipher
 *  that uses
 *  a series of different Caesar ciphers.
 *
 */
public class VigenereCipher implements BaseCipher {

	String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Override
	public String decrypt(String code) {
		 StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < code.length(); i++) {
		        char c = code.charAt(i);
		            int keyCharValue = key.charAt(i % key.length()) - 'A';
		            c -= keyCharValue;
		        sb.append(c);
		    }
		    return sb.toString();
	}

	@Override
	public String encrypt(String plainWords) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < plainWords.length(); i++) {
			char c = plainWords.charAt(i);
			int keyCharValue = key.charAt(i % key.length()) - 'A';
			c += keyCharValue;
			sb.append(c);
		}
		return sb.toString();
	}

}
