package com.example.Spring_jpa_product.controller;

import com.example.Spring_jpa_product.model.Product;
import com.example.Spring_jpa_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String indexPage()
    {
        return "index";
    }

    @GetMapping("/addProduct")
    public String mainPage(Model model)
    {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product,RedirectAttributes redirectAttributes)
    {
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message","Data saved successfully");
        return "redirect:/addProduct";
    }

    @GetMapping("/displayAllProducts")
    public String  displayAll(Model model)
    {
        List<Product> productList=productService.displayAll();
        model.addAttribute("productList",productList);
        return "displayAll";
        //return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/get/{category}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable String category)
    {
        return new ResponseEntity<>(productService.findByCategory(category),HttpStatus.OK);
    }

}
