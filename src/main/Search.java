package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Search {
	
	public void searchByTitle(List<Book> listBook) {
		Scanner sc = new Scanner(System.in);
		List<Book> search = new ArrayList<Book>(listBook); 
		System.out.print("Nhập tựa sách cần tìm: ");
		String keyword = sc.nextLine();
		List<Book> result = new ArrayList<Book>();
		for (Book book : listBook) {
			String title = book.getTitle().toLowerCase();
			keyword = keyword.toLowerCase();
			if (title.contains(keyword)) {
				result.add(book);
			} 
		}
		if(result.size() > 0) {
			ShowList.displayBookList(result);
		}else {
			System.out.println("Không tìm thấy cuốn sách nào có tựa:" + keyword);
		}
	}

	public void searchByAuthor(List<Book> listBook) {
		List<Book> search = new ArrayList<Book>(listBook); 
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên tác giả cần tìm: ");
		String keyword = sc.nextLine();
		List<Book> result = new ArrayList<Book>();
		for (Book book : listBook) {
			String author = book.getAuthor().toLowerCase();
			keyword = keyword.toLowerCase();
			if (author.contains(keyword)) {
				result.add(book);
			} 
		}
		if(result.size() > 0) {
			ShowList.displayBookList(result);
		}else {
			System.out.println("Không tìm thấy cuốn sách nào có tên tác giả:" + keyword);
		}

	}

	public void searchByCode(List<Book> listBook) {
		List<Book> search = new ArrayList<Book>(listBook); 
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã cần tìm: ");
		String code = sc.nextLine();
		boolean check = false;
		for (Book b : listBook) {
			if (b.getCode().equals(code)) {
				System.out.println("Tìm thấy sách");
				System.out.println(b);
				check = true;
			}
		}if(!check) {
			System.out.println("Không tìm thấy mã "+ code +" trong thư viện");
		}
	}
}
