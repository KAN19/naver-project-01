package com.ronald.project01.payload.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedCartItemDto {

    private String productName;
    private Integer quantityWished;
    private Double totalAmount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateAdded;

}
