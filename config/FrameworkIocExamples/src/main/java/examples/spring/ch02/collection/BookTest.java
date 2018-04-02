package examples.spring.ch02.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {

	public static void main(String[] args) {
		ApplicationContext context
			= new ClassPathXmlApplicationContext("examples/spring/ch02/collection/book.xml");

		BookStore bookStore = (BookStore) context.getBean("bookStore");
		bookStore.printBookInfo();
	}
}
