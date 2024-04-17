/**
 * The org.example package contains classes related to library management.
 */
package org.example;

import java.util.ArrayList;

/**
 * The Library class represents a library and provides methods for managing books.
 */
public class Library extends Book {

    private Book book;
    /** The name of the library. */
    private String libraryName;

    /** List of books currently in the library. */
    private ArrayList<Book> booksInLibrary = new ArrayList<>();

    /** List of books that have been borrowed from the library. */
    private ArrayList<Book> booksBorrowed = new ArrayList<>();

    /**
     * Constructs a Library object with the specified library name.
     *
     * @param libraryName The name of the library.
     */
    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    /**
     * Gets the name of the library.
     *
     * @return The name of the library.
     */
    public String getLibraryName() {
        return libraryName;
    }

    /**
     * Sets the name of the library.
     *
     * @param libraryName The new name for the library.
     */
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    /**
     * Adds a book to the library if it is not already present.
     *
     * @param book The book to be added to the library.
     * @throws IllegalArgumentException .
     */
    public void addBook(Book book){
        try{
            for (int i = 0; i < booksInLibrary.size(); i++) {
                this.book = booksInLibrary.get(i);
                if (this.book.getISBN().equals(book.getISBN())){
                    System.out.println("This book " + book.getName() + " is already in the library");
                    return;
                }
            }
            booksInLibrary.add(book);
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

    /**
     * Searches for a book in the library by its title.
     *
     * @param title The author of the book to be searched.
     * @return A string indicating whether the book is in the library or not.
     */
    public String searchBookByTitle(String title){
        for (int i = 0; i < booksInLibrary.size(); i++) {
            this.book = booksInLibrary.get(i);
            if (this.book.getName().equals(title)){
                return "This book " + book.getName() + " is in the library";
            }
        }
        return " This book is not in the library";
    }

    /**
     * Searches for a book in the library by its author.
     *
     * @param author The author of the book to be searched.
     * @return A string indicating whether the book is in the library or not.
     */
    public String searchBookByAuthor(String author){
        for (int i = 0; i < booksInLibrary.size(); i++) {
            this.book = booksInLibrary.get(i);
            if (this.book.getAuthor().equals(author)){
                return " This book " + book.getName() + " is in the library";
            }
        }
        return " This book is not in the library";
    }

    /**
     * Checks out a book from the library.
     *
     * @param isbn The isbn of the book to be checked out.
     */
    public void checkOutBook(String isbn){
        for (int i = 0; i < booksInLibrary.size(); i++) {
            this.book = booksInLibrary.get(i);
            if (this.book.getISBN().equals(isbn)){
                booksBorrowed.add(book);
                booksInLibrary.remove(book);
                System.out.println(book.getName() + " is borrowed");
            }
        }
    }

    /**
     * lists available books.
     *
     */
    public void getAvailableBooks(){
        System.out.println("Available Books");
        for (int i = 0; i < booksInLibrary.size(); i++) {
            this.book = booksInLibrary.get(i);
            System.out.println(this.book.getName());

        }
    }

    /**
     * Returns a borrowed book to the library.
     *
     * @param isbn The isbn book to be returned.
     */
    public void returnBook(String isbn){
        for (int i = 0; i < booksBorrowed.size(); i++) {
            this.book = booksBorrowed.get(i);
            if (this.book.getISBN().equals(isbn)){
                booksInLibrary.add(book);
                booksBorrowed.remove(book);
                System.out.println(book.getName() + " is returned");
                return;
            }
        }
    }
}
