package pqv.webbansach.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int idRole; // mã quyền
    @Column(name = "name_role")
    private String nameRole; // tên quyền
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "id_role"),inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> listUsers; // Danh sách người dùng;

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", nameRole='" + nameRole + '\'' +
                ", listUsers=" + listUsers +
                '}';
    }
}
