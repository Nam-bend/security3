package com.example.security2.controller;

import com.example.security2.dto.ReqRes;
import com.example.security2.entity.Product;
import com.example.security2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AdminUser {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/public/product")
    public ResponseEntity<Object> getAllProduct() {

        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping("/admin/saveproduct")
    public ResponseEntity<Object> signUp(@RequestBody ReqRes productRequest){
        Product productToSave = new Product() ;
        productToSave.setName(productRequest.getName());
        return ResponseEntity.ok(productRepo.save(productToSave));
    }
    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone() {

        return ResponseEntity.ok("User alone  can access this api only ");
    }

    @GetMapping("/admin_user/both")
    public ResponseEntity<Object> bothAdminAndUsersApi() {

        return ResponseEntity.ok("Both admin and user can access the api ");
    }
}
