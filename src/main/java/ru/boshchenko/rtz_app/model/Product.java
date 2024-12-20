package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Table(name = "products")
public class Product extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "rolled_id")
    private Rolled rolled;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeProduct type;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "standard_id")
    private Standard standard;

    @ManyToOne
    @JoinColumn(name = "steel_grade_id")
    private SteelGrade steelGrade;

    @Column(name = "size", length = 40)
    private String size;

    @Column(name = "length")
    private Double length;

    @Column(name = "thickness")
    private Double thickness;

    @Column(name = "weight")
    private Double weight;

    @Column(nullable = false, name = "price_per_meter")
    private BigDecimal pricePerMeter;

    @Column(nullable = false, name = "price_per_ton")
    private BigDecimal pricePerTon;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Collection<Order> orders;

}
