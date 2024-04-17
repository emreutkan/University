package org.example;

import java.util.Scanner;

public class LibraryMenu {
    public static void main(String[] args) {
        Library library = new Library("Library");
        while (true){
            Book book = new Book();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Library Management system Menu:\n" +
                    "1. add a book\n" +
                    "2. Display avaliable books\n" +
                    "3. check out a book\n" +
                    "4. return a book\n" +
                    "5. exit\n");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("enter title of the book");
                    String name = scanner.next();
                    book.setName(name);

                    System.out.println("enter author of the book");
                    String author = scanner.next();
                    book.setAuthor(author);

                    System.out.println("enter ISBN of the book");
                    String ISBN = scanner.next();
                    book.setISBN(ISBN);

                    library.addBook(book);

                    break;
                case 2:
                    library.getAvailableBooks();
                    break;
                case 3:
                    System.out.println("To check out a book:\n" +
                            "enter ISBN of the book");
                    String isbn = scanner.next();
                    book.setISBN(isbn);
                    library.checkOutBook(book.getISBN());
                    break;
                case 4:
                    System.out.println("To return a book:\n" +
                            "enter ISBN of the book");
                    String issbn = scanner.next();
                    book.setISBN(issbn);
                    library.returnBook(book.getISBN());
                    break;
                case 5:
                    return;
            }
        }
    }
}
