package ru.boshchenko.rtz_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private String rolledName;

    private String typeName;

    private String name;

    private String standardName;

    private String steelGradeName;

    private String size;

    private Double length;

    private Double thickness;

    private Double weight;

    private Double pricePerMeter;

    private Double pricePerTon;


}
