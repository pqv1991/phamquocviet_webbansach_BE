package vietpq.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.element.NestingKind;
import java.sql.Date;
import java.util.List;
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser; // id user
    @Column(name = "first_name")
    private String firstName; // họ đệm
    @Column(name = "last_name")
    private String lastName; // tên
    @Column(name = "username")
    private String username; // tên tk;
    @Column(name = "password", length = 512)
    private String password; // mật khẩu;
    @Column(name = "gender")
    private char gender; // giới tính;
    @Column(name = "date_of_birth")
    private Date dateOfBirth; // ngày sinh;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber; // số điện thoại
    @Column(name = "delivery_address")
    private String deliveryAddress; // địa chỉ giao hàng
    @Column(name = "avatar")
    private String avatar; // ảnh đạo diện
    @Column(name = "enable")
    private Boolean enabled; // trạng thái kích hoạt
    @Column(name = "activation_code")
    private String activationCode; // mã kích hoạt
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Review> listReviews; //Danh sách đánh giá của người dùng
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FavoriteBook> listFavoriteBooks; // Danh sách những quyển sách yêu thích của người dùng
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<Role> listRoles; //Danh sách quyền của người dùng
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Order> listOrders; // danh sách đơn hàng của người dùng
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CartItem> listCartItems; // danh sách giỏ hàng
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Feedbacks> listFeedbacks; // danh sách đánh giá của người dùng

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", avatar='" + avatar + '\'' +
                ", enabled=" + enabled +
                ", activationCode='" + activationCode + '\'' +
                ", listReviews=" + listReviews +
                ", listFavoriteBooks=" + listFavoriteBooks +
                ", listRoles=" + listRoles +
                ", listOrders=" + listOrders +
                ", listCartItems=" + listCartItems +
                ", listFeedbacks=" + listFeedbacks +
                '}';
    }
}
