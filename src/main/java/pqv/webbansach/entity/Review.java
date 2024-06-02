package pqv.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private int idReview; // mã đánh giá
    @Column(name = "content")
    private String content; // nội dung đánh giá
    @Column(name = "rating_point")
    private double ratingPoint; // điểm xếp hạng
    @Column(name = "timestamp")
    private Timestamp timestamp; // thời gian đánh giá
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_book", nullable = false)
    private Book book; // đánh giá quyển sách nào
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_user",nullable = false)
    private User user; // người dùng đánh giá
    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_order_detail")
    private OrderDetail orderDetail; // của đơn hàng nào

}
