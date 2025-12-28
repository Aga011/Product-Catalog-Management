package com.Aga.Agali.controller.product;

import com.Aga.Agali.dto.request.ProductCreateRequest;
import com.Aga.Agali.dto.response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface IProductController {
    ProductResponse createProduct(@Valid ProductCreateRequest request);

    ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(Long id,@Valid ProductCreateRequest request);

    void deleteProduct(Long id);
}
