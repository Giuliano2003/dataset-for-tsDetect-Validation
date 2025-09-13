
package com.sessions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LibraryTest {

    Library library;
    @BeforeEach
    public void object_setup(){
        library = new Library();
        System.out.println("At BeforeEach Method");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("AfterEach Method");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All Testcases have started");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After all testcases have completed.");
    }



    @Test
    public void adding_to_catalogue_should_increase_books_size_and_newly_created_book_id_should_be_2(){ //addToCatalogue() method test
        Book newlyCreatedBook = library.addToCatalogue("Gulliver's Travels","Jonathan Swift",300,15.95);

        int totalBooks = library.getBooks().size();
        List<Book> availableBooks = library.getBooks();

        assertEquals(2, newlyCreatedBook.getId()); //Ensuring new book ID is 2
        assertThat(totalBooks, equalTo(2)); // Ensuring total number of books are 2
        assertThat(availableBooks,hasItem(newlyCreatedBook)); // Ensuring that the catalogue list has newly added book.
    }


    @Test
    public void when_returning_book_receipt_should_be_returned(){
        RentedBook rentedBook = library.rent("The God Of Small Things");
        Double amount = 5.0;
        Receipt bookReceipt = library.returnBook(rentedBook, amount);
        assertNotNull(bookReceipt);
        assertThat(bookReceipt.bookName, equalTo("The God Of Small Things"));
        assertThat(bookReceipt.receiptDate, equalTo(LocalDate.now()));
        assertThat(bookReceipt.amountGiven, equalTo(amount));
    }


}
