package com.bookapp.client;

import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImpl;



public class BookMain {

	public static void main(String[] args) throws BookNotFoundException {
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		int choice= sc.nextInt();
		BookService bookService = new BookServiceImpl();
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter book id");
			int id = sc.nextInt();
			try
			{
			
				
				System.out.println(bookService.getBookById(id));
			}
			catch(BookNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.println("Enter author name");
			String authorName = sc.next();
			try
			{
				System.out.println(bookService.getBooksByAuthor(authorName));
			}
			catch(BookNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println("Enter catagory name");
			String authorCatagory = sc.next();
			try
			{
				System.out.println(bookService.getBooksByCategory(authorCatagory));
			}
			catch(BookNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			System.out.println("Enter less price");
			int price = sc.nextInt();
			try
			{
				System.out.println(bookService.getBooksByLessPrice(price));
			}
			catch(BookNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			
				System.out.println(bookService.getAllBooks());
			
			break;
			
			
		}
		

	}

}
