package vietpq.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private int idImage; // mã hình
    @Column(name = "name_image")
    private String nameImage; // tên hình
    @Column(name = "is_thumbnail")
    private boolean isThumbnail; // có phải là thumbnail không
    @Column(name = "url_image")
    private String urlImage; // đường dẫn hình;
    @Column(name = "data_image" , columnDefinition = "LONGTEXT")
    @Lob
    private String dataImage; // dữ liệu hình
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_book", nullable = false)
    private Book book; // hình của quyển sách nào;

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", nameImage='" + nameImage + '\'' +
                ", isThumbnail=" + isThumbnail +
                ", urlImage='" + urlImage + '\'' +
                ", dataImage='" + dataImage + '\'' +
                ", book=" + book +
                '}';
    }
}
