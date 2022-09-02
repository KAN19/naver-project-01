package com.ronald.project01.controller;

import com.ronald.project01.payload.BaseResponse;
import com.ronald.project01.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Services")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        return ResponseEntity.ok().body(BaseResponse.success(customerService.getCustomers()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(BaseResponse.success(customerService.getCustomerById(id)));
    }


}
