package org.java;

public class Book {

	private String title;
	private int pageCount;
	private String author;
	private String editor;
	
	public Book(String title, int pageCount, String author, String editor) 
			throws Exception {
		
		setTitle(title);
		setPageCount(pageCount);
		setAuthor(author);
		setEditor(editor);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) throws Exception {
		
		title = title.trim();
		
		if (title == null || title.isEmpty() || title.length() <= 3)
			throw new Exception("Title can't be empty");
		
		this.title = title;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) throws Exception {
		
		if (pageCount <= 0) 
			throw new Exception("Page count can't be less then or equal to 0");
		
		this.pageCount = pageCount;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws Exception {
		
		author = author.trim();
		
		if (author == null || author.isEmpty() || author.length() <= 3)
			throw new Exception("Author can't be empty");
		
		this.author = author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) throws Exception {
		
		editor = editor.trim();
		
		if (editor == null || editor.isEmpty() || editor.length() <= 3)
			throw new Exception("Editor can't be empty");
		
		this.editor = editor;
	}
	
	@Override
	public String toString() {
		
		return getTitle() + " - " + getAuthor() + "\n"
				+ "editore : " + getEditor() + "\n"
				+ "numero pagine: " + getPageCount();
	}
}
