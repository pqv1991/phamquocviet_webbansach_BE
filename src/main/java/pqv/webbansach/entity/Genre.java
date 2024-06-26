package pqv.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private int idGenre;
    @Column(name = "name_genre")
    private String nameGenre; // tên thể loại
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "id_genre"), inverseJoinColumns = @JoinColumn(name = "id_book"))
    private List<Book> listBooks; // danh sách quyển sách

}
