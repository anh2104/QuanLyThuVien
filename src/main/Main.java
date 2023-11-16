package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		
		DataIO.root = "D:\\J78_BaiTapCuoiKhoa";
		List<Book> listBook = DataIO.loadFile("book_data.txt");
		Scanner sc = new Scanner(System.in);
		
		int chon = -1;
		do {
			try {
				printMainMenu();
				System.out.println("\n Nhập lựa chọn:");
				chon = sc.nextInt() ;
				switch (chon) {
				case 1: 
					showList(listBook);
					break;
				case 2: 
					search(listBook);
					break;
				case 3: 
					addBook(listBook);
					break;
				case 4: 
					removeBook(listBook);
					break;
				case 5: 
					updateBook(listBook);
					break;
				case 0:
					break;
				default:
					System.out.println("Nhập sai!");
				}
			} catch (Exception e) {
				System.out.println("Lỗi: " + e.getMessage());
				sc = new Scanner(System.in);
			}
			
		}while(chon != 0);
	}
	private static void showList(List<Book> listBook) {
		ShowList show = new ShowList();
		Scanner input = new Scanner(System.in);
		int choose;
		do {
			printShowMenu();
			System.out.println("\n Nhập lựa chọn hiển thị:");
			choose = input.nextInt();
			switch(choose) {
			case 1:
				show.displayBooksSortedByCode(listBook);
				break;
			case 2:
				show.displayBooksSortedByTitle(listBook);
				break;
			case 3:
				show.displayBooksSortedByAuthor(listBook);
				break;
			case 4:
				show.displayBooksSortedByCategory(listBook);
			case 5:
				show.displayBooksSortedByYear(listBook);
			case 0:
				break;
			default:
				System.out.println("Nhập sai!");	
			}
		}while(choose != 0);
		
	}
	private static void printShowMenu() {
		System.out.println("\n-------------- SHOW ------------");
		System.out.println("1.Hiển thị danh sách theo mã");
		System.out.println("2.Hiển thị danh sách theo tên tựa sách");
		System.out.println("3.Hiển thị danh sách theo tên tác giả ");
		System.out.println("4.Hiển thị danh sách theo thể loại");
		System.out.println("5.Hiển thị danh sách theo năm xuất bản mới - cũ");
		System.out.println("0. Quay lại");
		
	}
	public static void printMainMenu() {
		System.out.println("\n -------MENU------- ");
		System.out.println("1. Hien thi danh sach");
		System.out.println("2. Tim kiem");
		System.out.println("3. Them sach");
		System.out.println("4. Xoa sach");
		System.out.println("5. Sua thong tin");
		System.out.println("0. Thoat");
		
	}

	private static void saveBooksToFile(List<Book> listBook) {
		String filePath = "D:\\J78_BaiTapCuoiKhoa\\book_data.txt";
		BufferedWriter buffW = null;
		FileWriter fwriter = null;
		try {
			fwriter = new FileWriter(filePath);
			buffW = new BufferedWriter(fwriter);
			for (Book book : listBook) {
				buffW.write(book.getCode() + ";" + book.getTitle() + ";" + book.getAuthor() + ";" 
						+ book.getCategory()+ ";" + book.getYear() + ";");
				buffW.newLine();
			}
			System.out.println("Dữ liệu đã được cập nhật vào tệp.");
		} catch (IOException e) {
			System.out.println("Lỗi khi lưu trữ dữ liệu vào tệp!");
		}finally {
			try {
				if(buffW != null) buffW.close();
			} catch (Exception e) {
				
			}
		}

	}
	
	private static void search(List<Book> listBook) {
		Search search = new Search();
		Scanner inputSearch = new Scanner(System.in);
		int choose ;
		do {
			printSearchMenu();
			System.out.println("\n Nhập lựa chọn tìm kiếm:");
			choose = inputSearch.nextInt();
			switch(choose) {
			case 1:
				search.searchByCode(listBook);
				break;
			case 2:
				search.searchByTitle(listBook);
				break;
			case 3:
				search.searchByAuthor(listBook);
				break;
			case 0:
				break;
			default:
				System.out.println("Nhập sai!");	
			}
		}while(choose != 0);
	}
	private static void printSearchMenu() {
		System.out.println("\n -------SEARCH------- ");
		System.out.println("1. Tìm theo mã sách");
		System.out.println("2. Tìm theo tựa sách");
		System.out.println("3. Tìm theo tên tác giả");
		System.out.println("0. Quay lại");
		
	}

	private static void updateBook(List<Book> listBook) {
		Scanner inputUpdate = new Scanner(System.in);
		
		System.out.print("Nhập mã code của sách cần sửa: ");
		String codeToUpdate = inputUpdate.next();
		
		boolean check = false;
				
		for (Book book : listBook) {
			if(book.getCode().equals(codeToUpdate)) {
				System.out.println("Nhập title mới: ");
				String updateTitle = inputUpdate.next();
				book.setTitle(updateTitle);
				
				System.out.println("Nhập author mới: ");
				String updateAuthor = inputUpdate.next();
				book.setTitle(updateAuthor);
				
				System.out.println("Nhập category mới: ");
				String updateCategory = inputUpdate.next();
				book.setTitle(updateCategory);
				
				System.out.println("Nhập year mới:");
				String updateYear = inputUpdate.next();
				book.setTitle(updateYear);
				
				saveBooksToFile(listBook);
				System.out.println("Cập nhật sách thành công");
				check = true;
				break;
			}
		}
		if(!check) {
			System.out.println("Không tìn thấy sách có mã code"+ codeToUpdate);
			
		}
	}
	private static void addBook(List<Book> listBook) {
		 Scanner inputToAdd = new Scanner(System.in);
		 System.out.println("Nhập mã code:");
		 String code = inputToAdd.nextLine(); 
		 boolean check = false;
		 for (Book book : listBook) {
				if(book.getCode().equals(code)) {
					System.out.println("Mã sách đã tồn tại!");
					check = true;
					break;
				}
		 }
		 if(!check) {
			 System.out.print("Nhập tên sách: ");
			 String title = inputToAdd.nextLine();
			    
			 System.out.print("Nhập tên tác giả: ");
			 String author = inputToAdd.nextLine();
			    
			 System.out.print("Nhập thể loại sách: ");
			 String category = inputToAdd.nextLine();
			    
			 System.out.print("Nhập năm xuất bản: ");
			 String year = inputToAdd.nextLine();
			  
			 Book newBook = new Book(title, author, category,year);
			 listBook.add(newBook);
			    
			 saveBooksToFile(listBook);
			 System.out.println("Thêm sách thành công!"); 
		 }
		 
		    
	}
	private static void removeBook(List<Book> listBook) {
		Scanner inputToRemove = new Scanner(System.in);
		 System.out.print("Nhập tên sách muốn xóa: ");
		 String titleToRemove = inputToRemove.nextLine();
	    
	    System.out.print("Nhập tên tác giả của sách muốn xóa: ");
	    String authorToRemove = inputToRemove.nextLine();
	    
	    System.out.print("Nhập thể loại sách muốn xóa: ");
	    String categoryToRemove = inputToRemove.nextLine();
	    
	    System.out.print("Nhập năm xuất bản sách muốn xóa: ");
	    String yearToRemove = inputToRemove.nextLine();
	    
	    //taọ lựa chọn cho sách có được tìm thấy và xóa
	    boolean removed = false;
	    Iterator<Book> iterator = listBook.iterator();
	    while (iterator.hasNext()) {
	        Book book = iterator.next();
	        // kiểm tra xem cuốn sách hiện tại có khớp với các chi tiết được hỉ định hay không
	       
	        if (book.getTitle().equalsIgnoreCase(titleToRemove) || 
	        		book.getAuthor().equalsIgnoreCase(authorToRemove) ||
	        		book.getCategory().equalsIgnoreCase(categoryToRemove) ||
	        		book.getYear().equalsIgnoreCase(yearToRemove)){
	        	iterator.remove(); 
	            removed = true; 
	        }   		
	    }
	    
	    if (removed) {
	    	saveBooksToFile(listBook);
	        System.out.println("Đã xóa sách thành công!");
	    } else {
	        System.out.println("Không tìm thấy sách phù hợp.");
	    }
		
	}

}

