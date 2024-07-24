package cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.controllers;


import cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.exceptions.BookNotFoundException;
import cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.domain.Book;
import cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.services.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {

        try {
            List<Book> booksList = bookService.getAllBooks();
            if (booksList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(booksList);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {

        try {
            Book bookData = bookService.getBookById(id);
            return new  ResponseEntity<>(bookData, HttpStatus.OK);
        } catch (BookNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        try {
            Book bookObj = bookService.addBook(book);
            return new ResponseEntity<>(bookObj, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable long id, @RequestBody Book newBookData) {

        try {
            Book updatedBook = bookService.updateBook(id, newBookData);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (BookNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable long id) {

        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (BookNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
