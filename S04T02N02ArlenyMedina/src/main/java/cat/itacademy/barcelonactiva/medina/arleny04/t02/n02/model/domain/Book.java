package cat.itacademy.barcelonactiva.medina.arleny04.t02.n02.model.domain;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table (name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private int year;




}
