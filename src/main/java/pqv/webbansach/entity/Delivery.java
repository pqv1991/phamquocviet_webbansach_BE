package pqv.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery")
    private int idDelivery;
    @Column(name = "name_delivery")
    private String nameDelivery;
    @Column(name = "description")
    private String description;// mô tả
    @Column(name = "fee_delivery")
    private double feeDelivery; // chi phí giao hàng
    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Order> listOrders; // danh sách đơn hàng

}
