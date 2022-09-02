package com.ronald.project01.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(columnDefinition = "varchar(50)")
    private String customerName;
    private String address;
    private String phoneNo;

    @OneToOne
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
    private Cart cart;
}
