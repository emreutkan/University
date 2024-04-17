
package org.example;

/**
 * The Book class represents a book
 */
public class Book {

    /** The name of the book. */
    private String name;

    /** The author of the book. */
    private String author;

    /** The International Standard Book Number (ISBN) of the book. */
    private String ISBN;

    /** Indicates whether the book is currently available in the library. */
    private Boolean isAvailable;

    /**
     * Gets the name of the book.
     *
     * @return The name of the book.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the book.
     *
     * @param name The new name for the book.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author for the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param ISBN The new ISBN for the book.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Checks if the book is available in the library.
     *
     * @return True if the book is available, false otherwise.
     */
    public Boolean getAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param available True if the book is available, false otherwise.
     */
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
