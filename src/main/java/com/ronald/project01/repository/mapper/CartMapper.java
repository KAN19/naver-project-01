package com.ronald.project01.repository.mapper;

import com.ronald.project01.payload.dto.DetailedCartItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import static com.ronald.project01.repository.mapper.SqlCommand.Get_DetailCartItem_By_ProductName_And_Offset_And_Limit;

@Mapper
public interface CartMapper {
    @Select(Get_DetailCartItem_By_ProductName_And_Offset_And_Limit)
    @Results(value = {
            @Result(property = "productName", column = "product_name"),
            @Result(property = "quantityWished", column = "quantity_wished"),
            @Result(property = "totalAmount", column = "total_amount"),
            @Result(property = "dateAdded", column = "date_added"),
    })
    List<DetailedCartItemDto> getCartItemByProductNameAndOffset(Long customerId, String productName, Integer offset, Integer limit);
}
