package es.bq.remotelib.services;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;

/**
 * 
 * @author Pablo Garcia
 */
public class DropboxManager {

	/**
	 * Checks user credentials
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws DbxException
	 */
	public static void authenticate(String login, String password) {
		// Initialize the Dropbox client mock
		// m_clientMock = Mockito.mock(DbxClient.class);
		//
		// List<DbxEntry> entries = new ArrayList<DbxEntry>();
		//
		// WithChildren childrenMock = Mockito.mock(WithChildren.class);
		// Mockito.when(childrenMock.children).thenReturn(entries);
		// Mockito.when(m_clientMock.getMetadataWithChildren("/")).thenReturn(
		// childrenMock);

		Log.i("Login", "Login " + login + " to dropbox.");
	}

	public static List<DbxEntry> getAllBooks() {
		List<DbxEntry> books = new ArrayList<DbxEntry>();

		books.add(new DbxEntry.File("/book1.epub", "", false, 1000000, "13 kb",
				null, null, ""));
		books.add(new DbxEntry.File("/book2.epub", "", false, 1000000, "13 kb",
				null, null, ""));
		books.add(new DbxEntry.File("/book3.epub", "", false, 1000000, "13 kb",
				null, null, ""));
		books.add(new DbxEntry.File("/book4.epub", "", false, 1000000, "13 kb",
				null, null, ""));
		books.add(new DbxEntry.File("/book5.epub", "", false, 1000000, "13 kb",
				null, null, ""));
		books.add(new DbxEntry.File("/book6.epub", "", false, 1000000, "13 kb",
				null, null, ""));
		books.add(new DbxEntry.File("/book7.epub", "", false, 1000000, "13 kb",
				null, null, ""));
		books.add(new DbxEntry.File("/book8.epub", "", false, 1000000, "13 kb",
				null, null, ""));

		return books;
	}
}
