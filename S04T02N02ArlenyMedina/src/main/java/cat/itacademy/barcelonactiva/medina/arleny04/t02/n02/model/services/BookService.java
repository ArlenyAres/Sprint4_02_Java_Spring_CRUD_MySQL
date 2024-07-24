package cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.services;


import cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.exceptions.BookNotFoundException;
import cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.domain.Book;
import cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRespository bookRespository;

    public List<Book>  getAllBooks() {
        return bookRespository.findAll();
    }

    public Book getBookById(long id) {
        return bookRespository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    public Book addBook(Book book) {
        return bookRespository.save(book);
    }

    public Book updateBook(long id, Book newBookData) {
        Book oldBookData = bookRespository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        oldBookData.setTitle(newBookData.getTitle());
        oldBookData.setAuthor(newBookData.getAuthor());
        return bookRespository.save(oldBookData);
    }

    public void deleteBook(long id) {
        if (!bookRespository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRespository.deleteById(id);
    }


}
