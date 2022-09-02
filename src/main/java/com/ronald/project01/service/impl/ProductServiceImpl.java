package com.ronald.project01.service.impl;

import com.ronald.project01.entity.Product;
import com.ronald.project01.payload.param.ProductConditionEnum;
import com.ronald.project01.repository.mapper.ProductMapper;
import com.ronald.project01.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> getProducts() {
        return productMapper.getProducts();
    }

    @Override
    public List<Product> getProducts(Double requestPrice, ProductConditionEnum productConditionEnum) {

        if (productConditionEnum.equals(ProductConditionEnum.GREATER_THAN)) {
            return productMapper.getProductByPriceWhereGreater(requestPrice);
        }

        if (productConditionEnum.equals(ProductConditionEnum.LESS_THAN)) {
            return productMapper.getProductByPriceWhereLess(requestPrice);
        }

        return productMapper.getProductByPriceWhereEqual(requestPrice);
    }
}
