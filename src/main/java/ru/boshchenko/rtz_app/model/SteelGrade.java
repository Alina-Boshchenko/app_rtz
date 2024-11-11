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
public class SteelGrade extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @OneToMany(mappedBy = "steelGrade", cascade = CascadeType.ALL)
    private List<Product> products;

}
