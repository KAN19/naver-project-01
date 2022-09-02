package com.ronald.project01.repository.mapper;

import com.ronald.project01.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM PRODUCT ")
    @Results(value = {
        @Result(property = "productId", column = "product_id"),
        @Result(property = "price", column = "price"),
        @Result(property = "productName", column = "product_name"),
        @Result(property = "quantity", column = "quantity"),
        @Result(property = "size", column = "size"),
        @Result(property = "type", column = "type"),
    })
    List<Product> getProducts();

    @Select("SELECT * FROM PRODUCT WHERE price > #{requestPrice} ")
    @Results(value = {
            @Result(property = "productId", column = "product_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "size", column = "size"),
            @Result(property = "type", column = "type"),
    })
    List<Product> getProductByPriceWhereGreater(Double requestPrice);

    @Select("SELECT * FROM PRODUCT WHERE price < #{requestPrice} ")
    @Results(value = {
            @Result(property = "productId", column = "product_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "size", column = "size"),
            @Result(property = "type", column = "type"),
    })
    List<Product> getProductByPriceWhereLess(Double requestPrice);

    @Select("SELECT * FROM PRODUCT WHERE price = #{requestPrice} ")
    @Results(value = {
            @Result(property = "productId", column = "product_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "size", column = "size"),
            @Result(property = "type", column = "type"),
    })
    List<Product> getProductByPriceWhereEqual(Double requestPrice);
}
