package com.ronald.project01.service.impl;

import com.ronald.project01.entity.Cart;
import com.ronald.project01.entity.CartItem;
import com.ronald.project01.entity.Customer;
import com.ronald.project01.entity.Product;
import com.ronald.project01.payload.dto.AddingItemToCartDto;
import com.ronald.project01.payload.dto.DetailedCartItemDto;
import com.ronald.project01.payload.dto.ProductInCartDto;
import com.ronald.project01.repository.CartItemRepository;
import com.ronald.project01.repository.CartRepository;
import com.ronald.project01.repository.CustomerRepository;
import com.ronald.project01.repository.ProductRepository;
import com.ronald.project01.repository.mapper.CartMapper;
import com.ronald.project01.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Resource
    private CartMapper cartMapper;

    @Override
    public AddingItemToCartDto addItem(AddingItemToCartDto addingItemToCartDto) {

        Optional<Customer> customerOptional = customerRepository.findById(addingItemToCartDto.getCustomerId());

        if (customerOptional.isEmpty()) {
            throw new RuntimeException("Invalid customer");
        }

        Cart customerCart = this.createCustomerCart(customerOptional.get());

        addingItemToCartDto.getProductList().forEach(item -> {
            Optional<Product> addingProduct = this.getProductIfExist(item);

            if(addingProduct.isPresent() && item.getQuantity() > 0) {
               Optional<CartItem> cartItemOptional = this.findItemByProductAndCart(customerCart, addingProduct.get());

               if (cartItemOptional.isPresent()) {
                   CartItem cartItem = cartItemOptional.get();
                   Integer updatingQuantity = cartItem.getQuantityWished() + item.getQuantity();
                   Double totalAmount = addingProduct.get().getPrice() * updatingQuantity;

                   cartItem.setQuantityWished(updatingQuantity);
                   cartItem.setTotalAmount(totalAmount);
                   cartItem.setDateAdded(LocalDate.now());
                   cartItemRepository.save(cartItem);
               } else {
                   CartItem newCartItem = CartItem.builder()
                           .cart(customerCart)
                           .product(addingProduct.get())
                           .quantityWished(item.getQuantity())
                           .dateAdded(LocalDate.now())
                           .totalAmount(item.getQuantity() * addingProduct.get().getPrice())
                           .build();
                   cartItemRepository.save(newCartItem);
               }

            } else {
                throw new RuntimeException("Invalid product!");
            }

        });

        return addingItemToCartDto;
    }

    @Override
    public List<DetailedCartItemDto> getCartItemByNameProductWithOffset(Long customerId, String nameProduct, Integer offset, Integer limit) {
        return cartMapper.getCartItemByProductNameAndOffset(customerId, '%'+ nameProduct + '%', offset, limit);
    }

    private Optional<CartItem> findItemByProductAndCart(Cart customerCart, Product item) {
        CartItem CartItem = cartItemRepository.findCartItemByCartAndProduct(customerCart, item);

        return Optional.ofNullable(CartItem);
    }

    private Optional<Product> getProductIfExist(ProductInCartDto item) {
        return productRepository.findById(item.getProductId());
    }

    private Cart createCustomerCart(Customer customer) {
        if (customer.getCart() == null) {
            customer.setCart(cartRepository.save(new Cart()));
        }
        return customer.getCart();
    }
}
