package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;


// "companies"
//Company

@Entity
@Data
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 60, name = "legal_address")
    private String legalAddress;
    @Column
    private Long ogrn;

    @Column(unique = true, nullable = false)
    private Long inn;
    @Column
    private Long kpp;
    @Column(name = "bic_bank")
    private Long BICBank;
    @Column(name = "bank_names")
    private String bankNames;
    @Column(name = "payment_account")
    private Long paymentAccount;

    @ManyToMany // по умолчанию буде fetch = FetchType.LAZY (при загрузке род.сущ., дочерняя сущность загружена не будет, вмето неё создается proxy-объект),
    // а не EAGER (все доч.сущ. будут загружены при загрузке род.сущ.)
    @JoinTable(
            name = "users_organizations",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<User> users;




}
