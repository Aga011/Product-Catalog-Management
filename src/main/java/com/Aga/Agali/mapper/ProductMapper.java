package com.Aga.Agali.mapper;

import com.Aga.Agali.dto.request.ProductCreateRequest;
import com.Aga.Agali.dto.response.ProductResponse;
import com.Aga.Agali.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductMapper {

    public Product toEntity(ProductCreateRequest request) {
        if (request == null) {
            return null;
        }

        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();
    }
    public void updateEntity(Product product, ProductCreateRequest request) {
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());
    }

    public ProductResponse toResponse(Product product) {
        if (product == null) {
            return null;
        }

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .active(product.getActive())
                .createdAt(product.getCreatedAt())
                .build();
    }
}