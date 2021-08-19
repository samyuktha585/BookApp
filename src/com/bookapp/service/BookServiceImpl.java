package com.bookapp.service;

import java.util.*;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {

	@Override
	public Book getBookById(int bookid) throws BookNotFoundException {
		List<Book> bookList=showBooks();
		boolean isPresent=false;
		
		for(Book book:bookList)
		{
			if(book.getBookId()==bookid)
			{
				isPresent=true;
				return book;
				
			}
		}
		if(!isPresent)
			throw new BookNotFoundException("Invalid Id");
		return null;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
			int flag = 0;
			List<Book> bookList = getAllBooks();
			List<Book> bookAuthor = new ArrayList<>();
			for (Book book : bookList) {
				if (author.equalsIgnoreCase(author)) {
					bookAuthor.add(book);
					flag = 1;
				}
			}
			if (flag == 0) {
				throw new BookNotFoundException("Books not found in the given author");
			}
			return bookAuthor;

		}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		int flag1 = 0;
		List<Book> bookList1 = getAllBooks();
		List<Book> bookCategory = new ArrayList<>();
		for (Book book : bookList1) {
			if (category.equalsIgnoreCase(category)) {
				bookCategory.add(book);
				flag1 = 1;
			}
		}
		if (flag1== 0) {
			throw new BookNotFoundException("Books not found in the given author");
		}
		return bookCategory;
		
	}

	@Override
	public List<Book> getAllBooks() {
		return showBooks();
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		int flag = 0;
		List<Book> bookList = getAllBooks();
		List<Book> bookPrice = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getPrice()>=price) {
				bookPrice.add(book);
				flag = 1;
			}
		}
		if (flag==0) {
			throw new BookNotFoundException("Books not found in the given price");
		}
		return bookPrice;
		
	}
	private List<Book> showBooks()
	{
		return Arrays.asList(
				new Book("Java in Action","Kathy","Tech",1990,1),
				new Book("sam club","Robin","self",400,2),
				new Book("Captain Robin Hook","Hall","Children",800,3),
				new Book("Pooh Tales","Kathy","Children",700,4),
				new Book("Leadership","Robin","self",1900,5),
				new Book("JEE","Kathy","Tech",1200,6));
		
	}

}
