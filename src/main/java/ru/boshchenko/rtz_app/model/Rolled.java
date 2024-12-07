package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Table(name = "rolleds")
public class Rolled extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @OneToMany(mappedBy = "rolled", cascade = CascadeType.ALL)
    private List<Product> products;

}
