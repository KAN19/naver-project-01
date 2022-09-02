package com.ronald.project01.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInCartDto {

    private Long productId;
    private Integer quantity;

}
