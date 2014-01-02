package es.bq.remotelib.entity;

import java.util.Date;

/**
 * This class represents the Book item in this application.
 * 
 * @author Pablo Garcia
 */
public class Book {

	/**
	 * The size, in bytes, of the file content.
	 */
	private long m_numBytes;

	/**
	 * The time the file was added, moved, or last had it's contents changed on
	 * the Dropbox server. (This probably won't match the time on the Dropbox
	 * user's filesystem.)
	 * 
	 */
	private Date m_lastModified;

	private int m_cover;

	private String m_title;

	private String m_fileName;

	public Book(String fileName, int cover, String title, long numBytes,
			Date lastModified) {
		m_fileName = fileName;
		m_cover = cover;
		m_title = title;
		m_numBytes = numBytes;
		m_lastModified = lastModified;
	}

	public String getFileName() {
		return m_fileName;
	}

	public void setFileName(String fileName) {
		m_fileName = fileName;
	}

	public int getCover() {
		return m_cover;
	}

	public void setCover(int cover) {
		m_cover = cover;
	}

	public String getTitle() {
		return m_title;
	}

	public void setTitle(String title) {
		m_title = title;
	}

	public long getNumBytes() {
		return m_numBytes;
	}

	public void setNumBytes(long numBytes) {
		m_numBytes = numBytes;
	}

	public Date getLastModified() {
		return m_lastModified;
	}

	public void setLastModified(Date lastModified) {
		m_lastModified = lastModified;
	}
}
