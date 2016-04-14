package duke.arraylist;

import edu.duke.FileResource;

// Шифрування коду Цезаря
public class CaesarCipher {
	private String alphabet;
	private String shiftedAlphabet;
	private int theKey;

	public CaesarCipher(int key) {
		theKey = key;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		alphabet = alphabet + alphabet.toLowerCase();
		shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
	}

	private char transformLetter(char c, String from, String to) {
		int idx = from.indexOf(c);
		if (idx != -1) {
			return to.charAt(idx);
		}
		return c;
	}

	public char encryptLetter(char c) {
		return transformLetter(c, alphabet, shiftedAlphabet);
	}

	public char decryptLetter(char c) {
		return transformLetter(c, shiftedAlphabet, alphabet);
	}

	private String transform(String input, String from, String to) {
		StringBuilder sb = new StringBuilder(input);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			c = transformLetter(c, from, to);
			sb.setCharAt(i, c);
		}
		return sb.toString();
	}

	public String encrypt(String input) {
		return transform(input, alphabet, shiftedAlphabet);
	}

	public String decrypt(String input) {
		return transform(input, shiftedAlphabet, alphabet);
	}

	@Override
	public String toString() {
		return "" + theKey;
	}

	// first edition
	public String encrypt(String input, int key) {
		// first edishion
		// Make a StringBuilder with message (encrypted)
		StringBuilder encrypted = new StringBuilder(input);
		// Write down the alphabet
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// Compute the shifted alphabet
		String shiftedAlphabet = alphabet.substring(key)
				+ alphabet.substring(0, key);
		// / encrypted.setCharAt(index, ch);
		// Count from 0 to < length of encrypted, (call it i)
		for (int i = 0; i < encrypted.length(); i++) {
			// Look at the ith character of encrypted (call it currChar)
			char currChar = encrypted.charAt(i);
			// Find the index of currChar in the alphabet (call it idx)
			int idx = alphabet.indexOf(currChar);
			// If currChar is in the alphabet
			if (idx != -1) {
				// Get the idxth character of shiftedAlphabet (newChar)
				char newChar = shiftedAlphabet.charAt(idx);
				// Replace the ith character of encrypted with newChar
				encrypted.setCharAt(i, newChar);
			}
			// Otherwise: do nothing
		}
		// Your answer is the String inside of encrypted
		return encrypted.toString();
	}

	public void testCaesar() {
		int key = 17;
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		System.out.println("key is " + key + "\n" + encrypted);
		String decrypted = encrypt(encrypted, 26 - key);
		System.out.println(decrypted);

	}

	public String encryptAnySimbols(String input, int key) {
		// TODO Доробити Щоб працював і з малими буквами

		// Make a StringBuilder with message (encrypted)

		StringBuilder encrypted = new StringBuilder(input);

		for (int k = 0; k < encrypted.length(); k++) {

			char ch = encrypted.charAt(k);
			char uch = Character.toUpperCase(ch);
			encrypted.setCharAt(k, uch);
		}

		// Write down the alphabet
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// Compute the shifted alphabet
		String shiftedAlphabet = alphabet.substring(key)
				+ alphabet.substring(0, key);
		// / encrypted.setCharAt(index, ch);
		// Count from 0 to < length of encrypted, (call it i)
		for (int i = 0; i < encrypted.length(); i++) {
			// Look at the ith character of encrypted (call it currChar)
			char currChar = encrypted.charAt(i);
			// Find the index of currChar in the alphabet (call it idx)
			int idx = alphabet.indexOf(currChar);
			// If currChar is in the alphabet
			if (idx != -1) {
				// Get the idxth character of shiftedAlphabet (newChar)
				char newChar = shiftedAlphabet.charAt(idx);
				// Replace the ith character of encrypted with newChar
				encrypted.setCharAt(i, newChar);
			}
			// Otherwise: do nothing
		}
		// Your answer is the String inside of encrypted
		return encrypted.toString();
	}
}
