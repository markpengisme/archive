/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

import java.util.*;

/**
 *
 * @author MarkPeng
 */
public class BookTest {
    
    
    public static void main(String[] args) {
        
        
        Book book = new Book();
        // Book1
        // Determine if there are three arguments
        // If true, make the book and show it
        if(args.length==3)
        {
            book.setBookName(args[0]);
            book.setBookCode(args[1]);
            book.setBookPrice(Double.parseDouble(args[2]));
            book.displayBook();
        }
        else
        {
            System.out.println("Arguments Error");
        }
        
        
        // Book2
        String bookName;
        String bookCode;
        double bookPrice;
        Scanner input = new Scanner(System.in);
        
        // Input
        System.out.println("Enter bookName:");
        bookName = input.next();
        book.setBookName(bookName);
        System.out.println("Enter bookCode:");
        bookCode = input.next();
        book.setBookCode(bookCode);
        System.out.println("Enter bookPrice:");
        bookPrice = input.nextDouble();
        book.setBookPrice(bookPrice);
        
        // Display
        book.displayBook();
    }
    
}
