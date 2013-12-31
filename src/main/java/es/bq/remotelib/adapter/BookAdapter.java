package es.bq.remotelib.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import es.bq.remotelib.R;
import es.bq.remotelib.entity.Book;

/**
 * 
 * @author Pablo Garcia
 */
public class BookAdapter extends BaseAdapter {

	private final Context m_context;

	private final List<Book> m_books;

	public BookAdapter(Context context, List<Book> books) {
		m_context = context;
		m_books = books;
	}

	@Override
	public int getCount() {
		return m_books.size();
	}

	@Override
	public Object getItem(int position) {
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

		// Set data into the view.
		// ImageView bookCover = (ImageView)
		// rowView.findViewById(R.id.bookCover);
		TextView bookTitle = (TextView) rowView.findViewById(R.id.bookTitle);

		Book book = m_books.get(position);
		bookTitle.setText(book.getTitle());
		// bookCover.setImageResource(book.getCover());

		return rowView;
	}
}
