package com.project.shop.projectshop.busibess.product;

import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.product.ProductEntity;
import com.project.shop.projectshop.model.product.requset.CreateProductRequest;
import com.project.shop.projectshop.repository.product.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductBusiness {
    private @Autowired ProductRepository productRepository;

    public ProductEntity getProductByIdOrElseThrowIfNotExist(Long id) throws ValidateException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ValidateException("Product id " + id + " not found"));
    }

    public ProductEntity saveProduct(CreateProductRequest request, Long userId) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setCreatedBy(userId);
        newProduct.setUpdatedBy(userId);
        newProduct.setName(request.getName());
        newProduct.setKey(request.getKey());
        newProduct.setDetail(request.getDetail());
        newProduct.setUnitAmount(request.getUnitAmount());
        newProduct.setPrice(request.getPrice());
        newProduct.setIsDeleted(request.getIsDeleted() == null ? Boolean.FALSE : request.getIsDeleted());
        if (request.getId() != null) {
            newProduct.setId(request.getId());
        }
        return productRepository.save(newProduct);
    }
}
