package cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book, Long> {

}
