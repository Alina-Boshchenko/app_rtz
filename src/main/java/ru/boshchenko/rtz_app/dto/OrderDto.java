package ru.boshchenko.rtz_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    private Collection<Long> idProducts;

    private boolean needInvoice;

    private Integer amount;

    private Long userId;

}
