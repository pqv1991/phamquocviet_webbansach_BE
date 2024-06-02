package pqv.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private int idPayment; // mã thanh toán
    @Column(name = "name_payment")
    private String namePayment; // tên thanh toán
    @Column(name = "description")
    private String description; // mô tả
    @Column(name = "fee_payment")
    private double feePayment; // chi phí thanh toán
    @OneToMany(mappedBy = "payment",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Order> listOrders; // danh sách đơn hàng
}
