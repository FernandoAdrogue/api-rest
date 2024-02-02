package com.paygoal.productsmngt.apirest.controller;

import com.paygoal.productsmngt.apirest.ProductService;
import com.paygoal.productsmngt.apirest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product creteProduct(@RequestBody Product product){
       return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> searchProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        if(product != null){
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> searchProductByName(@PathVariable("name") String name){
        Product product = productService.getProductByName(name);
        if(product != null){
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product updateProduct){
        Product product = productService.updateProduct(id, updateProduct);
        if(product != null){
            return ResponseEntity.ok(updateProduct);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProductPyId(@PathVariable("id") Long id){
        Boolean deleted = productService.deleteProduct(id);

        if(deleted){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
