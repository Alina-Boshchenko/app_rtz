package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "steel_grades")
public class SteelGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40, nullable = false)
    private String name;
    @OneToMany(mappedBy = "steelGrade", cascade = CascadeType.ALL)
    private List<Product> products;

    public SteelGrade(String name) {
        this.name = name;
    }
}
