package org.example;

public class LibraryTest {


    public static void main(String[] args) {
        Book testBook1 = new Book();
        Book testBook2 = new Book();
        Book testBook3 = new Book();

        Library library1 = new Library("CityLibrary");

        testBook1.setName(" test1 ");
        testBook1.setISBN(" 1029312903 ");
        testBook2.setName(" test2 ");
        testBook2.setISBN(" 123129302 ");
        testBook3.setName(" test3 ");
        testBook3.setISBN(" 4343443 ");

        testBook1.setAuthor("NameOfAuthorTEST1 ");
        testBook2.setAuthor("NameOfAuthorTEST2 ");
        testBook3.setAuthor("NameOfAuthorTEST3 ");

        testBook1.setAvailable(true);
        testBook2.setAvailable(true);
        testBook3.setAvailable(true);


        System.out.println("\n====================TESTS====================");
        // add books
        library1.addBook(testBook1);

        library1.addBook(testBook2);

        library1.addBook(testBook3);

        // add a book thats already in library
        library1.addBook(testBook1);

        // check out a book from lbirary
        library1.checkOutBook(testBook1.getISBN());

        // try to check out the same book again
        library1.checkOutBook(testBook1.getISBN());

        // return a book
        library1.returnBook(testBook1.getISBN());

        // search by author
        System.out.println("\nsearching by author that exist: \n" + "Searching for " + testBook3.getAuthor() + library1.searchBookByAuthor(testBook3.getAuthor()));
        System.out.println("\nsearching by author that does not exist: \n" + "Searching for testestest" + library1.searchBookByAuthor("testestest"));


        // search by name

        System.out.println("\nsearching by author that exist: \n" + "Searching for " + testBook3.getName() + library1.searchBookByTitle(testBook3.getName()));
        System.out.println("\nsearching by author that does not exist: \n" + "Searching for namenamename" + library1.searchBookByTitle("namenamename"));

        System.out.println("\n====================END OF TESTS====================");
    }
}
