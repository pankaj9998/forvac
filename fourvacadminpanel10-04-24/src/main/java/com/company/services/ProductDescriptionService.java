package com.company.services;

import com.company.entity.ProductDescription;
import java.util.List;

public interface ProductDescriptionService {
    void saveProductDescription(ProductDescription productDescription);
    ProductDescription getProductDescriptionById(Long id);
    List<ProductDescription> getAllProductDescriptions();
    void deleteProductDescriptionById(Long id);
}
