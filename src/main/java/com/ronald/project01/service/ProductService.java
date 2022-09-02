package com.ronald.project01.service;

import com.ronald.project01.payload.param.ProductConditionEnum;
import com.ronald.project01.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    List<Product> getProducts(Double requestPrice, ProductConditionEnum productConditionEnum);
}
