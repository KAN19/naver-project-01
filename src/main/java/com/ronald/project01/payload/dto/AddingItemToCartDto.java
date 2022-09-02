package com.ronald.project01.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddingItemToCartDto {
    @NotBlank
    private Long customerId;

    @NotBlank
    private List<ProductInCartDto> productList;
}
