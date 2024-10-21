package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rolled_id")
    private Rolled rolled;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeProduct type;


    @Column(length = 40, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "standard_id")
    private Standard standard;

    @ManyToOne
    @JoinColumn(name = "steelGrade_id")
    private SteelGrade steelGrade;

    @Column(length = 40)
    private String size;

    @Column
    private Double length;
    @Column
    private Double thickness;
    @Column
    private Double weight;
    @Column(nullable = false, name = "price_per_meter")
    private Double pricePerMeter;
    @Column(nullable = false, name = "price_per_ton")
    private Double pricePerTon;

    public Product(Rolled rolled, TypeProduct type, String name, Standard standard, SteelGrade steelGrade, String size, Double length, Double thickness, Double weight, Double pricePerMeter, Double pricePerTon) {
        this.rolled = rolled;
        this.type = type;
        this.name = name;
        this.standard = standard;
        this.steelGrade = steelGrade;
        this.size = size;
        this.length = length;
        this.thickness = thickness;
        this.weight = weight;
        this.pricePerMeter = pricePerMeter;
        this.pricePerTon = pricePerTon;
    }
}
