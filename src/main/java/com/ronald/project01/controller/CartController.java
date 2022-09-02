package com.ronald.project01.controller;

import com.ronald.project01.payload.BaseResponse;
import com.ronald.project01.payload.dto.AddingItemToCartDto;
import com.ronald.project01.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/cart")
@Slf4j
@Tag(name = "Cart Services")
public class CartController {

    @Autowired
    private CartService cartService;

    @Operation(summary = "Add product to cart by customer_id and product_id (Q3&4)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Add product Ok",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content =  { @Content(mediaType = "application/json") })})
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody AddingItemToCartDto addingItemToCartDto) {
        if (addingItemToCartDto.getProductList().isEmpty()) {
            ResponseEntity.badRequest().body(BaseResponse.error("Please add product"));
        }
        log.info("Inside add item method");

        return ResponseEntity.ok(BaseResponse.success(cartService.addItem(addingItemToCartDto)));
    }

    @Operation(summary = "Get products from cart with name_product, offset and limit (Q5)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get products successfully",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content =  { @Content(mediaType = "application/json") })})
    @GetMapping("/search")
    public ResponseEntity<?> getItemInCartByNameAndOffset(@RequestParam("customer_id") Long customerId,
                                                          @RequestParam("name_product") String nameProduct,
                                                          @RequestParam("offset") Integer offset,
                                                          @RequestParam("limit") Integer limit) {
        log.info("Inside get by name and offset");

        return ResponseEntity.ok().body(BaseResponse.success(cartService.getCartItemByNameProductWithOffset(customerId, nameProduct, offset, limit)));
    }


}
