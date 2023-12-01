package org.java.spring;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.db.pojo.Book;
import org.java.spring.db.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		bookService.save(new Book("My Best Java Book 1 - Pluto", "Guybrush", "123423423"));
		bookService.save(new Book("My Best Java Book 2 - Pluto", "Guybrush", "123423424"));
		bookService.save(new Book("My Best Java Book 3", "Guybrush", "123423425"));
		bookService.save(new Book("My Best Java Book 4 - Franco", "Franco", "123423426"));
		bookService.save(new Book("My Best Java Book 5 - Franco", "Carla", "123423427"));
		bookService.save(new Book("My Best Java Book 6 - Plutoasdfasdfasdfasdfasdfasdfsadfa", "Gianna", "123423428"));
		bookService.save(new Book("My Best Java Book 7 - Franco", "Guybrush", "123423429"));
		
//		extraLambda();
//		extraLambda2();
		
		extraGenerics();
	}
	
	@FunctionalInterface
	public static interface MyFuncInteface {
		
		int op(int x, int y);
	}
	
	// LAMBDA FUNCTION
	public void extraLambda() {
		
//		x -> x.getValue()
//		Integer::getValue
		
		MyFuncInteface mfiSum = (x, y) -> x + y;
		MyFuncInteface mfiMul = (x, y) -> x * y;
		
		int x = 10;
		int y = 20;
		
		int sum = execMathOp(x, y, mfiSum);
		int mul = execMathOp(x, y, mfiMul);
		
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("sum: " + sum);
		System.out.println("mul: " + mul);
	}
	public int execMathOp(int x, int y, MyFuncInteface mfi) {
		
		return mfi.op(x, y);
	}
	public void extraLambda2() {
		
		List<Book> books = bookService.findAll();
		
//		// VERSIONE 1: BAD
//		String str = "";
//		for (Book b : books) 
//			str += b.getTitle() + ", ";
//		
//		System.out.println(str.substring(0, str.length() - 2));
		
//		String str = "";
//		for (int x=0;x<books.size();x++) {
//			
//			Book b = books.get(x);
//			
//			str += b.getTitle();
//			
//			if (x < books.size() - 1)
//				str += ", ";
//		}
//		
//		System.out.println(str);
		
//		System.out.println(books.stream().map(Book::getTitle)
//				 .collect(Collectors.joining(", ")));
		
//		boolean allBooksHasTitle = true;
//		for(Book b : books) 
//			if (b.getTitle() == null || b.getTitle().isEmpty()) {
//				
//				allBooksHasTitle = false;
//				break;
//			}
//		
//		System.out.println("All books has title: " 
//				+ (allBooksHasTitle ? "YES" : "NO"));
		
//		System.out.println(
//			"All books has title: " 
//				+ (books.stream()
//							.allMatch(b -> b.getTitle() != null 
//											|| !b.getTitle().isEmpty()
//								) 
//						? "YES" 
//						: "NO"
//					)
//		);
		
//		List<Book> guybrushBooks = new ArrayList<>();
//		for (Book b : books) 
//			if (b.getAuthor().toLowerCase().equals("guybrush"))
//				guybrushBooks.add(b);
//		
//		System.out.println(guybrushBooks);
		
//		System.out.println(books.stream()
//					.filter(b 
//						-> b.getAuthor()
//							.toLowerCase()
//							.equals("guybrush"))
//					.toList()
//		);
		
//		books.stream().forEach(System.out::println);
//		for (Book b : books)
//			System.out.println(b);
		
//		int titleCharCount = 0;
//		for (Book b : books) 
//			titleCharCount += b.getTitle().length();
//		
//		System.out.println("Title char count: " + titleCharCount);
		
//		System.out.println("Title char count: " + books.stream()
//				.map(b -> b.getTitle().length())
//				.reduce(0, (acc, val) -> acc + val)
//		);
		
//		System.out.println("Title char count: " + books.stream()
//			.map(b -> b.getTitle())
//			.reduce("", (acc, val) -> acc + " - " + val)
//		);
		
//		System.out.println("Ordered books: " + books.stream().sorted(
//				(b1, b2) -> b2.getTitle().length() - b1.getTitle().length())
//				.toList()
//		);
		
		
	}

	// GENERICS
	public void extraGenerics() {
		
		MyMath myMath = new MyMath();
		int value = myMath.sum(10f, 10);
		
		System.out.println(value);
		
		value = myMath.sum(30f, 40f);
		System.out.println(value);
		
//		MyMath<String> stringMath = new MyMath<>();
	}
	public static class MyMath {
		
//		public static int sum(int x, int y) {
//			
//			return x + y;
//		}
//		public static float sum(float x, float y) {
//			
//			return x + y;
//		}
//		public static double sum(double x, double y) {
//			
//			return x + y;
//		}
//		public static long sum(long x, long y) {
//			
//			return x + y;
//		}
		
		public <E extends Number> int sum(E x, E y) {
			
			return x.intValue() + y.intValue();
		}
	}
}
