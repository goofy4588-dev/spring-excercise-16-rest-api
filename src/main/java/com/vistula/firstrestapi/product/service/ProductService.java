package com.vistula.firstrestapi.product.service;

import com.vistula.firstrestapi.product.api.request.ProductRequest;
import com.vistula.firstrestapi.product.api.request.UpdateProductRequest;
import com.vistula.firstrestapi.product.api.response.ProductResponse;
import com.vistula.firstrestapi.product.domain.Product;
import com.vistula.firstrestapi.product.repository.ProductRepository;
import com.vistula.firstrestapi.product.support.ProductExceptionSupplier;
import com.vistula.firstrestapi.product.support.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        Product saved = productRepository.save(product);
        return productMapper.toItemResponse(saved);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toItemResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toItemResponse)
                .toList();
    }

    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        ProductResponse before = productMapper.toItemResponse(product);
        productRepository.save(productMapper.toProduct(product, request));
        return before;
    }

    public void delete(Long id) {
        productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(id);
    }
}