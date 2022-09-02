package com.ronald.project01.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

//    @Column(columnDefinition = "varchar(100)")
    private String productName;

//    @Column(columnDefinition = "char(3)")
    private String type;
    private String size;
//    @Column(columnDefinition = "numeric(20,2)")
    private Double price;
    private Integer quantity;
}
