package org.java.spring;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.java.spring.auth.conf.AuthConf;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.serv.RoleService;
import org.java.spring.auth.db.serv.UserService;
import org.java.spring.db.pojo.Book;
import org.java.spring.db.pojo.Borrowing;
import org.java.spring.db.pojo.Category;
import org.java.spring.db.serv.BookService;
import org.java.spring.db.serv.BorrowingService;
import org.java.spring.db.serv.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BorrowingService borrowingService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Category cat1 = new Category("cat 1", "desc cat 1");
		Category cat2 = new Category("cat 2", "desc cat 2");
		Category cat3 = new Category("cat 3", "desc cat 3");
		
		categoryService.save(cat1);
		categoryService.save(cat2);
		categoryService.save(cat3);
		
		bookService.save(new Book("My Best Java Book 1 - Pluto", "Guybrush", "1234234212345673", cat1, cat2));
		bookService.save(new Book("My Best Java Book 2 - Pluto", "Guybrush", "1234234212345674", cat3));
		bookService.save(new Book("My Best Java Book 3", "Guybrush", "1234234212345675"));
		bookService.save(new Book("My Best Java Book 4 - Franco", "Franco", "1234234212345676", cat1, cat2, cat3));
		bookService.save(new Book("My Best Java Book 5 - Franco", "Carla", "1234234212345677", cat3));
		bookService.save(new Book("My Best Java Book 6 - Plutoasdfasdfasdfasdfasdfasdfsadfa", "Gianna", "1234234212345678", cat1));
		bookService.save(new Book("My Best Java Book 7 - Franco", "Guybrush", "1234234212345679", cat2, cat3));
		
		List<Book> books = bookService.findAll();
		
		borrowingService.save(new Borrowing("Guybrush", LocalDate.now().minusDays(9), books.get(0)));
		borrowingService.save(new Borrowing("Guybrush", LocalDate.now().minusDays(89), books.get(1)));
		borrowingService.save(new Borrowing("Guybrush", LocalDate.now().minusDays(32), books.get(2)));
		borrowingService.save(new Borrowing("Guybrush", LocalDate.now().minusDays(3), books.get(3)));
		borrowingService.save(new Borrowing("Guybrush", LocalDate.now().minusDays(5), books.get(4)));

		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		Role roleGod = new Role("GOD");
		
		roleService.save(roleUser);
		roleService.save(roleAdmin);
		roleService.save(roleGod);
		
		String pws = AuthConf.passwordEncoder().encode("pws");
		
		User guybrushUser = new User("guybrushUser", pws, roleUser);
		User guybrushAdmin = new User("guybrushAdmin", pws, roleAdmin);
		User guybrushGod = new User("guybrushGod", pws, roleGod);
		
		userService.save(guybrushUser);
		userService.save(guybrushAdmin);
		userService.save(guybrushGod);
		
//		extraLambda();
//		extraLambda2();
		
//		extraGenerics();
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
		int intValue = myMath.sum(10, 20).intValue();
		
		System.out.println(intValue);
		
		float floatValue = myMath.sum(30f, 40f).floatValue();
		System.out.println(floatValue);
		
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
		
		public <E extends Number> Number sum(E x, E y) {
			
			if (x instanceof Double || y instanceof Double) 
		        return x.doubleValue() + y.doubleValue();
		    if (x instanceof Float || y instanceof Float)
		        return x.floatValue() + y.floatValue();
		    if (x instanceof Long || y instanceof Long)
		        return x.longValue() + y.longValue();
			
			return x.intValue() + y.intValue();
		}
	}
}
