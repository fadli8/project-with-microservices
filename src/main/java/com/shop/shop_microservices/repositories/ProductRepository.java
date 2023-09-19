package com.shop.shop_microservices.repositories;

import com.shop.shop_microservices.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
