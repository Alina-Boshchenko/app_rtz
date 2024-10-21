package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "types_product")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40, nullable = false)
    private String name;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Product> products;

    public TypeProduct(String name) {
        this.name = name;
    }
}
