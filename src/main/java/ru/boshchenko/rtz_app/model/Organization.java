package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizations")
public class Organization extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(length = 100, name = "legal_address")
    private String legalAddress;

    @Column(name = "ogrn")
    private Long ogrn;

    @Column(name = "inn", unique = true, nullable = false)
    private Long inn;

    @Column(name = "kpp")
    private Long kpp;

    @Column(name = "bic_bank")
    private Long BICBank;

    @Column(name = "bank_names")
    private String bankNames;

    @Column(name = "payment_account")
    private Long paymentAccount;

    @ManyToMany(fetch = FetchType.EAGER)
    // по умолчанию буде fetch = FetchType.LAZY (при загрузке род.сущ., дочерняя сущность загружена не будет, вмето неё создается proxy-объект),
    // а не EAGER (все доч.сущ. будут загружены при загрузке род.сущ.)
    @JoinTable(
            name = "users_organizations",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<User> users;

}
