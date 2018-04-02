package examples.spring.ch02.collection;

import java.util.List;
import java.util.Map;

public class BookStore {

	List bookList;

	public void setBookList(List bookList) {
		this.bookList = bookList;
	}

	public void printBookInfo() {
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println("==================");
			Map book = (Map) bookList.get(i);
			String title = (String) book.get("title");
			List authorList = (List) book.get("authorList");

			System.out.println(title);
			for (int k = 0; k < authorList.size(); k++) {
				String author = (String) authorList.get(k);
				System.out.println(author);
			}
			System.out.println("==================");
		}
	}
}
