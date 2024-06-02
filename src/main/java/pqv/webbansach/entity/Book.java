package pqv.webbansach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;
    @Column(name = "name_book")
    private String nameBook;
    @Column(name = "author")
    private String author;
    @Column (name = "description", columnDefinition = "LONGTEXT")
    private String description;
    @Column(name = "list_price")
    private double listPrice; // giá niêm yết
    @Column(name = "sell_price")
    private double sellPrice; // giá bán
    @Column(name = "quantity")
    private  int quantity; // số lượng
    @Column(name = "avg_rating")
    private double avgRating; // trung bình xếp hạng
    @Column(name = "sold_quantity")
    private  int soldQuantity; // số lượng bán
    @Column(name = "discount_percent")
    private  int discountPercent;
    @ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "id_book"),inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private List<Genre> listGenres; // danh sách thể loại
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> listImages; // danh sách hình ảnh
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> listReviews; // danh sách đánh giá
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<OrderDetail> listOrderDetails; // danh sách chi tiết đơn ahngf
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private List<FavoriteBook> listFavoriteBooks; // danh sách sách yêu thích
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CartItem> listCartItems; // danh sách giỏ hàng


}
