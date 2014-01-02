package es.bq.remotelib.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.core.DbxEntry;

import es.bq.remotelib.util.PropertyUtil;

/**
 * Class used to manage the authentication and transactions over a Dropbox user
 * account.
 * 
 * @author Pablo Garcia
 */
public class DropboxService {

	final static private String APP_KEY = PropertyUtil.getProperties()
			.getProperty("dropbox.appkey");

	final static private String APP_SECRET = PropertyUtil.getProperties()
			.getProperty("dropbox.appsecret");

	final static private AccessType ACCESS_TYPE = AccessType.DROPBOX;

	private DropboxAPI<AndroidAuthSession> m_DBApi;

	/**
	 * Gets the current Dropbox session.
	 * 
	 * @return
	 */
	public AndroidAuthSession getDropboxSession() {
		return m_DBApi.getSession();
	}

	/**
	 * Builds a new Auth. session into Dropbox for this application.
	 */
	public void buildDropboxSession() {
		// Pass all three values to the new DropboxAPI object
		AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		AndroidAuthSession session = new AndroidAuthSession(appKeys,
				ACCESS_TYPE);
		m_DBApi = new DropboxAPI<AndroidAuthSession>(session);
	}

	/**
	 * Obtains the list of epub files contained in the dropbox file system.
	 * 
	 * @return The list of books.
	 */
	public static List<DbxEntry> getAllBooks() {
		List<DbxEntry> books = new ArrayList<DbxEntry>();

		books.add(new DbxEntry.File("/book4.epub", "", true, 1000000, "13 kb",
				new Date(100000), null, ""));
		books.add(new DbxEntry.File("/book2.epub", "", true, 1000000, "13 kb",
				new Date(200000), null, ""));
		books.add(new DbxEntry.File("/book3.epub", "", true, 1000000, "13 kb",
				new Date(300000), null, ""));
		books.add(new DbxEntry.File("/book1.epub", "", true, 1000000, "13 kb",
				new Date(2000000), null, ""));
		books.add(new DbxEntry.File("/book5.epub", "", true, 1000000, "13 kb",
				new Date(1200000), null, ""));
		books.add(new DbxEntry.File("/book6.epub", "", true, 1000000, "13 kb",
				new Date(24000), null, ""));
		books.add(new DbxEntry.File("/book7.epub", "", true, 1000000, "13 kb",
				new Date(100000000), null, ""));
		books.add(new DbxEntry.File("/book8.epub", "", true, 1000000, "13 kb",
				new Date(62555000), null, ""));

		return books;
	}
}
