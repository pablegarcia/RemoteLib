package es.bq.remotelib.util;

import java.util.ArrayList;
import java.util.List;

import com.dropbox.core.DbxEntry;

import es.bq.remotelib.entity.Book;

/**
 * This class represents the Converter utility. It should be used to convert
 * from a custom object to another class object.
 * 
 * @author Pablo Garcia
 */
public class ConvertUtil {

	/**
	 * Converts a list of DropBox books (DbxEntry) into a list of app. Books.
	 * 
	 * @param dropboxBooks
	 * @return The converted List of Books
	 */
	public static List<Book> convertToBooks(List<DbxEntry> dropboxBooks) {
		List<Book> books = new ArrayList<Book>();
		for (DbxEntry book : dropboxBooks) {
			books.add(new Book(book.name, 1, "", book.asFile().numBytes, book
					.asFile().lastModified));
		}

		return books;
	}
}
