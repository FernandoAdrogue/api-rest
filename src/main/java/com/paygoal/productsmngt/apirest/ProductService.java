package com.paygoal.productsmngt.apirest;

import com.paygoal.productsmngt.apirest.model.Product;
import com.paygoal.productsmngt.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public Product getProductByName(String name){
        Optional<Product> optionalProduct = productRepository.findByNombre(name);
        return optionalProduct.orElse(null);
    }

    public Product updateProduct(Long id, Product updateProduct){

        Product existProduct = productRepository.findById(id).orElse(null);
        if (existProduct != null) {
            updateProduct.setId(id);

            existProduct.setNombre(updateProduct.getNombre());
            existProduct.setDescripcion(updateProduct.getDescripcion());
            existProduct.setPrecio(updateProduct.getPrecio());
            existProduct.setCantidad(updateProduct.getCantidad());

            return productRepository.save(existProduct);
        }
        return null;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAllByOrderByPrecioAsc();
    }

    public Boolean deleteProduct(Long id) {
        Product existProduct = productRepository.findById(id).orElse(null);
        if (existProduct != null) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
