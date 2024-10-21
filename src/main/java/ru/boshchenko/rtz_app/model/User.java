package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

//сделать почту также и логином ?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "user_name")
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(length = 30, name = "first_name")
    private String firstName;
    @Column(length = 40, name = "last_name")
    private String lastName;
    @Column(length = 40)
    private String patronymic;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(unique = true)
    private Long inn;

    @ManyToMany(mappedBy = "users")
    private Collection<Organization> organizations;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;


    public User(String userName, String password, String firstName, String lastName, String patronymic, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
    }
}
