//package com.company.services;
//
//import com.company.entity.ProductImg;
//
//import java.util.List;
//
//public interface ProductImgService {
//    List<ProductImg> getAllProducts();
//    ProductImg getProductById(Long id);
//    ProductImg addProduct(ProductImg product);
//    ProductImg updateProduct(ProductImg product);
//    void deleteProductImg(Long id);
//}


package com.company.services;

import com.company.entity.ProductImg;

import java.util.List;

public interface ProductImgService {
    List<ProductImg> getAllProducts();
    ProductImg getProductById(Long id);
    ProductImg addProduct(ProductImg product);
    ProductImg updateProduct(ProductImg product);
    void deleteProductImg(Long id);
}
