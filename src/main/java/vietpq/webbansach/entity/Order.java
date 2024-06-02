package vietpq.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;  // mã đơn hàng
    @Column(name = "date_created")
    private Date dateCreated; // ngày tạo đơn hàng
    @Column(name = "delivery_address")
    private String deliveryAddress; // địa chỉ giao hàng
    @Column(name = "phone_number")
    private String phoneNumber; // số điện thoại
    @Column(name = "full_name")
    private String fullName; // họ va tên khách hàng
    @Column(name = "total_price_product")
    private double totalPriceProduct; // tổng tiền sản phẩm
    @Column(name = "fee_delivery")
    private double feeDelivery; // phí giao hàng
    @Column(name = "fee_payment")
    private double feePayment; // phí thanh toán
    @Column(name = "total_price")
    private double totalPrice; // tổng tiền
    @Column(name = "status")
    private String status; // trạng thái đơn hàng
    @Column(name = "note")
    private String note; // ghi chú
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> listOrderDetails; // danh sách chi tiết đơn hangd
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_payment")
    private Payment  payment;// hình thức thanh toán
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_delivery")
    private Delivery delivery; // hình thức giao hàng
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

}
