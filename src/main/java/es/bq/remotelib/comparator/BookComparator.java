package es.bq.remotelib.comparator;

import java.util.Comparator;

import es.bq.remotelib.entity.Book;
import es.bq.remotelib.type.BookSortBy;

/**
 * 
 * @author Pablo Garcia
 */
public class BookComparator implements Comparator<Book> {

	private final BookSortBy m_orderType;

	public BookComparator(BookSortBy orderType) {
		m_orderType = orderType;
	}

	@Override
	public int compare(Book book1, Book book2) {
		switch (m_orderType) {
		case DATE:
			return (book1.getLastModified()).compareTo(book2.getLastModified());
		case TITLE:
			return (book1.getFileName()).compareTo(book2.getFileName());
		default:
			return 0;
		}
	}
}
