package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {
	
	public static ArrayList<String> readAll(File file) {
		ArrayList<String> result = new ArrayList<>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while (true) {
				String temp = br.readLine();
				if (temp == null)
					break;
				result.add(temp);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void write(String filePath, ArrayList<String> strArr) {
		try {
			File file = new File(filePath);
			if (!file.exists())
				file.getParentFile().mkdirs();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (String str : strArr) {
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
