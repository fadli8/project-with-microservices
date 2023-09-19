package com.shop.shop_microservices.services;

import com.shop.shop_microservices.entities.ProductEntity;
import com.shop.shop_microservices.entities.requestes.ProductRequest;
import com.shop.shop_microservices.entities.response.ProductResponse;
import com.shop.shop_microservices.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository produitRepository ;
    // Method get should return a list of ProductResponse
    public List<ProductResponse> getListLProducts(){
        List<ProductEntity> list = this.produitRepository.findAll();
        return list.stream().map(this::mapingToProductResponse).toList();
    }

    // This method mapping from ProductEntity to ProductResponse
    public ProductResponse mapingToProductResponse(ProductEntity product){
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }
    public ProductEntity createProduct(ProductRequest requestBody){
        ProductEntity product = ProductEntity
                .builder().name(requestBody.getName()).description(requestBody.getDescription()).price(requestBody.getPrice()).status(requestBody.getStatus()).build();

        return this.produitRepository.save(product);
    }

    public ProductEntity updateProduct(ProductEntity productRequest){
        return this.produitRepository.save(productRequest);
    }


}
