package com.Aga.Agali.service.product;

import com.Aga.Agali.dto.request.ProductCreateRequest;
import com.Aga.Agali.dto.response.ProductResponse;


import java.util.List;

public interface IProductService {
    ProductResponse createProduct(ProductCreateRequest request);

    ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(Long id, ProductCreateRequest request);

    void deleteProduct(Long id);
}
