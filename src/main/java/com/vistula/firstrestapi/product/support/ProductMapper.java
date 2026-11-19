package com.vistula.firstrestapi.product.support;

import com.vistula.firstrestapi.product.api.request.ProductRequest;
import com.vistula.firstrestapi.product.api.request.UpdateProductRequest;
import com.vistula.firstrestapi.product.api.response.ProductResponse;
import com.vistula.firstrestapi.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        return product;
    }

    public ProductResponse toItemResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }

    public Product toProduct(Product product, UpdateProductRequest request) {
        product.setName(request.getName());
        return product;
    }
}