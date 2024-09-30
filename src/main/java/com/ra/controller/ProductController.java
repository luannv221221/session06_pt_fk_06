package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.category.CategoryService;
import com.ra.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "product/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        // lấy về danh sách danh mục chuyển sang view mà hiển thị
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "product/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute Product product){
        if(productService.create(product)){
            return "redirect:/product";
        }
        return "redirect:/product/add";
    }
}
