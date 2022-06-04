/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

/**
 *
 * @author waMarkPenghaha
 */
public class Book {

    private String bookName;
    private String bookCode;
    private double bookPrice;


    /**
     *
     * @return book name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     *
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     *
     * @return book code
     */
    public String getBookCode() {
        return bookCode;
    }

    /**
     *
     * @param bookCode
     */
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    /**
     *
     * @return book price
     */
    public double getBookPrice() {
        return bookPrice;
    }

    /**
     *
     * @param bookPrice
     */
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    
    /**
     *  
     *  display book price, book name, book code 
     */
    public void displayBook() {
        System.out.printf("Book{bookPrice=%.2f,\tbookName=%s,\tbookCode=%s}\n",
                this.bookPrice,this.bookName,this.bookCode);
    }

}

