package com.ronald.project01.service;

import com.ronald.project01.entity.Cart;
import com.ronald.project01.entity.CartItem;
import com.ronald.project01.payload.dto.AddingItemToCartDto;
import com.ronald.project01.payload.dto.DetailedCartItemDto;

import java.util.List;

public interface CartService {

    AddingItemToCartDto addItem(AddingItemToCartDto addingItemToCartDto);

    List<DetailedCartItemDto> getCartItemByNameProductWithOffset(Long customerId, String nameProduct, Integer offset, Integer limit);
}
