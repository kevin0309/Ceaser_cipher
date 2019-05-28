package main;

import java.io.File;
import java.util.ArrayList;

import util.FileUtil;

public class Main {

	public static void main(String[] args) {
		File cipherTextFile = new File("E:/ciphertext.txt");
		ArrayList<String> cipherText = FileUtil.readAll(cipherTextFile);
		System.out.println(cipherText.toString());
		ArrayList<String> plainText = decode(cipherText, 21);
		FileUtil.write("E:/plaintext.txt", plainText);
	}

	private static ArrayList<String> decode(ArrayList<String> cipherText, int shift) {
		ArrayList<String> result = new ArrayList<>();
		for (String cipherStr : cipherText) {
			String plainStr = "";
			for (int i = 0; i < cipherStr.length(); i++) {
				if (Character.isAlphabetic(cipherStr.charAt(i))) {
					char temp = (char)(cipherStr.charAt(i)+shift);
					if (Character.isUpperCase(cipherStr.charAt(i))) {
						if (!Character.isUpperCase(temp))
							temp-=26;
					}
					else if (!Character.isAlphabetic(temp))
						temp-=26;
					plainStr += temp;
				}
				else
					plainStr += cipherStr.charAt(i);
			}
			result.add(plainStr);
		}
		return result;
	}
}
