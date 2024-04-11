package com.company.services;

import com.company.entity.ProductImg;
import com.company.repository.ProductImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImgServiceImpl implements ProductImgService {

    @Autowired
    private ProductImgRepository productImgRepository;

    @Override
    public List<ProductImg> getAllProducts() {
        return productImgRepository.findAll();
    }

    @Override
    public ProductImg getProductById(Long id) {
        return productImgRepository.findById(id).orElse(null);
    }

    @Override
    public ProductImg addProduct(ProductImg product) {
        return productImgRepository.save(product);
    }

    @Override
    public ProductImg updateProduct(ProductImg product) {
        return productImgRepository.save(product);
    }

    @Override
    public void deleteProductImg(Long id) {
        productImgRepository.deleteById(id);
    }
}
