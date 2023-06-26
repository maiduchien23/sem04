package com.example.productmanager.controller;

import com.example.productmanager.entity.Product;
import com.example.productmanager.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService theProductService) {
        productService = theProductService;
    }

    @GetMapping("/list")
    public String listProducts(Model theModel){
        List<Product> theProduct = productService.findAll();

        theModel.addAttribute("products", theProduct);

        return "products/list-products";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Product theProduct = new Product();

        theModel.addAttribute("product", theProduct);

        return "products/products-add";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int theId, Model theModel) {
        Product theProduct = productService.findById(theId);

        theModel.addAttribute("product", theProduct);

        return "products/products-update";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product theProduct) {
        productService.save(theProduct);
        return "redirect:/products/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int theId) {
        productService.deleteById(theId);
        return "redirect:/products/list";
    }
}