package com.shop.shop_microservices.controllers;

import com.shop.shop_microservices.entities.ProductEntity;
import com.shop.shop_microservices.entities.requestes.ProductRequest;
import com.shop.shop_microservices.entities.response.ProductResponse;
import com.shop.shop_microservices.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public List<ProductResponse> getListProducts(){

        return this.productService.getListLProducts();
    }

    @PostMapping("/create")
    @ResponseBody
    public ProductEntity createProduct(@RequestBody ProductRequest request){
        return this.productService.createProduct(request);
    }

    @PutMapping("/update")
    @ResponseBody
    public ProductEntity updateProduct(@RequestBody ProductRequest requestBody){
        ProductEntity product = ProductEntity.builder()
                .name(requestBody.getName())
                .description(requestBody.getDescription())
                .price(requestBody.getPrice())
                .build();
        return this.productService.updateProduct(product);
    }


}
