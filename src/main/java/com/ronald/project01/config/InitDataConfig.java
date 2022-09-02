package com.ronald.project01.config;

import com.ronald.project01.entity.Customer;
import com.ronald.project01.entity.Product;
import com.ronald.project01.repository.CustomerRepository;
import com.ronald.project01.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitDataConfig {

    @Bean
    CommandLineRunner initCustomerData (CustomerRepository customerRepository) {
        List<Customer> customers = new ArrayList<>();

        for (long i = 0; i < 6; i++) {
            long index = i + 1;
            Customer customer = Customer.builder()
                    .customerName("Nguyen kiet " + index)
                    .address("HCM " + index)
                    .customerId(index)
                    .phoneNo("090909 " + index)
                    .build();
            customers.add(customer);
        }

        return args -> {
            customerRepository.saveAll(customers);
        };
    }

    @Bean
    CommandLineRunner initProductData (ProductRepository productRepository) {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            int index = i + 1;
            Product product = Product.builder()
                    .productId((long) index)
                    .productName("San pham " + index)
                    .quantity(index + 10)
                    .price((double) index + 10.5)
                    .size("XL" + index)
                    .type("NEW")
                    .build();
            products.add(product);
        }

        return args -> {
            productRepository.saveAll(products);
        };
    }

}
