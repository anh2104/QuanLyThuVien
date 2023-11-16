package main;

import java.io.Serializable;

public class Book implements Serializable {
static int currCode = 0;
	
	String code, title, author,category, year;
	
	// Để dữ liệu đọc được ở dạng String
	public Book(String input) {  
		String[] parts = input.split(";");
		this.code = parts[0];
		this.title = parts[1];
		this.author = parts[2];
		this.category = parts[3];
		this.year = parts[4];
		updateCode(code);
	}
	public Book(String title,String author, String category, String year) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
		this.code = (currCode + 1) + "";
		currCode++;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setCategory(String category) {
		this.category = category;
	}public String getCategory() {
		return category;
	}
	public static void setCurrCode(int currCode) {
		Book.currCode = currCode;
	}
	public static int getCurrCode() {
		return currCode;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getYear() {
		return year;
	}
	public static void updateCode(String code) {
		int _code = Integer.parseInt(code);
		if(_code > currCode ) currCode = _code;
	}
	public void printBookInfo() {
		String [] titles = warpLine(title, 25);
		String [] authors = warpLine(author, 20);
		String [] categories = warpLine(category, 15);
		int max = Math.max(titles.length, authors.length);
		max = Math.max(max , categories.length);
		System.out.println("---------------------------------------------------------------------------------");
		for (int i = 0; i < max; i++) {
			String code = i == 0? this.code: "";
			String title = i < titles.length? titles[i] : "";
			String author = i < authors.length? authors[i] : "";
			String category = i < categories.length? categories[i] : "";
			String year = i == 0? this.year: "";
			String output = String.format("%6s | %25s | %20s | %15s | %5s |",
					code,title, author,category,year);
			System.out.println(output);
		}
		
	}
	@Override
	public String toString() {
		
		return "[" + code + "][ title :" + title + "][ author :" + author + "][ category :" + category + "][ year :" + year + "]";
	}
	public static String[] warpLine(String input, int width) {
		StringBuilder sbd = new StringBuilder();
		while(input.length() > width ) {
			if(input.length()<= width) {
				sbd.append(input.trim());
				sbd.append(";");
			}
			int c = 0;
			if(input.charAt(width - 1) != ' ') {
				c = input.lastIndexOf(" ", width - 1);
			}else {
				c = width - 1;
			}
			String sub1 = input.substring(0, c);
			sbd.append(sub1.trim());
			sbd.append(";");
			String rest = input.substring(c + 1);
			input = rest;
		}
		sbd.append(input.trim());
		return sbd.toString().split(";");
		
	}
	public String getLine() {
		
		return code + ";"+ title+";"+ author+";"+ category+";"+ year+";";
		
	}
	public static void printColumnTitle() {
		String output = String.format("%6s %25s %20s %15s %5s",
				"MA","TUA SACH", "TAC GIA","THE LOAI","NAM XB");
		System.out.println(output);
	}

}
