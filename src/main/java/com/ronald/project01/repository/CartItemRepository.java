package com.ronald.project01.repository;

import com.ronald.project01.entity.Cart;
import com.ronald.project01.entity.CartItem;
import com.ronald.project01.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findCartItemByCartAndProduct(Cart cart, Product product);
}
