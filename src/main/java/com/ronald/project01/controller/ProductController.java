package com.ronald.project01.controller;

import com.ronald.project01.payload.BaseResponse;
import com.ronald.project01.payload.param.ProductConditionEnum;
import com.ronald.project01.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@Slf4j
@Tag(name = "Product Services")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get products (Q2)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get product successfully",
                    content = { @Content(mediaType = "application/json") })})
    @GetMapping
    public ResponseEntity<?> getProducts(@RequestParam(value = "price", required = false) Optional<Double> requestPrice,
                                         @Parameter(description = "less_than || greater_than || equal")
                                            @RequestParam(value = "condition", required = false) Optional<String> condition) {

        if (requestPrice.isPresent() && condition.isPresent()) {
            ProductConditionEnum productConditionEnum = ProductConditionEnum.valueOf(condition.get().toUpperCase());
            return ResponseEntity.ok(BaseResponse.success(productService.getProducts(requestPrice.get(), productConditionEnum)));
        }

        return ResponseEntity.ok(BaseResponse.success(productService.getProducts()));
    }
}
