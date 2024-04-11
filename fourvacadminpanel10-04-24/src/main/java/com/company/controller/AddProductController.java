package com.company.controller;

import com.company.entity.ProductDescription;
import com.company.repository.CategoryRepository;
import com.company.services.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddProductController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductDescriptionService productDescriptionService;

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("productDescriptions", productDescriptionService.getAllProductDescriptions());
        model.addAttribute("productDescription", new ProductDescription());
        return "add_product";
    }

    @PostMapping("/addProduct")
    public String addProduct(ProductDescription productDescription) {
        productDescriptionService.saveProductDescription(productDescription);
        return "redirect:/addProduct";
    }

//    @GetMapping("/editProduct/{id}")
//    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
//        ProductDescription productDescription = productDescriptionService.getProductDescriptionById(id);
//        model.addAttribute("productDescription", productDescription);
//        model.addAttribute("categories", categoryRepository.findAll());
//        return "edit_product";
//    }
//
//    @PostMapping("/updateProduct/{id}")
//    public String updateProduct(@PathVariable("id") Long id, ProductDescription productDescription, Model model) {
//        productDescription.setId(id);
//        productDescriptionService.saveProductDescription(productDescription);
//        return "redirect:/addProduct";
//    }

    
    
    @GetMapping("/editProduct/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        ProductDescription productDescription = productDescriptionService.getProductDescriptionById(id);
        model.addAttribute("productDescription", productDescription);
        model.addAttribute("categories", categoryRepository.findAll());
        return "edit_product";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") Long id, ProductDescription productDescription, Model model) {
        productDescription.setId(id);
        productDescriptionService.saveProductDescription(productDescription);
        return "redirect:/addProduct";
    }
    
    
    
    
    
    
    
    
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productDescriptionService.deleteProductDescriptionById(id);
        return "redirect:/addProduct";
    }
}
