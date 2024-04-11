package com.company.services;

import com.company.entity.ProductDescription;
import com.company.repository.ProductDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    @Autowired
    private ProductDescriptionRepository productDescriptionRepository;

    @Override
    public void saveProductDescription(ProductDescription productDescription) {
        productDescriptionRepository.save(productDescription);
    }

    @Override
    public ProductDescription getProductDescriptionById(Long id) {
        Optional<ProductDescription> productDescriptionOptional = productDescriptionRepository.findById(id);
        return productDescriptionOptional.orElse(null);
    }

    @Override
    public List<ProductDescription> getAllProductDescriptions() {
        return productDescriptionRepository.findAll();
    }

    @Override
    public void deleteProductDescriptionById(Long id) {
        productDescriptionRepository.deleteById(id);
    }
}
