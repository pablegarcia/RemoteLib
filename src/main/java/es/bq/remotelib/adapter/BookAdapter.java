package es.bq.remotelib.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import es.bq.remotelib.R;
import es.bq.remotelib.entity.Book;

/**
 * 
 * @author Pablo Garcia
 */
public class BookAdapter extends ArrayAdapter<Book> {

	private final Context m_context;

	private final List<Book> m_books;

	public BookAdapter(Context context, int textViewResourceId, List<Book> books) {
		super(context, textViewResourceId, books);

		m_context = context;
		m_books = books;
	}

	@Override
	public int getCount() {
		return m_books.size();
	}

	@Override
	public Book getItem(int position) {
		return m_books.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Create a new view into the list.
		LayoutInflater inflater = (LayoutInflater) m_context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.book, parent, false);

		// The book to initialize row data
		Book book = m_books.get(position);

		// Set book data into the view.
		TextView fileName = (TextView) rowView.findViewById(R.id.bookTitle);
		fileName.setText(book.getFileName());

		TextView bookDate = (TextView) rowView.findViewById(R.id.bookDate);
		bookDate.setText(book.getLastModified().toString());

		return rowView;
	}
}
