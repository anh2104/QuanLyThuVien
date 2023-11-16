package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShowList {

	public static void displayBookList(List<Book> listBook){
		if(listBook.isEmpty()) {
			System.out.println("Không tìm thấy danh sách nào!");
		}else {
			Book.printColumnTitle() ;
			for (Book book : listBook) {
				book.printBookInfo();
			}
		}
	}
	
	 public void displayBooksSortedByCode(List<Book> listBook) {
		 List<Book> sortedBooks = new ArrayList<Book>(listBook);
		 System.out.println("Hiển thị danh sách sắp xếp theo mã");
	      Collections.sort(sortedBooks, Comparator.comparing(Book::getCode));
	      displayBookList(sortedBooks);
		
	 }
	 public void displayBooksSortedByTitle(List<Book> listBook) {
		  List<Book> sortedBooks = new ArrayList<Book>(listBook);
		 System.out.println("Hiển thị danh sách sắp xếp theo tựa sách");
		 Collections.sort(sortedBooks, Comparator.comparing(Book::getTitle));
	     displayBookList(sortedBooks);
	  }
	 public void displayBooksSortedByAuthor(List<Book> listBook) {
		 List<Book> sortedBooks = new ArrayList<Book>(listBook);
		 System.out.println("Hiển thị danh sách sắp xếp theo tên tác giả");
		 Collections.sort(sortedBooks, Comparator.comparing(Book::getAuthor));
		 displayBookList(sortedBooks);
	  }
	 public void displayBooksSortedByCategory(List<Book> listBook) {
		 List<Book> sortedBooks = new ArrayList<Book>(listBook);
		 System.out.println("Hiển thị danh sách sắp xếp theo thể loại");
		 Collections.sort(sortedBooks, Comparator.comparing(Book::getCategory));
		 displayBookList(sortedBooks);
	   }

	   public void displayBooksSortedByYear(List<Book> listBook) {
		   List<Book> sortedBooks = new ArrayList<Book>(listBook);
		   System.out.println("Hiển thị danh sách sắp xếp theo năm xuất bản");
		   Collections.sort(sortedBooks, Comparator.comparing(Book::getYear));
		   displayBookList(sortedBooks);
	   }
	   
}
