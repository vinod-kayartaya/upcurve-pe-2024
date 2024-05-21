package com.targetindia.programs;


import com.targetindia.model.Book;

public class UsingBookObjects {
    public static void main(String[] args) {
        Book b1; // 8 bytes in the stack

        b1 = new Book();

        System.out.println(b1);
        System.out.println(args);

        b1.title = "Let us C, 19th edition";
        b1.pageCount = -123;

        System.out.println("b1.title is " + b1.title);
        System.out.println("b1.author is " + b1.author);
        System.out.println("b1.pageCount is " + b1.pageCount);
        System.out.println("b1.isbn is " + b1.isbn);
        System.out.println("b1.publishedBy is " + b1.publishedBy);



        b1 = null;
        System.out.println(b1);

    }
}
