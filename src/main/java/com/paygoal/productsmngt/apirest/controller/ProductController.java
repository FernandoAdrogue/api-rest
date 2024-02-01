package com.paygoal.productsmngt.apirest.controller;

import com.paygoal.productsmngt.apirest.ProductService;
import com.paygoal.productsmngt.apirest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product creteProduct(Product product){
       return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Product searchProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("{name}")
    public Product searchProductByName(@PathVariable("name") String name){
        return productService.getProductByName(name);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product updateProduct){
        return productService.updateProduct(id, updateProduct);
    }

    @DeleteMapping("{id}")
    public void deleteProductPyId(@PathVariable("id") Long id){

        productService.deleteProduct(id);
    }
}
