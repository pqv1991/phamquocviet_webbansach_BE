package pqv.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "password", length = 512)
    private String password;
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


}
