package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataIO {
public static String root = "";
	
	public static ArrayList<Book> loadFile(String fileName) {
		char[] s = {File.separatorChar};
		String sp = new String(s);
		File file = new File(root +sp+ fileName);
		
		FileReader fread = null;
		BufferedReader buffR = null;
		ArrayList<Book> list = new ArrayList<>();  
		
		try {
			fread = new FileReader(file);
			buffR = new BufferedReader(fread);
			
			String line;
			while((line = buffR.readLine()) != null) {
				Book b = new Book(line);
				list.add(b);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(buffR != null)
					buffR.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
			
	}
}

