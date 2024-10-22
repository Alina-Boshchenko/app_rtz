package ru.boshchenko.rtz_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

/**
 * @Data это удобная сокращенная аннотация, которая объединяет функции @ToString,
 * @EqualsAndHashCode, @Getter / @Setter и @RequiredArgsConstructor вместе
 * */
@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rolleds")
public class Rolled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String name;

    @OneToMany(mappedBy = "rolled", cascade = CascadeType.ALL)
    private List<Product> products;

    public Rolled(String name) {
        this.name = name;
    }
}
