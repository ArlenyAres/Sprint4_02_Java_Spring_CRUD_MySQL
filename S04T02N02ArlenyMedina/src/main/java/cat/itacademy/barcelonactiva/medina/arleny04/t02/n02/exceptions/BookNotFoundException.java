package cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.exceptions;

public class BookNotFoundException  extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
