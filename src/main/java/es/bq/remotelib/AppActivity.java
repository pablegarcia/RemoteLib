package es.bq.remotelib;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.dropbox.core.DbxEntry;

import es.bq.remotelib.adapter.BookAdapter;
import es.bq.remotelib.entity.Book;
import es.bq.remotelib.services.DropboxManager;

/**
 * 
 * @author Pablo Garcia
 */
public class AppActivity extends Activity {

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
		setContentView(R.layout.login);
	}

	/**
	 * Called when the activity is becoming visible to the user.
	 */
	@Override
	public void onStart() {
		super.onStart();

		// Get the login button usind the ID
		Button loginButton = (Button) findViewById(R.id.loginButton);

		// Listening to the login button
		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showListOfBooks();
			}
		});
	}

	/**
	 * 
	 */
	private void showListOfBooks() {
		EditText emailEditText = (EditText) findViewById(R.id.emailTextbox);
		EditText passwordEditText = (EditText) findViewById(R.id.passwordTextbox);

		DropboxManager.authenticate(emailEditText.getText().toString(),
				passwordEditText.getText().toString());
		List<Book> books = convertToBooks(DropboxManager.getAllBooks());

		setContentView(R.layout.books_list);

		final ListView listview = (ListView) findViewById(R.id.booksListView);
		listview.setAdapter(new BookAdapter(this, books));
	}

	/**
	 * 
	 * @param dropboxBooks
	 * @return
	 */
	private List<Book> convertToBooks(List<DbxEntry> dropboxBooks) {
		List<Book> books = new ArrayList<Book>();
		for (DbxEntry book : dropboxBooks) {
			books.add(new Book(book.name, 1, book.name, book.asFile().numBytes,
					book.asFile().lastModified));
		}

		return books;
	}
}
