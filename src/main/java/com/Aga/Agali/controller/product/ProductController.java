package com.Aga.Agali.controller.product;

import com.Aga.Agali.dto.request.ProductCreateRequest;
import com.Aga.Agali.dto.response.ProductResponse;
import com.Aga.Agali.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/products")
public class ProductController implements IProductController{
    private final IProductService productService;

    @Override
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
        return productService.createProduct(request);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ProductResponse getProductById(@PathVariable(value = "id") Long id) {
        return productService.getProductById(id);
    }

    @Override
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse updateProduct(@PathVariable(value = "id") Long id,@RequestBody ProductCreateRequest request) {
        return productService.updateProduct(id,request);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable(value = "id") Long id) {
        productService.deleteProduct(id);

    }
}
