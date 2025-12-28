package com.Aga.Agali.service.product;

import com.Aga.Agali.dto.request.ProductCreateRequest;
import com.Aga.Agali.dto.response.ProductResponse;
import com.Aga.Agali.entity.Product;
import com.Aga.Agali.mapper.ProductMapper;
import com.Aga.Agali.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse createProduct(ProductCreateRequest request) {
        Product product = productMapper.toEntity(request);
        productRepository.save(product);
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product tapılmadı"));
        return productMapper.toResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public ProductResponse updateProduct(Long id, ProductCreateRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product tapılmadı"));

        productMapper.updateEntity(product, request);
        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product tapılmadı");
        }
        productRepository.deleteById(id);
    }
}