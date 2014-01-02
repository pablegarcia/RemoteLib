package es.bq.remotelib;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.core.DbxEntry;

import es.bq.remotelib.adapter.BookAdapter;
import es.bq.remotelib.comparator.BookComparator;
import es.bq.remotelib.entity.Book;
import es.bq.remotelib.services.DropboxService;
import es.bq.remotelib.type.BookSortBy;

/**
 * Application Entry point class.
 * 
 * @author Pablo Garcia
 */
public class AppActivity extends Activity {

	private ListView m_listview;

	private DropboxService m_dropboxService;

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Dropbox user authentication
		authenticateToDropbox();

		setContentView(R.layout.books_list);
	}

	/**
	 * Called when the activity is becoming visible to the user.
	 */
	@Override
	public void onStart() {
		super.onStart();

		addListenerOnListViewItemClick();
		addListenerOnSpinnerItemSelection();
	}

	@Override
	public void onResume() {
		super.onResume();

		AndroidAuthSession dropboxSession = m_dropboxService
				.getDropboxSession();

		if (dropboxSession.authenticationSuccessful()) {
			try {
				// Required to complete auth, sets the access token on the
				// session
				dropboxSession.finishAuthentication();

				Log.i("Login", "App. logged succesfully to Dropbox");
			} catch (IllegalStateException e) {
				Log.e("DbAuthLog", "Error authenticating", e);
			}
		}
	}

	/**
	 * 
	 */
	private void authenticateToDropbox() {
		m_dropboxService = new DropboxService();
		m_dropboxService.buildDropboxSession();
		AndroidAuthSession dropboxSession = m_dropboxService
				.getDropboxSession();
		dropboxSession.startAuthentication(AppActivity.this);
	}

	/**
	 * 
	 */
	private void addListenerOnListViewItemClick() {
		// Convert the list of DropBox Books into app. Books
		List<Book> books = convertToBooks(DropboxService.getAllBooks());

		m_listview = (ListView) findViewById(R.id.booksListView);
		m_listview.setAdapter(new BookAdapter(this, R.layout.book, books));

		// Listening to the books on click
		m_listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long arg) {
				// Show the books cover when the book has been clicked
				ImageView cover = (ImageView) view.findViewById(R.id.bookCover);

				// Change cover visibility
				int newVisibility = cover.getVisibility() == View.VISIBLE ? View.INVISIBLE
						: View.VISIBLE;
				cover.setVisibility(newVisibility);
			}
		});
	}

	/**
	 * 
	 */
	private void addListenerOnSpinnerItemSelection() {
		final Spinner spinner = (Spinner) findViewById(R.id.sortBySpinner);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			protected Adapter initializedAdapter = null;

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long arg) {
				// Always ignore the initial selection performed after
				// setAdapter
				if (initializedAdapter != parent.getAdapter()) {
					initializedAdapter = parent.getAdapter();
					return;
				}

				BookAdapter adapter = (BookAdapter) m_listview.getAdapter();

				switch (position) {
				case 0:
					adapter.sort(new BookComparator(BookSortBy.TITLE));
					break;
				case 1:
					adapter.sort(new BookComparator(BookSortBy.DATE));
					break;
				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
		});
	}

	/**
	 * 
	 * @param dropboxBooks
	 * @return
	 */
	private List<Book> convertToBooks(List<DbxEntry> dropboxBooks) {
		List<Book> books = new ArrayList<Book>();
		for (DbxEntry book : dropboxBooks) {
			books.add(new Book(book.name, 1, "", book.asFile().numBytes, book
					.asFile().lastModified));
		}

		return books;
	}
}
